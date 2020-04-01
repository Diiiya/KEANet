import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PurchaseTest {
	
	Purchase purchaseObject;
	List<String> cellPhones;
	
	@Before
	public void BeforeTest() {
		//Runs before every test
		//Arrange
		cellPhones = new ArrayList();
		cellPhones.add("iPhone 99");
		cellPhones.add("Motorola G99");
				
		purchaseObject = new Purchase(true, 1, cellPhones, 7150);
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
			purchaseObject.set_phoneLines(item);			
			int totalPrice = purchaseObject.DecrementingTheNumberOfPhoneLines();
			
			//Assert
			if(item > 0 && item < 9) {
				assertEquals(7000, totalPrice);
				purchaseObject.set_price(7150); //we have to reset the value, because it would decrease every time
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
		cellPhones.add("Motorola G99"); //We have 3 object in the list, twice Motorola 
		//(to test if client can add more than 1 of kind and then to remove just one, not all with this name)
		
		//Act
		int totalPrice = purchaseObject.UnselectingACellPhone("iPhone 99"); //7150 - 6000 expected
		
		//Assert
		assertEquals(1150, totalPrice); //checks if price has changed
		assertFalse(cellPhones.contains("iPhone 99")); //checks if the phone got removed from the list
			
		//Act	
		int notChangedTotalPrice = purchaseObject.UnselectingACellPhone("");
		
		//Assert
		assertEquals(1150, notChangedTotalPrice); //checks if price did not change (with empty object)
		assertEquals(2, cellPhones.size()); //checks if it did not remove any objects from the list (with empty object)
		
		//Act
		int totalPriceAfterDeletingOnlyOneMotorola = purchaseObject.UnselectingACellPhone("Motorola G99"); //1150 - 800
				
		//Assert
		assertEquals(350, totalPriceAfterDeletingOnlyOneMotorola); //checking if only 1 object will be deleted from the list, not all of the kind		
		assertEquals(1, cellPhones.size()); //checking if it removed only 1 object
	}
	
	@Test
	public void testBuying_returnStringAlert() {
		//Here we test we alert we get after pressing "Buy" button
		
		//Act
		String myReceipt = purchaseObject.Buying();
		
		//Arrange
		cellPhones.clear();
		Purchase emptyObject = new Purchase(false, 0, cellPhones, 0);
		//Act
		String myAlert = emptyObject.Buying();
		
		//Assert
		assertEquals("Nothing Selected", myAlert);  //checks what happens when nothing is selected
		assertNotEquals("Nothing Selected", myReceipt); //checks what happens when something is selected
	}
	
	@Test
	public void testIncludeInternedConnection() {
		purchaseObject = new Purchase(false, 0, cellPhones, 0);	
		purchaseObject.InExcludeInternedConnection(true);			

		int expectedPrice = 200;
		int actualPrice = purchaseObject.get_price();		

		assertEquals(expectedPrice, actualPrice);
	}
	
	@Test
	public void testExcludeInternedConnection() {
		purchaseObject = new Purchase(true, 0, cellPhones, 200);
		purchaseObject.InExcludeInternedConnection(false);			

		int expectedPrice = 0;
		int actualPrice = purchaseObject.get_price();		

		assertEquals(expectedPrice, actualPrice);
	}
	
	@Test
	public void testAddPhoneLine_TwoLines_PriceChanges() {
		purchaseObject = new Purchase(true, 0, cellPhones, 200);
		purchaseObject.AddPhoneLine();
		purchaseObject.AddPhoneLine();
		
		int expectedPrice = 500;
		int actualPrice = purchaseObject.get_price();	

		assertEquals(expectedPrice, actualPrice);
	}
	
	@Test
	public void testAddPhoneLine_TwoLines_NumOfLinesChanges() {
		purchaseObject = new Purchase(true, 0, cellPhones, 200);
		purchaseObject.AddPhoneLine();
		purchaseObject.AddPhoneLine();		

		int expectedNumberPhoneLines = 2;
		int actualNumberPhoneLines = purchaseObject.get_phoneLines();		

		assertEquals(expectedNumberPhoneLines, actualNumberPhoneLines);
	}	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPhoneLine_TooManyLines_Exception() {
		purchaseObject = new Purchase(true, 8, cellPhones, 200);
		purchaseObject.AddPhoneLine();
	}
	
	@Test
	public void testSelectCellPhone_PriceChanges() {
		purchaseObject = new Purchase(true, 2, cellPhones, 500);
		purchaseObject.SelectCellPhone("Samsung Galaxy 99");
		purchaseObject.SelectCellPhone("Samsung Galaxy 99");
		
		int expectedPrice = 2500;
		int actualPrice = purchaseObject.get_price();

		assertEquals(expectedPrice, actualPrice);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testTooManyPhonesSelected_Exception() {
		for(int i=0; i < 8; i++) {
			cellPhones.add("Samsung Galaxy 99");
		}
		
		purchaseObject = new Purchase(true, 2, cellPhones, 500);
		purchaseObject.SelectCellPhone("Samsung Galaxy 99");
	}
}
