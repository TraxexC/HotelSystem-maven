package data.dao;

import PO.SuperVipPO;

import java.util.ArrayList;

public interface SuperVipDao {

    public boolean addSupVip(SuperVipPO po);

    public boolean modifySupVip(SuperVipPO po);

    public ArrayList<SuperVipPO> getStrict(String disstrict);
}
