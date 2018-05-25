import beans.Event;
import beans.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        
        addEvent();
        
        
    }
	
	private static void addEvent() {
		
		
		Location location1 = new Location("location name", "Random Street 1", 1.1f, 1.2f);
  
		Event event1 = new Event("event name",
										"desc",
										LocalDateTime.now(),
										BigDecimal.valueOf(20000.22));
		
		try {
			SessionFactory sessionFactory = new Configuration()
												.configure()
												.addAnnotatedClass(Event.class)
												.addAnnotatedClass(Location.class)
												.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			event1.setLocation(location1);
			session.save(event1);
			session.getTransaction().commit();
			
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
    	
	}
}
