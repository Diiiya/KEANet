import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PurchaseTest2 {

	Purchase purchaseObject;
	List<String> cellPhones;
	
	@Before
	public void BeforeTest() {
		cellPhones = new ArrayList();

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
