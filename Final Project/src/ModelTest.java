import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class ModelTest {
	
	Garden G = new Garden();
   
   @Test
   public void testRateGarden() {	
      System.out.println("Testing rateGarden");    
      assertEquals(0, rateGarden(G));     
   }
}
