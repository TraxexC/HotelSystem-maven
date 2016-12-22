package data.service;

import PO.LoginPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginDataService extends Remote {

    public boolean confirm(String userId, String userPassword) throws RemoteException;

    public boolean add(LoginPO login) throws RemoteException;

    public boolean delete(LoginPO login) throws RemoteException;

    public boolean update(LoginPO login) throws RemoteException;

    public LoginPO findByID(String userID) throws RemoteException;

}
