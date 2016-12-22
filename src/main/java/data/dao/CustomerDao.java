package data.dao;

import PO.CustomerPO;

import java.util.ArrayList;

public interface CustomerDao {
    public boolean addCustomer(CustomerPO customer);

    public boolean deleteCustomer(CustomerPO customer);

    public boolean updateCustomer(CustomerPO customer);

    public CustomerPO findCustomer(String customerID);

    public ArrayList<CustomerPO> getAllCustomers();
}
