package beans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * -- Database related knowledge --
 *
 * 1. Cascade operations - the same operation is applied to related entities
 * 	E.g: If I delete Event, Location also should be deleted.
 *		Cascade Types: PERSIST, REMOVE, REFRESH, DETACH, MERGE, ALL
 *
 * 2. Fetch types:
 * 		Eager - retrieves everything
 * 		Lazy - retrieve on request
 *
 * 	3. Relationship directions:
 * 		- Uni-Directional - data can be accessed from
 * 		  only one of related entities
 * 		- Bi-Directional - data can be accessed from both related entities
 */

@Entity
public class Event {
	
	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	
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
	
	public int getEventId() {
		return eventId;
	}
	
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
					   "eventId=" + eventId +
					   ", name='" + name + '\'' +
					   ", description='" + description + '\'' +
					   ", dateTimeOfEvent=" + dateTimeOfEvent +
					   ", price=" + price +
					   ", location=" + location +
					   '}';
	}
}
