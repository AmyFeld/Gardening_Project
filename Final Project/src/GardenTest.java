import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/**
 * This class is meant to test the functions within the Plant class
 * 
 * @author Tara Fishman 
 *
 */

public class GardenTest {

	Garden g = new Garden();
	
	@Test
	public void testCalculateColorRating1() {
		System.out.println("Testing calculateColorRating for rating 1");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		assertEquals(g.calculateColorRating(temp), 1);
	}
	
	@Test
	public void testCalculateColorRating2() {
		System.out.println("Testing calculateColorRating for rating 2");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Spice Bush","shrub",72,true,"medium","red",4,10));
		temp.add(new Plant("Green & Gold","herb",6,false,"low","yellow",4,10));
		assertEquals(g.calculateColorRating(temp), 2);
	}
	
	@Test
	public void testCalculateColorRating3() {
		System.out.println("Testing calculateColorRating for rating 3");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Spice Bush","shrub",72,true,"medium","red",4,10));
		temp.add(new Plant("Green & Gold","herb",6,false,"low","yellow",4,10));
		temp.add(new Plant("White Oak","tree",1200,false,"medium","green",4,5));
		temp.add(new Plant("Milkweed","herb",35,false,"low","purple",5,8));
		assertEquals(g.calculateColorRating(temp), 3);
	}
	
	@Test
	public void testCalculateColorRating4() {
		System.out.println("Testing calculateColorRating for rating 4");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Spice Bush","shrub",72,true,"medium","red",4,10));
		temp.add(new Plant("Green & Gold","herb",6,false,"low","yellow",4,10));
		temp.add(new Plant("White Oak","tree",1200,false,"medium","green",4,5));
		temp.add(new Plant("Milkweed","herb",35,false,"low","purple",5,8));
		temp.add(new Plant("Butterfly Weed","herb",24,false,"low","orange",5,9));
		temp.add(new Plant("Sweet Spire","shrub",42,false,"high","white",4,6));
		assertEquals(g.calculateColorRating(temp), 4);
	}
	
	@Test
	public void testCalculateColorRating5() {
		System.out.println("Testing calculateColorRating for rating 5");
		ArrayList<Plant> temp = g.allPlants;
		assertEquals(g.calculateColorRating(temp), 5);
	}
	
	@Test
	public void testCalculateContBloomRating1() {
		System.out.println("Testing calculateContBloomRating for rating 1");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		assertEquals(g.calculateContBloomRating(temp), 1);
	}
	
	@Test
	public void testCalculateContBloomRating2() {
		System.out.println("Testing calculateContBloomRating for rating 2");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Butterfly Weed","herb",24,false,"low","orange",5,8));
		assertEquals(g.calculateContBloomRating(temp), 2);
	}
	
	@Test
	public void testCalculateContBloomRating3() {
		System.out.println("Testing calculateContBloomRating for rating 3");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Butterfly Weed","herb",24,false,"low","orange",5,9));
		temp.add(new Plant("Goldenrod","shrub",36,false,"medium","yellow",8,9));
		assertEquals(g.calculateContBloomRating(temp), 3);
	}
	
	@Test
	public void testCalculateContBloomRating4() {
		System.out.println("Testing calculateContBloomRating for rating 4");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Butterfly Weed","herb",24,false,"low","orange",5,9));
		temp.add(new Plant("Goldenrod","shrub",36,false,"medium","yellow",8,11));
		assertEquals(g.calculateContBloomRating(temp), 4);
	}
	
	@Test
	public void testCalculateContBloomRating5() {
		System.out.println("Testing calculateContBloomRating for rating 5");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Serviceberry","tree",288,false,"medium","white",1,12));
		assertEquals(g.calculateContBloomRating(temp), 5);
	}
	
	@Test
	public void testCalculateAnimalsFedRating1() {
		System.out.println("Testing calculateAnimalsFedRating for rating 1");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		assertEquals(g.calculateContBloomRating(temp), 1);
	}
	
	@Test
	public void testCalculateAnimalsFedRating2() {
		System.out.println("Testing calculateAnimalsFedRating for rating 2");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count = 0;
		ArrayList<String> feedingplants = g.getFeedingPlants();
		for(Plant p : g.allPlants) {
			if (count >= 7) {
				break;
			}
			if(feedingplants.contains(p.name)) {
				temp.add(p);
				count++;
			}
		}
		assertEquals(g.calculateAnimalsFedRating(temp), 2);
	}
	
