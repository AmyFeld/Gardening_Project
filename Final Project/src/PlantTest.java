import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

/**
 * This class is meant to test the functions within the Plant class
 * 
 * @author Tara Fishman 
 *
 */

public class PlantTest {
	
	Plant p1 = new Plant("Dogwood","tree",240,true,"medium","pink",3,5);
	Plant p2 = new Plant("Maple-leaf Arrowwood","shrub",60,true,"medium","white",4,8);
	Plant p3 = new Plant("Green & Gold","herb",6,false,"low","yellow",4,10);
	
	@Test
   	public void testGetName1() {
		System.out.println("Testing getName() for p1");
		assertEquals(p1.getName(), "Dogwood");
	}
	
	@Test
   	public void testGetName2() {
		System.out.println("Testing getName() for p2");
		assertEquals(p2.getName(), "Maple-leaf Arrowwood");
	}
	
	@Test
   	public void testGetName3() {
		System.out.println("Testing getName() for p3");
		assertEquals(p3.getName(), "Green & Gold");
	}
	
	@Test
   	public void testGetImgNameOriginal1() {
		System.out.println("Testing original case for getImgName for p1");
		assertEquals(p1.getImgName("original"), "file:plantImg/Dogwood.jpg");
	}
	
	@Test
   	public void testGetImgNameOriginal2() {
		System.out.println("Testing original case for getImgName for p2");
		assertEquals(p2.getImgName("original"), "file:plantImg/Maple-leaf_Arrowwood.jpg");
	}
	
	@Test
   	public void testGetImgNameOriginal3() {
		System.out.println("Testing original case for getImgName for p3");
		assertEquals(p3.getImgName("original"), "file:plantImg/Green_&_Gold.jpg");
	}
	
	@Test
	public void testGetImgNameSpring1() {
		System.out.println("Testing spring case for getImgName for p1");
		assertEquals(p1.getImgName("spring"), "file:seasonImages/springPlants/Dogwood.jpg");
	}
	
	@Test
	public void testGetImgNameSpring2() {
		System.out.println("Testing spring case for getImgName for p2");
		assertEquals(p2.getImgName("spring"), "file:seasonImages/springPlants/Maple-leaf_Arrowwood.jpg");
	}
	
	@Test
	public void testGetImgNameSpring3() {
		System.out.println("Testing spring case for getImgName for p3");
		assertEquals(p3.getImgName("spring"), "file:seasonImages/springPlants/Green_&_Gold.jpg");
	}
	
	@Test
	public void testGetImgNameFall1() {
		System.out.println("Testing fall case for getImgName for p1");
		assertEquals(p1.getImgName("fall"), "file:seasonImages/fallPlants/Dogwood.jpg");
	}
	
	@Test
	public void testGetImgNameFall2() {
		System.out.println("Testing fall case for getImgName for p2");
		assertEquals(p2.getImgName("fall"), "file:seasonImages/fallPlants/Maple-leaf_Arrowwood.jpg");
	}
	
	@Test
	public void testGetImgNameFall3() {
		System.out.println("Testing fall case for getImgName for p3");
		assertEquals(p3.getImgName("fall"), "file:seasonImages/fallPlants/Green_&_Gold.jpg");
	}
	
	@Test
	public void testGetImgNameWinter1() {
		System.out.println("Testing winter case for getImgName for p1");
		assertEquals(p1.getImgName("winter"), "file:seasonImages/winterPlants/Dogwood.jpg");
	}
	
	@Test
	public void testGetImgNameWinter2() {
		System.out.println("Testing winter case for getImgName for p2");
		assertEquals(p2.getImgName("winter"), "file:seasonImages/winterPlants/Maple-leaf_Arrowwood.jpg");
	}
	
	@Test
	public void testGetImgNameWinter3() {
		System.out.println("Testing winter case for getImgName for p2");
		assertEquals(p3.getImgName("winter"), "file:seasonImages/winterPlants/Green_&_Gold.jpg");
	}
	
	@Test
	public void testScaling1() {
		System.out.println("Testing scaling function for tree type");
		assertEquals(p1.scaling(), 150);
	}
	
	@Test
	public void testScaling2() {
		System.out.println("Testing scaling function for shrub type");
		assertEquals(p2.scaling(), 100);
	}
	
	@Test
	public void testScaling3() {
		System.out.println("Testing scaling function for herb type");
		assertEquals(p3.scaling(), 50);
	}
	
}