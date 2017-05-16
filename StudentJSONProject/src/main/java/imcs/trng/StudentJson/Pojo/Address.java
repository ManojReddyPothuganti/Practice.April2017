package imcs.trng.StudentJson.Pojo;

public class Address {
	
	private enum Type{
		HOME,WORK
	}
	
	private Type type;
	private String street;
	private String city;
	private String state;
	public Address(Type type, String street, String city, String state) {
		super();
		this.type = type;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	public Address() {
		super();
	}
	public Type getType() {
		return type;
	}
	public void setType(String type) {
		this.type = Type.valueOf(type);
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [type=" + type + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	

}
