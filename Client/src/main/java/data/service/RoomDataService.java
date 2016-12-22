package data.service;

/**
 * Created by Chen on 2016/12/23.
 */

import PO.RoomPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RoomDataService extends Remote {
    public ArrayList<RoomPO> getAllRoomPO(String hotelid) throws RemoteException;

    public RoomPO findRoomPO(String roomID) throws RemoteException;

    public boolean modify(RoomPO roomPO) throws RemoteException;

    public boolean addRoom(RoomPO roomPO) throws RemoteException;
}

