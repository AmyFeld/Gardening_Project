import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

// The class is meant to test non void functions found in the model

public class ModelTest {
	
	Model model = new Model();
	
	Garden G = new Garden();
	Plant p = new Plant();
   
   	@Test
   	public void testRateGarden() {	
      		System.out.println("Testing rateGarden");    
      		assertEquals(0, model.rateGarden(G));     
   	}
	
	@Test
   	public void testGetGarden() {	
      		System.out.println("Testing getGarden"); 
      		assertEquals(model.currentGarden, model.getGarden());     
   	}
	
	@Test
   	public void testGetPlant() {	
      		System.out.println("Testing getPlant");    
      		assertEquals(model.currentPlant, model.getPlant());     
   	}
}
