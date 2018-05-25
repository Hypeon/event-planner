package beans;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Event {
	
	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "datetime_of_event")
	private LocalDateTime dateTimeOfEvent;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;
	
	public Event() {
	}
	
	public Event(String name, String description, LocalDateTime dateTimeOfEvent, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.dateTimeOfEvent = dateTimeOfEvent;
		this.price = price;
		this.location = location;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getDateTimeOfEvent() {
		return dateTimeOfEvent;
	}
	
	public void setDateTimeOfEvent(LocalDateTime dateTimeOfEvent) {
		this.dateTimeOfEvent = dateTimeOfEvent;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Event{" +
					   "id=" + id +
					   ", name='" + name + '\'' +
					   ", description='" + description + '\'' +
					   ", dateTimeOfEvent=" + dateTimeOfEvent +
					   ", price=" + price +
					   ", location=" + location +
					   '}';
	}
}
