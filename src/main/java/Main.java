import beans.Event;
import beans.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * -- Entity Lifecycle --
 * 	1. Detach - entity not associated with Hibernate session
 *  2. Merge - if entity detached, merge will reattach it to session
 *  3. Persist - transitions new entity do managed state;
 * 		next flush/commit will save it in db
 *  4. Remove - transitions entity to be removed;
 *  	next flush/commit will delete it from db
 *  5. Refresh - reload/sync object with data from db
 */

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
