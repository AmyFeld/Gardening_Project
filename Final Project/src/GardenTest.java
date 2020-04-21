import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

// The class is meant to test non void functions found in the Garden class

public class GardenTest {
	
	Garden G = new Garden();
  
  @Test
  public void testCalculateHappiness(){
	  System.out.println("Testing HappinessRating");
	  assertEquals(0, calculateHappinessRating(G));
  }

  @Test
  public void testCalculateContBloomRating(){
	  System.out.println("Testing ContBloomRating");
	  assertEquals(0, calculateContBloomRating(G));
  }
	
  @Test
  public void testCalculateAnimalsFedRating(){
	  System.out.println("Testing AnimalsFedRating");
	  assertEquals(0, calculateAnimalsFedRating(G));
  }

  @Test
  public void testCalculateCompatibilityRating(){
	  System.out.println("Testing CompatibilityRating");
	  assertEquals(0, calculateCompatibilityRating(G));
  }
	
  @Test
  public void testCalculateTransitionRating(){
	  System.out.println("Testing TransitionRating");
	  assertEquals(0, calculateTransitionRating(G));
  }	
	
}
