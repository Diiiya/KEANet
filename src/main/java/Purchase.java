import java.util.List;
import java.util.ArrayList;

public class Purchase {
	
	private Boolean _internetConnection;	
	private int _phoneLines;
	private String[] _cellPhones;
	private int _price;	
	
	public Boolean get_internetConnection() {
		return _internetConnection;
	}
	public void set_internetConnection(Boolean _internetConnection) {
		this._internetConnection = _internetConnection;
	}
	public int get_phoneLines() {
		return _phoneLines;
	}
	public void set_phoneLines(int _phoneLines) {
		this._phoneLines = _phoneLines;
	}
	public String[] get_cellPhones() {
		return _cellPhones;
	}
	public void set_cellPhones(String[] _cellPhones) {
		this._cellPhones = _cellPhones;
	}
	public int get_price() {
		return _price;
	}
	public void set_price(int _price) {
		this._price = _price;
	}
	

	//phones that client chose
	List<String> _myPhones = new ArrayList();
	public List<String> get_myPhones() {
		return _myPhones;
	}
	public void set_myPhones(List<String> _myPhones) {
		this._myPhones = _myPhones;
	}
	
	//Catalog of the phones
	List<Phone> _phoneCatalog = new ArrayList();
	private void set_phoneCatalog(List<Phone> _phoneCatalog) {		
		Phone p1;
		Phone p2;
		Phone p3;
		Phone p4;
		Phone p5;
		
		p1 = new Phone("Motorola G99", 800);
		p2 = new Phone("iPhone 99", 6000);
		p3 = new Phone("Samsung Galaxy 99", 1000);
		p4 = new Phone("Sony Xperia 99", 900);
		p5 = new Phone("Huawei 99", 900);

		_phoneCatalog.add(p1);
		_phoneCatalog.add(p2);
		_phoneCatalog.add(p3);
		_phoneCatalog.add(p4);
		_phoneCatalog.add(p5);
		
		this._phoneCatalog = _phoneCatalog;
	}
	
	private List<Phone> get_phoneCatalog(){
		return _phoneCatalog;
	}
	
	
	public Purchase(Boolean _internetConnection, int _phoneLines, String[] _cellPhones, int _price) {
		super();
		this._internetConnection = _internetConnection;
		this._phoneLines = _phoneLines;
		this._cellPhones = _cellPhones;
		this._price = _price;
	}
	
	
	public int DecrementingTheNumberOfPhoneLines() {
		if(get_phoneLines() != 0) {
			set_phoneLines(_phoneLines - 1);
			set_price(_price - 150);
		}
		return get_price();
			
	}
	
	public int UnselectingACellPhone(String _modelName) {
		if(get_myPhones().size() != 0) {
			for (int i=0; i<get_myPhones().size(); i++) 
			{ 
			    if(get_myPhones().get(i) == _modelName) {
			    	get_myPhones().remove(i); //remove from array
			    	for(Phone item : get_phoneCatalog()) {
			    		//get Price from the catalog
			    		if(item.get_name() == _modelName) {
					    	//decrease price
			    			set_price(get_price()- item.get_price());
			    		}
			    	}
			    }
			}
		}
		return get_price();
	}
	
	public String Buying() {
		if((get_internetConnection() == false || get_internetConnection() == null) && get_phoneLines() == 0 &&  get_myPhones().size() == 0 && get_price() == 0) {
			return "Nothing Selected";
		}
		else {
			String myAlert = "You chose: ";
			
			if(get_internetConnection() == true) {
				myAlert += "Internet Connection, ";
			}
			if(get_phoneLines() > 0) {
				myAlert += get_phoneLines() + "7 Phone Lines,";
			}
			if(get_myPhones().size() > 0) {
				myAlert += "Phones that you chose: ";
				for(String item : get_myPhones()) {
					myAlert += item + ", ";
				}
			}
			myAlert += "Total Price: " + get_price();
			return myAlert;
		}
	}
}
