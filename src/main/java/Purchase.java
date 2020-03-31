import java.util.List;
import java.util.ArrayList;

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
		return _price + 200;
	}
	
	public int AddPhoneLine() {
		return _price + 150;
	}
	
	public int SelectCellPhone(String phoneModel) {
		return _price;
	}

	
	public int DecrementingTheNumberOfPhoneLines() {
		if(get_phoneLines() > 0 && get_phoneLines() < 9) {
			set_phoneLines(get_phoneLines() - 1);
			set_price(get_price() - 150);
		}
		return get_price();
			
	}
	
	public int UnselectingACellPhone(String _modelName) {
		//to further development: what if there are few phones with the same name
		if(get_cellPhones().size() != 0) {
			for (int i=0; i<get_cellPhones().size(); i++) 
			{ 
			    if(get_cellPhones().get(i) == _modelName) {
			    	get_cellPhones().remove(i);
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
