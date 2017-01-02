package testAll;

import PO.SystemStrategyPO;
import data.service.SystemStrategyDataService;
import data.service.impl.SystemStrategyDataServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import other.SystemStrategyType;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemstrategyTs {
    SystemStrategyDataService daa = new SystemStrategyDataServiceImpl();
    SystemStrategyPO systemstrategy = new SystemStrategyPO();

    @Test
    public void test001add() throws Exception {
        systemstrategy.setId("12345");
        systemstrategy.setDiscount(5);
        systemstrategy.setBegin_date(LocalDate.now());
        systemstrategy.setEnd_date(LocalDate.now());
        systemstrategy.setStrategyType(SystemStrategyType.HOLIDAY);
        assertEquals(true, daa.add(systemstrategy));
    }

    @Test
    public void test002upda() throws Exception {
        systemstrategy.setId("12345");
        systemstrategy.setSystemStrategy_name("Ë«Ê®12Ò»´ó´Ù");
        systemstrategy.setDiscount(0.8);
        assertEquals(true, daa.modify(systemstrategy));
    }

    @Test
    public void test004del() throws Exception {
        systemstrategy.setId("12345");
        assertEquals(true, daa.delete(systemstrategy));
    }
}
