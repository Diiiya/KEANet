
public class Phone {
	private String _name;
	private int _price;
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	
	public int get_price() {
		return _price;
	}
	public void set_price(int _price) {
		this._price = _price;
	}
	
	public Phone(String _name, int _price) {
		super();
		this._name = _name;
		this._price = _price;
	}
}
