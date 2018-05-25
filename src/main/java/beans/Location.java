package beans;

import javax.persistence.*;

@Entity
public class Location {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "lat")
	private float lattitude;
	
	@Column(name = "len")
	private float length;
	
	
	public Location() {
	}
	
	public Location(String name, String address, float lattitude, float length) {
		this.name = name;
		this.address = address;
		this.lattitude = lattitude;
		this.length = length;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public float getLattitude() {
		return lattitude;
	}
	
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	
	public float getLength() {
		return length;
	}
	
	public void setLength(float length) {
		this.length = length;
	}
	
}
