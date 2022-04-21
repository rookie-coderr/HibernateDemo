package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HIbernateUtil;

public class FindObjectClient {
	
	public static void main(String[] args) {
		Session session = HIbernateUtil.getSessionFactory().openSession();
		
		Transaction txn = session.getTransaction();
		
		try {
			
			txn.begin();
			
			Message message = session.get(Message.class, 21L);
			System.out.println(message);
			
			message.setText("Welcome to automatic dirty checking");
			
			txn.commit();
			
			
		} catch (Exception ex) {
			
		}
		
	
	}

}