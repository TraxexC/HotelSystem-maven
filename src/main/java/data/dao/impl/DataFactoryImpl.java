package data.dao.impl;

import data.dao.*;

public class DataFactoryImpl implements DataFactory {

    public AdviceFeedbackDao getAdviceFeedbackDao() {
        return new AdviceFeedbackDaoImpl();
    }

    public CustomerDao getCustomerDao() {
        return new CustomerDaoImpl();
    }

    public HotelDao getHotelDao() {
        return new HotelDaoImpl();
    }

    public HotelStaffDao getHotelStaffDao() {
        return new HotelStaffDaoImpl();
    }

    public HotelStrategyDao getHotelStrategyDao() {
        return new HotelStrategyDaoImpl();
    }

    public LoginDao getLoginDao() {
        return new LoginDaoImpl();
    }

    public OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }

    public SystemManagerDao getSystemManagerDao() {
        return new SystemManagerDaoImpl();
    }

    public SystemStaffDao getSystemStaffDao() {
        return new SystemStaffDaoImpl();
    }

    public SystemStrategyDao getSystemStrategyDao() {
        return new SystemStrategyDaoImpl();
    }

    public VipDao getVipDao() {
        return new VipDaoImpl();
    }

    public RoomDao getRoomDao() {
        return new RoomDaoImpl();
    }

    public AssessmentDao getAssessmentDao() {
        return new AssessmentDaoImpl();
    }

    public LabelDao getlabelDao() {
        return new LabelDaoImpl();
    }

    public SuperVipDao getSuovipdao() {
        return new SupVipDaoImpl();
    }

}
