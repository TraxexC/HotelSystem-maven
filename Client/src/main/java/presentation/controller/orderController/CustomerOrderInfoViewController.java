package presentation.controller.orderController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import VO.CustomerVO;
import VO.LogofUserVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import blservice.LogOfUser_blServce;
import blservice.Order_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;
import other.RoomType;
import util.ImageUtil;

public class CustomerOrderInfoViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button recallOrAssessment;// 撤销订单/评价订单
	@FXML
	private Button viewHotel;
	@FXML
	private Button back;
	@FXML
	private Label IdLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label nameOfHotel;
	@FXML
	private Label typeOfRoom;
	@FXML
	private Label numberOfRoom;
	@FXML
	private Label durationOfOrder;// 订单时长
	@FXML
	private Label timeOfArrive;
	@FXML
	private Label actualPayment;
	@FXML
	private Label stateOfOrder;
    @FXML
    private Label StateLabel;

	private Main mainScene;
	private CustomerVO customer;
	private OrderVO order;

	private Order_blservice OrderService;
	private Hotel_blservice hotelService;
    private LogOfUser_blServce logService;

	public CustomerOrderInfoViewController() {

	}

	public void initialize(Main main, CustomerVO customer, OrderVO orderVO) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer;
		this.order = orderVO;
		this.OrderService = new Order_bl();
		this.hotelService = new Hotel_bl();
        this.logService = new LogOfUser_blServceImpl();
        this.CustomerOrderInfoViewShow();
	}

	public void CustomerOrderInfoViewShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
        this.myPicture.setImage(ImageUtil.setImage(customer.getImage()));
        this.IdLabel.setText(this.customer.getId());
		this.nameLabel.setText(customer.getUsername());
		this.nameOfHotel.setText(this.hotelService.getHotelInfo(this.order.getHotelID()).getHotelName());
		// 确定是何种房间类型
		if (this.order.getRoomType().equals(RoomType.bigBedRoom))
			this.typeOfRoom.setText("大床房");
		else if (this.order.getRoomType().equals(RoomType.doublePersonRoom))
			this.typeOfRoom.setText("双人间");
		else if (this.order.getRoomType().equals(RoomType.singlePersonRoom))
			this.typeOfRoom.setText("单人间");
		else if (this.order.getRoomType().equals(RoomType.multiPersonRoom))
			this.typeOfRoom.setText("多人间");

		this.numberOfRoom.setText(String.valueOf(this.order.getRoomNum()));
		this.durationOfOrder.setText(String.valueOf(this.order.getLastime()));
		this.timeOfArrive.setText(util.DateUtil.format(this.order.getEntryTime()));
		this.actualPayment.setText(String.valueOf(this.order.getPrice()));
		this.controlRecallOrAssessment();
	}

	// 返回方法
    @FXML
    private void handleback() {
        this.mainScene.showCustomerOrderViewScene(customer);
	}

	// 评价或撤销按钮的控制方法
	private void controlRecallOrAssessment() {

		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("已执行");
			this.recallOrAssessment.setText("评价订单");
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			this.stateOfOrder.setText("待执行");
			this.recallOrAssessment.setText("撤销订单");
		} else if (this.order.getOrderState().equals(OrderState.ABNOMAL)) {
			this.stateOfOrder.setText("异常");
			this.recallOrAssessment.setText("撤销订单");
            this.recallOrAssessment.setDisable(true);
        } else if (this.order.getOrderState().equals(OrderState.REVACATION)) {
            this.stateOfOrder.setText("已撤销");
            this.recallOrAssessment.setText("撤销订单");
            this.recallOrAssessment.setDisable(true);
        } else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.stateOfOrder.setText("已评价");
            this.recallOrAssessment.setText("查看评价");
            this.recallOrAssessment.setDisable(false);
        }
	}

	// 评价或撤销按钮的监听方法
    @FXML
    private void handleRecallOrAssessment() {

		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("已执行");
			this.recallOrAssessment.setText("评价订单");
			this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
					this.order);
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
            if (!this.order.getEntryTime().minusDays(1).isBefore(LocalDate.now())) {
                this.order.setOrderState(OrderState.REVACATION);
                this.stateOfOrder.setText("已撤销");
                this.recallOrAssessment.setDisable(true);
                this.StateLabel.setText("已完成当前订单的撤销，信用值已扣除！");

                // 添加信用记录
                LogofUserVO logofUserVO = new LogofUserVO();
                logofUserVO.setChange((int) (-order.getPrice() * 0.5));
                logofUserVO.setContent("撤销订单" + this.order.getOrderID());
                logofUserVO.setDateTime(LocalDateTime.now());
                logofUserVO.setUserid(customer.getId());
                this.logService.addLogOfUser(logofUserVO);

                // bl层方法
                this.OrderService.changeState(this.order);
            } else {
                this.StateLabel.setText("无法撤销即将执行的订单！");
            }
        } else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
            this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
                    order);
        }
	}

	// 显示酒店的方法
    @FXML
    private void handleViewHotel() {
        this.mainScene.showCustomerHotelInfoScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()));
	}
}
