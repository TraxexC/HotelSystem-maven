package testAll;


import PO.HotelStrategyPO;
import data.service.HotelStrategyDataService;
import data.service.impl.HotelStrategyDataServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelstrategyTs {
    HotelStrategyDataService hotel = new HotelStrategyDataServiceImpl();

    @Test
    public void test001add() throws Exception {
        HotelStrategyPO hotst = new HotelStrategyPO();
        hotst.setHotelID("123456");
        hotst.setHotelStrategyInfo("�Ƶ�11������");
        hotst.setId("123");
        assertEquals(true, hotel.add(hotst));
    }

    @Test
    public void test002update() throws Exception {
        HotelStrategyPO host = new HotelStrategyPO();
        host.setHotelID("123456");
        host.setHotelStrategyInfo("�Ƶ�11�°����Ż�");
        host.setId("123");
        assertEquals(true, hotel.modify(host));
    }

    @Test
    public void test003find() throws Exception {
        String di = "123456";
        assertEquals("�Ƶ�11�°����Ż�", hotel.getAll(di).get(0).getHotelStrategyInfo());
    }

    @Test
    public void test004del() throws Exception {
        HotelStrategyPO hotst = new HotelStrategyPO();
        hotst.setHotelID("123456");
        hotst.setHotelStrategyInfo("�Ƶ�11������");
        hotst.setId("123");
        assertEquals(true, hotel.delete(hotst));
    }
}
