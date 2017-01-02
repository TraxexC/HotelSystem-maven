package Test;

import main.ClientRunner;
import org.junit.Test;
import other.IdGernerateServiceImpl;

import static org.junit.Assert.assertEquals;

public class IdGernerateTester {

	ClientRunner clientRunner =  new ClientRunner();
	@Test
	public void testgreID(){
		String  a = IdGernerateServiceImpl.gernerateId();
		assertEquals(false,a=="134");
	}
}
