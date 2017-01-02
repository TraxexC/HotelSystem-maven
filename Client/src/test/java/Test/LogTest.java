package Test;

import VO.LogofUserVO;
import blservice.LogOfUser_blServce;
import blservice.impl.LogOfUser_blServceImpl;
import main.ClientRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogTest {

    ClientRunner cli = new ClientRunner();
    LogOfUser_blServce lo = new LogOfUser_blServceImpl();

    @Test
    public void test001add() {
        LogofUserVO logofUserVO = new LogofUserVO();
        logofUserVO.setContent("Ìí¼Ó10");
        logofUserVO.setDateTime(LocalDateTime.now());
        logofUserVO.setUserid("183");
        assertEquals(true, lo.addLogOfUser(logofUserVO));
    }

    @Test
    public void test002get() {
        ArrayList<LogofUserVO> arrayList = lo.getAllLogsOfUser("183");
        assertEquals(1, arrayList.size());
    }
}
