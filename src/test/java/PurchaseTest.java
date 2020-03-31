import static org.junit.Assert.*;

import org.junit.Test;

public class PurchaseTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//Test cases pass: 1,4,7,8     => Total price should be decreased by 150
	//test cases fail: -10,-1,0,9,15  => Total price not changed
	@Test
	public void testDecrementingTheNumberOfPhoneLines_returnsDecrementedPrice() {
		//Arrange
		String[] _cellPhones = new String[2];
		_cellPhones[0] = "iPhone 99";
		_cellPhones[1] = "Motorola G99";
		
		Purchase object = new Purchase(true, 1, _cellPhones, 7150); //fake object
		int[] testPhoneLines= {-10,-1,0,1,4,7,8,9,15}; //test cases
		
		for(int item : testPhoneLines) {
			object.set_phoneLines(item);
			int totalPrice = object.DecrementingTheNumberOfPhoneLines();
			
			if(item > 0 && item < 9) {
				assertEquals(7000, totalPrice);
			}
			else {
				assertEquals(7150, totalPrice);
			}
		}
	}
	
	@Test
	public void testUnselectingACellPhone_returnDecreasedPrice() {
		//Arrange
		//Act
		//Assert
	}

}
