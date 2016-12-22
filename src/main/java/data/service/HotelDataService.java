package data.service;

import PO.HotelPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HotelDataService extends Remote {
    public boolean add(HotelPO hotel) throws RemoteException;

    public boolean del(HotelPO hotel) throws RemoteException;

    public HotelPO find(String hotelId) throws RemoteException;

    public boolean update(HotelPO hotel) throws RemoteException;

    public ArrayList<HotelPO> getHotels(String strict) throws RemoteException;

    public ArrayList<HotelPO> getAllHotels() throws RemoteException;
}
