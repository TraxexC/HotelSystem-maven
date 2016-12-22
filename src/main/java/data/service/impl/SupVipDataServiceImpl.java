package data.service.impl;

import PO.SuperVipPO;
import data.dao.DataFactory;
import data.dao.SuperVipDao;
import data.dao.impl.DataFactoryImpl;
import data.service.SuperVipDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SupVipDataServiceImpl implements SuperVipDataService {

    private DataFactory dataFactory;
    private SuperVipDao dao;

    public SupVipDataServiceImpl() {
        dataFactory = new DataFactoryImpl();
        dao = dataFactory.getSuovipdao();
    }

    public boolean addSupVip(SuperVipPO po) throws RemoteException {
        return dao.addSupVip(po);
    }

    public boolean modifySupVip(SuperVipPO po) throws RemoteException {
        return dao.modifySupVip(po);
    }

    public ArrayList<SuperVipPO> getStrict(String disstrict) throws RemoteException {
        return dao.getStrict(disstrict);
    }

}