	@Test
	public void testCalculateAnimalsFedRating3() {
		System.out.println("Testing calculateAnimalsFedRating for rating 3");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count = 0;
		ArrayList<String> feedingplants = g.getFeedingPlants();
		for(Plant p : g.allPlants) {
			if (count >= 13) {
				break;
			}
			if(feedingplants.contains(p.name)) {
				temp.add(p);
				count++;
			}
		}
		assertEquals(g.calculateAnimalsFedRating(temp), 3);
	}
	
	@Test
	public void testCalculateAnimalsFedRating4() {
		System.out.println("Testing calculateAnimalsFedRating for rating 4");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count = 0;
		ArrayList<String> feedingplants = g.getFeedingPlants();
		for(Plant p : g.allPlants) {
			if (count >= 20) {
				break;
			}
			if(feedingplants.contains(p.name)) {
				temp.add(p);
				count++;
			}
		}
		assertEquals(g.calculateAnimalsFedRating(temp), 4);
	}
	
	@Test
	public void testCalculateAnimalsFedRating5() {
		System.out.println("Testing calculateAnimalsFedRating for rating 5");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		ArrayList<String> feedingplants = g.getFeedingPlants();
		for(Plant p : g.allPlants) {
			if(feedingplants.contains(p.name)) {
				temp.add(p);
			}
		}
		assertEquals(g.calculateAnimalsFedRating(temp), 4);
	}
	
