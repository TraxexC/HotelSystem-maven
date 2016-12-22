package data.dao;

import PO.SuperVipPO;
import PO.VipPO;

import java.util.ArrayList;

public interface VipDao {

    public boolean makeVip(VipPO vipPO);

    public VipPO getVip(int grade);

    public boolean updateVip(VipPO vipPO);

    public ArrayList<VipPO> getAllVips();

    public ArrayList<SuperVipPO> getAllSuperVips();
}
