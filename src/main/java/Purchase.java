import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Purchase {
	
	private Boolean _internetConnection;	
	private int _phoneLines;
	private List<String> _cellPhones;
	private int _price;	
	private List<Phone> _phoneCatalog = new ArrayList();
	
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
	public List<String> get_cellPhones() {
		return _cellPhones;
	}
	public void set_cellPhones(List<String> _cellPhones) {
		this._cellPhones = _cellPhones;
	}
	public int get_price() {
		return _price;
	}
	public void set_price(int _price) {
		this._price = _price;
	}	
	public void set_phoneCatalog() {		

		Phone p1 = new Phone("Motorola G99", 800);
		Phone p2 = new Phone("iPhone 99", 6000);
		Phone p3 = new Phone("Samsung Galaxy 99", 1000);
		Phone p4 = new Phone("Sony Xperia 99", 900);
		Phone p5 = new Phone("Huawei 99", 900);

		_phoneCatalog.addAll(Arrays.asList(p1, p2, p3, p4, p5));

	}		
	public List<Phone> get_phoneCatalog(){
		return _phoneCatalog;
	}
	
	
	public Purchase(Boolean _internetConnection, int _phoneLines, List<String> _cellPhones, int _price) {
		super();
		this._internetConnection = _internetConnection;
		this._phoneLines = _phoneLines;
		this._cellPhones = _cellPhones;
		this._price = _price;
		set_phoneCatalog();
	}
	

	public int InExcludeInternedConnection(boolean _internetConnection) {
		if (_internetConnection == true) {
			_price = _price + 200;
			return _price;
		}
		_price = _price - 200;
		return _price;
	}

	

	public int AddPhoneLine() {
		if (_phoneLines >= 0 && _phoneLines<= 7) { 
			_phoneLines = _phoneLines + 1;
			_price = _price + 150;
			return _price;
		}
		throw new IndexOutOfBoundsException("The number of phone lines cannot be greater than 8");
	}
	
	public int DecrementingTheNumberOfPhoneLines() {
		if(get_phoneLines() > 0 && get_phoneLines() < 9) {
			set_phoneLines(get_phoneLines() - 1);
			set_price(get_price() - 150);
		}
		return get_price();
			
	}
	
	public int SelectCellPhone(String modelName) {
		if (_cellPhones.size() >= 0 && _cellPhones.size() <= 7) { 
	    	for(Phone phone : get_phoneCatalog()) {
	    		if(phone.get_name() == modelName) {
	    			_cellPhones.add(phone.get_name());
	    			_price = _price + phone.get_price();	
	    			return _price;
	    		}
			}
		}
		throw new IndexOutOfBoundsException("The number of phone lines cannot be greater than 8");
	}
	
	public int UnselectingACellPhone(String _modelName) {
		if(get_cellPhones().size() != 0 && _modelName != "") {
			for (int i=0; i<get_cellPhones().size(); i++) 
			{ 
			    if(get_cellPhones().get(i) == _modelName) {
			    	get_cellPhones().remove(i);
			    	i = get_cellPhones().size() + 1; // to finish the loop, not to delete all with the same name
			    	for(Phone item : get_phoneCatalog()) {
			    		if(item.get_name() == _modelName) {
			    			set_price(get_price()- item.get_price());
			    		}
			    	}
			    }
			}
		}
		return get_price();
	}
	
	public String Buying() {
		String myAlert = "";
		if(get_internetConnection() == false && get_phoneLines() == 0 &&  get_cellPhones().size() < 1 && get_price() == 0) {
			myAlert = "Nothing Selected";
		}
		if(get_internetConnection() == true || get_phoneLines() != 0 ||  get_cellPhones().size() > 0 || get_price() != 0) {
			myAlert = "You chose: ";
			
			if(get_internetConnection() == true) {
				myAlert += "Internet Connection, ";
			}
			if(get_phoneLines() > 0) {
				myAlert += get_phoneLines() + " Phone Lines,";
			}
			if(get_cellPhones().size() > 0) {
				myAlert += "Phones that you chose: ";
				for(String item : get_cellPhones()) {
					myAlert += item + ", ";
				}
			}
			myAlert += "Total Price: " + get_price();
		}
		return myAlert;
	}

}