	@Test
	public void testCalculateCompatibilityRating1() {
		System.out.println("Testing calculateCompatibilityRating for rating 1");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 10 && count1 == 10 && count3 == 10) {
				break;
			}
			if(p.waterUse.equals("medium") && count1 < 10) {
				temp.add(p);
				count1++;
			}else if(p.waterUse.equals("low") && count2 < 10) {
				temp.add(p);
				count2++;
			}else if(p.waterUse.equals("high") && count2 < 10) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateCompatibilityRating(temp),1);
	}
	@Test
	public void testCalculateCompatibilityRating2() {
		System.out.println("Testing calculateCompatibilityRating for rating 2");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 2 && count1 == 10 && count3 == 16) {
				break;
			}
			if(p.waterUse.equals("medium") && count1 < 10) {
				temp.add(p);
				count1++;
			}else if(p.waterUse.equals("low") && count2 < 2) {
				temp.add(p);
				count2++;
			}else if(p.waterUse.equals("high") && count2 < 16) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateCompatibilityRating(temp),2);
	}
	
	@Test
	public void testCalculateCompatibilityRating3() {
		System.out.println("Testing calculateCompatibilityRating for rating 3");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 0 && count1 == 20 && count3 == 10) {
				break;
			}
			if(p.waterUse.equals("medium") && count1 < 20) {
				temp.add(p);
				count1++;
			}else if(p.waterUse.equals("high") && count2 < 10) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateCompatibilityRating(temp),3);
	}
	
	@Test
	public void testCalculateCompatibilityRating4() {
		System.out.println("Testing calculateCompatibilityRating for rating 4");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 0 && count1 == 30 && count3 == 15) {
				break;
			}
			if(p.waterUse.equals("medium") && count1 < 30) {
				temp.add(p);
				count1++;
			}else if(p.waterUse.equals("high") && count2 < 15) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateCompatibilityRating(temp),4);
	}
	
	@Test
	public void testCalculateCompatibilityRating5() {
		System.out.println("Testing calculateCompatibilityRating for rating 5");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		assertEquals(g.calculateCompatibilityRating(temp),5);
	}
	
	@Test
	public void testCalculateTransitionRating1() {
		System.out.println("Testing calculateTransitionRating for rating 1");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		assertEquals(g.calculateTransitionRating(temp),1);
	}
	
	@Test
	public void testCalculateTransitionRating2() {
		System.out.println("Testing calculateTransitionRating for rating 2");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0,count2 = 0,count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 1 && count1 == 30 && count3 == 15) {
				break;
			}
			if(p.type.equals("tree") && count1 < 30) {
				temp.add(p);
				count1++;
			}else if(p.type.equals("herb") && count2 < 1) {
				temp.add(p);
				count2++;
			}else if(p.type.equals("shrub") && count3 < 15) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateTransitionRating(temp),2);
	}
	
	@Test
	public void testCalculateTransitionRating3() {
		System.out.println("Testing calculateTransitionRating for rating 3");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0,count2 = 0,count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 5 && count1 == 4 && count3 == 10) {
				break;
			}
			if(p.type.equals("tree") && count1 < 4) {
				temp.add(p);
				count1++;
			}else if(p.type.equals("herb") && count2 < 5) {
				temp.add(p);
				count2++;
			}else if(p.type.equals("shrub") && count3 < 10) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateTransitionRating(temp),3);
	}
	
	@Test
	public void testCalculateTransitionRating4() {
		System.out.println("Testing calculateTransitionRating for rating 4");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		int count1 = 0,count2 = 0,count3 = 0;
		for(Plant p : g.allPlants) {
			if(count2 == 11 && count1 == 10 && count3 == 9) {
				break;
			}
			if(p.type.equals("tree") && count1 < 10) {
				temp.add(p);
				count1++;
			}else if(p.type.equals("herb") && count2 < 11) {
				temp.add(p);
				count2++;
			}else if(p.type.equals("shrub") && count3 < 9) {
				temp.add(p);
				count3++;
			}
		}
		assertEquals(g.calculateTransitionRating(temp),4);
	}
	
	@Test
	public void testCalculateTransitionRating5() {
		System.out.println("Testing calculateTransitionRating for rating 1");
		ArrayList<Plant> temp = new ArrayList<Plant>();
		temp.add(new Plant("Dogwood","tree",240,true,"medium","pink",3,5));
		temp.add(new Plant("Butterfly Weed","herb",24,false,"low","orange",5,9));
		temp.add(new Plant("Goldenrod","shrub",36,false,"medium","yellow",8,9));
		assertEquals(g.calculateTransitionRating(temp),5);
	}
	
	@Test
	public void testFilterType() {
		System.out.println("Testing filter for case 'type'");
		ArrayList<Plant> answer = new ArrayList<Plant>();
		for(Plant p : g.allPlants) {
			if(p.type.equals("shrub")) {
				answer.add(p);
			}
		}
		assertEquals(g.Filter("type", "shrub", g.allPlants), answer);
	}
	
	@Test
	public void testFilterColor() {
		System.out.println("Testing filter for case 'color'");
		ArrayList<Plant> answer = new ArrayList<Plant>();
		for(Plant p : g.allPlants) {
			if(p.color.equals("red")) {
				answer.add(p);
			}
		}
		assertEquals(g.Filter("color", "red", g.allPlants), answer);
	}
	
	@Test
	public void testFilterHeight() {
		System.out.println("Testing filter for case 'height'");
		ArrayList<Plant> answer = new ArrayList<Plant>();
		for(Plant p : g.allPlants) {
			if(p.height >= 0 && p.height <= 120) {
				answer.add(p);
			}
		}
		assertEquals(g.Filter("height", "0", g.allPlants), answer);
	}
	
	@Test
	public void testFilterHasFruit() {
		System.out.println("Testing filter for case 'hasFruit'");
		ArrayList<Plant> answer = new ArrayList<Plant>();
		for(Plant p : g.allPlants) {
			if(p.hasFruit) {
				answer.add(p);
			}
		}
		assertEquals(g.Filter("hasFruit", "True", g.allPlants), answer);
	}
	
	@Test
	public void testFilterWaterUse() {
		System.out.println("Testing filter for case 'waterUse'");
		ArrayList<Plant> answer = new ArrayList<Plant>();
		for(Plant p : g.allPlants) {
			if(p.waterUse.equals("medium")) {
				answer.add(p);
			}
		}
		assertEquals(g.Filter("waterUse", "medium", g.allPlants), answer);
	}
	
	@Test
	public void testFilterStart() {
		System.out.println("Testing filter for case 'start'");
		ArrayList<Plant> answer = new ArrayList<Plant>();
		for(Plant p : g.allPlants) {
			if(p.start <= 4 && p.end>=4) {
				answer.add(p);
			}
		}
		assertEquals(g.Filter("start", "4", g.allPlants), answer);
	}
	
}
