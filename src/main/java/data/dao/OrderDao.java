package data.dao;

import PO.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderDao {

    public boolean add(OrderPO order);

    public boolean update(OrderPO order);

    public boolean dalete(OrderPO order);

    public OrderPO findorder(String orderId);

    public ArrayList<OrderPO> findOrders(String userId, String type);

    public ArrayList<OrderPO> getAllOrders();

    public ArrayList<OrderPO> getAllHotelOrders(String hotelid) throws RemoteException;
}

