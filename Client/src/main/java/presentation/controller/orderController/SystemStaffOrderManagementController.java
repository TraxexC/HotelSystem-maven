package presentation.controller.orderController;

import java.util.ArrayList;

import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.Order_blservice;
import blservice.impl.Order_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemStaffOrderManagementController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewOrderInfo;
	@FXML
	private Button back;
	// @FXML
	// private Label headLabel;
	@FXML
	private TextField searchInput;
	@FXML
	private Button searchButton;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> orderId;
	@FXML
	private TableColumn<OrderVO, String> hotelId;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// 到达时间
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// 订单时长

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> abnormalOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();// 声明

	public SystemStaffOrderManagementController() {
		order_blservice = new Order_bl();
	}

	// 初始化界面
	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {

        this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;

        abnormalOrderList = order_blservice.getAllAbnormalOrders();// 调用bl层getAbnoemalOrders方法获取异常订单
        for (OrderVO abnormalOrderVO : abnormalOrderList) {// 把所有的异常订单加到orderData
			orderData.add(abnormalOrderVO);
		}
		// 显示所有的异常订单
		customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// 添加所有的tableColumn
		hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
		orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
		// 在表格列上使用setCellValueFactory(...) 来确定为特定列使用orderData对象的某个属性.
		// 箭头 -> 表示我们在使用Java 8的 Lambdas 特性
		SystemStaffOrderManagementShow(mainScene);// 调用show
	}

	// 显示
	public void SystemStaffOrderManagementShow(Main mainScene) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
        myPicture.setImage(ImageUtil.setImage(this.systemStaffVO.getImage()));
        orderTable.setItems(orderData);
	}

	// 用private和@FXML保持私有性和安全
	// 查看订单处理
	@FXML
	private void handleViewOrderInfo(){
        OrderVO orderVO = this.orderTable.getSelectionModel().getSelectedItem();
        if (orderVO == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("提醒");
            alert.setContentText("请先选择订单后再进行操作");
            alert.showAndWait();
        } else {
            mainScene.showSystemStaffOrderViewScene(systemStaffVO, orderVO);
        }
    }
	@FXML
	//搜索功能
	private void handleSearch(){
		String orderId = searchInput.getText();
        if (orderId != null && !orderId.equals("")) {
            //该订单确实存在
			if (order_blservice.getOrder(orderId)!=null) {

                OrderVO myOrder = order_blservice.getOrder(orderId);
				orderData.add(myOrder);
				this.customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// 添加所有的tableColumn
				this.hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
				this.orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
				this.arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
				this.orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
				orderTable.setItems(orderData);
			}
			//该订单不存在
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("查找失败");
				alert.setContentText("非常遗憾，未能查询该订单信息！");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("查找失败");
			alert.setContentText("请输入订单ID！");
			alert.showAndWait();
		}
		
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}
}
