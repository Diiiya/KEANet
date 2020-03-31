import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PurchaseTest {
	
	Purchase object;
	List<String> _cellPhones;
	
	@Before
	public void BeforeTest() {
		//Runs before every test
		//Arrange
		_cellPhones = new ArrayList();
		_cellPhones.add("iPhone 99");
		_cellPhones.add("Motorola G99");
				
		object = new Purchase(true, 1, _cellPhones, 7150);
	}
	
	@Test
	public void testDecrementingTheNumberOfPhoneLines_returnsDecrementedPrice() {
		//Here we test if the total price decreases when user decreases the phone lines
		
		//Test cases pass: 1,4,7,8     => Total price should be decreased by 150
		//test cases fail: -10,-1,0,9,15  => Total price not changed
				
		//Arrange
		int[] testPhoneLines= {-10,-1,0,1,4,7,8,9,15}; //test cases
		
		for(int item : testPhoneLines) {
			//Act
			object.set_phoneLines(item);			
			int totalPrice = object.DecrementingTheNumberOfPhoneLines();
			
			//Assert
			if(item > 0 && item < 9) {
				assertEquals(7000, totalPrice);
				object.set_price(7150); //we have to reset the value, because it would decrease every time
			}
			else {
				assertEquals(7150, totalPrice);
			}
		}
	}
	
	@Test
	public void testUnselectingACellPhone_returnDecrementedPrice() {
		//Here we test if the selected cellPhone is removed from the array
		
		//Arrange
		_cellPhones.add("Motorola G99"); //We have 3 object in the list, twice Motorola 
		//(to test if client can add more than 1 of kind and then to remove just one, not all with this name)
		
		//Act
		int totalPrice = object.UnselectingACellPhone("iPhone 99"); //7150 - 6000 expected
		
		//Assert
		assertEquals(1150, totalPrice); //checks if price has changed
		assertFalse(_cellPhones.contains("iPhone 99")); //checks if the phone got removed from the list
			
		//Act	
		int notChangedTotalPrice = object.UnselectingACellPhone("");
		
		//Assert
		assertEquals(1150, notChangedTotalPrice); //checks if price did not change (with empty object)
		assertEquals(2, _cellPhones.size()); //checks if it did not remove any objects from the list (with empty object)
		
		//Act
		int totalPriceAfterDeletingOnlyOneMotorola = object.UnselectingACellPhone("Motorola G99"); //1150 - 800
				
		//Assert
		assertEquals(350, totalPriceAfterDeletingOnlyOneMotorola); //checking if only 1 object will be deleted from the list, not all of the kind		
		assertEquals(1, _cellPhones.size()); //checking if it removed only 1 object
	}
	
	@Test
	public void testBuying_returnStringAlert() {
		//Here we test we alert we get after pressing "Buy" button
		
		//Act
		String myReceipt = object.Buying();
		
		//Arrange
		_cellPhones.clear();
		Purchase emptyObject = new Purchase(false, 0, _cellPhones, 0);
		//Act
		String myAlert = emptyObject.Buying();
		
		//Assert
		assertEquals("Nothing Selected", myAlert);  //checks what happens when nothing is selected
		assertNotEquals("Nothing Selected", myReceipt); //checks what happens when something is selected
	}
}
