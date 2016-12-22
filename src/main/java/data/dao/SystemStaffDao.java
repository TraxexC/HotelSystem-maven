package data.dao;


import PO.SystemStaffPO;

import java.util.ArrayList;

public interface SystemStaffDao {
    public boolean addStaff(SystemStaffPO staffPO);

    public boolean updateStaff(SystemStaffPO staffPO);

    public boolean deleteStaff(SystemStaffPO staffPO);

    public SystemStaffPO findStaff(String staffID);

    public ArrayList<SystemStaffPO> getAllSystemStaffs();
}
