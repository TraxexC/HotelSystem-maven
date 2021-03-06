package blservice;

import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;

public interface UserInfo_blservice {

	// 用户对于个人信息的修改
	public boolean modifyCustomer(CustomerVO customerVO);

	// 酒店工作人员对于个人信息的修改
	public boolean modifyHotelStaff(HotelStaffVO hotelStaffVO);

	// 对于网站营销人员的信息修改
	public boolean modifySystemStaff(SystemStaffVO systemStaffVO);

	// 对于网站管理人员的信息修改
	public boolean modifySystemManager(SystemManagerVO systemManagerVO);

	// 用于修改密码的方法
	public boolean modifyPassword(String userId, String password);
}
