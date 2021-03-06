package presentation.controller.userInfoController;

import java.util.Optional;

import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemManagerInfoModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
    private ImageView myPicture;
    @FXML
    private ImageView nowPic;
    @FXML
    private Button save;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private TextField nameLabel;
	@FXML
	private Button changePicture;
	@FXML
	private TextField phoneTextField;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemManagerVO systemManager;

	public SystemManagerInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main main, SystemManagerVO systemManager2) {

		this.mainScene = main;
		this.systemManager = systemManager2;
		this.SystemManagerInfoModifyShow();
	}

    @FXML
    private void SystemManagerInfoModifyShow() {
        leftIdLabel.setText(systemManager.getId());
		leftNameLabel.setText(systemManager.getUserName());
        myPicture.setImage(ImageUtil.setImage(this.systemManager.getImage()));
        nowPic.setImage(ImageUtil.setImage(this.systemManager.getImage()));
        idLabel.setText(systemManager.getId());
		nameLabel.setText(systemManager.getUserName());
        phoneTextField.setText(systemManager.getPhone());
    }

    @FXML
    private void handleSave() {

        this.systemManager.setUsername(this.nameLabel.getText());

        if ((!this.nameLabel.getText().equals("")) && (!this.phoneTextField.getText().equals(""))) {
            // bl层方法
            systemManager.setUsername(nameLabel.getText());
            systemManager.setPhone(phoneTextField.getText());
            this.blservice.modifySystemManager(systemManager);
            this.mainScene.showSystemManagerInfoScene(systemManager);
        } else if (nameLabel.getText().equals("")) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("警告");
            alert.setContentText("用户名为空，请输入您的用户名！");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("警告");
            alert.setContentText("您的联系方式为空，请输入您的联系方式");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleChange() {
        this.systemManager.setImage(ImageUtil.setImagePath(nowPic));
    }

    @FXML
    private void handleBack() {
        if (!nameLabel.getText().equals(systemManager.getUserName())
                || (!phoneTextField.getText().equals(systemManager.getPhone()))) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("提示");
            alert.setContentText("退出将不会保存您做出的修改，是否退出？");
            ButtonType yes = new ButtonType("是");
            ButtonType no = new ButtonType("否");
            alert.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> btn = alert.showAndWait();
            if (btn.get() == yes) {
                this.mainScene.showSystemManagerInfoScene(systemManager);
            }
        } else {
            this.mainScene.showSystemManagerInfoScene(systemManager);
        }
    }
}
