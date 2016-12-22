package data.service;

import PO.CustomerPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CustomerDataService extends Remote {
    public boolean addCustomer(CustomerPO customer) throws RemoteException;

    public boolean deleteCustomer(CustomerPO customer) throws RemoteException;

    public boolean updateCustomer(CustomerPO customer) throws RemoteException;

    public CustomerPO findCustomer(String customerID) throws RemoteException;

    public ArrayList<CustomerPO> getAllCustomers() throws RemoteException;
}
