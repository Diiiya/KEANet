
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
	
	public Purchase(Boolean _internetConnection, int _phoneLines, String[] _cellPhones, int _price) {
		super();
		this._internetConnection = _internetConnection;
		this._phoneLines = _phoneLines;
		this._cellPhones = _cellPhones;
		this._price = _price;
	}
	
}
