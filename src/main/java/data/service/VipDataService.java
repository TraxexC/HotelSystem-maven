package data.service;

import PO.VipPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VipDataService extends Remote {

    public boolean makeVip(VipPO vipPO) throws RemoteException;

    public VipPO getVip(int grade) throws RemoteException;

    public boolean updateVip(VipPO vipPO) throws RemoteException;

    public ArrayList<VipPO> getAllVips() throws RemoteException;

}
