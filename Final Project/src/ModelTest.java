import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;


/**
 * The class is meant to test functions within the Model class
 * 
 * @author Tara Fishman 
 *
 */

public class ModelTest {
	
	Model model = new Model();
	
	@Test
	public void testSetGarden() {
		System.out.println("Testing setGarden");
		Garden answer = new Garden();
		model.setGarden(answer);
		assertEquals(model.getGarden(), answer);
	}
	
	@Test
	public void testSetPlant() {
		System.out.println("Testing setPlant");
		Plant answer = new Plant("Dogwood","tree",240,true,"medium","pink",3,5);
		model.setPlant(answer);
		assertEquals(model.getPlant(), answer);
	}
	
	@Test
	public void testGetPlantByName() {
		System.out.println("Testing getPlantByName");
		Plant answer = new Plant("Dogwood","tree",240,true,"medium","pink",3,5);
		Plant observed = model.getPlantByName("Dogwood");
		assertEquals(observed.name, answer.name);
		assertEquals(observed.height, answer.height);
		assertEquals(observed.type, answer.type);
		assertEquals(observed.hasFruit, answer.hasFruit);
		assertEquals(observed.waterUse, answer.waterUse);
		assertEquals(observed.color, answer.color);
		assertEquals(observed.start, answer.start);
		assertEquals(observed.end, answer.end);
	}
	
	@Test
	public void testRateGarden1() {
		System.out.println("Testing rateGarden for empty garden");
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		answer.add(1);
		answer.add(1);
		answer.add(5);
		answer.add(1);
		answer.add(2);
		assertEquals(model.rateGarden(model.gridPlants), answer);
	}
	
	@Test
	public void testRateGarden2() {
		System.out.println("Testing rateGarden for all plants");
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(5);
		answer.add(5);
		answer.add(4);
		answer.add(2);
		answer.add(3);
		answer.add(4);
		assertEquals(model.rateGarden(model.allPlants), answer);
	}
	
	@Test
	public void testRateGarden3() {
		System.out.println("Testing rateGarden for every other plant");
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(4);
		answer.add(5);
		answer.add(2);
		answer.add(2);
		answer.add(3);
		answer.add(3);
		ArrayList<Plant> temp = new ArrayList<Plant>();
		for(Plant p : model.allPlants) {
			int index = model.allPlants.indexOf(p);
			if(index%2 == 0) {
				temp.add(p);
			}
		}
		assertEquals(model.rateGarden(temp), answer);
	}

	@Test
	public void testAddImageView1() {
		System.out.println("Testing addImageView for a tree");
		assertEquals(model.addImageView(0), 150);
	}
	
	@Test
	public void testAddImageView2() {
		System.out.println("Testing addImageView for a shrub");
		assertEquals(model.addImageView(1), 100);
	}
	
	@Test
	public void testAddImageView3() {
		System.out.println("Testing addImageView for an herb");
		assertEquals(model.addImageView(8), 50);
	}
	
	@Test
	public void testReset() {
		System.out.println("Testing reset");
		model.reset();
		assertEquals(model.startGardening, false);
		assertEquals(model.currentPlant, null);
	}
	
	@Test
	public void testSetY() {
		System.out.println("Testing setY");
		model.setY(100.0);
		assertEquals((int)model.getY(), 100);
	}
	
	@Test
	public void testSetX() {
		System.out.println("Testing setX");
		model.setX(100.0);
		assertEquals((int)model.getX(), 100);
	}
}
