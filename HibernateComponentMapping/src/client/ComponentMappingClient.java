package client;

import org.hibernate.Session;

import entity.Address;
import entity.Person;
import util.HIbernateUtil;

public class ComponentMappingClient {

	public static void main(String[] args) {
		
		Session session = HIbernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Address homeAddress = new Address("2 Main Street", "NJ", "80912");
		Address billingAddress = new Address("1 Wall Street", "NY", "400012");
		Person max = new Person("max", homeAddress, billingAddress);
				
		session.save(max);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	
}