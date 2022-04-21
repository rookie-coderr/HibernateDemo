package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HIbernateUtil;

public class TaskMergeClient {

	public static void main(String[] args) {
		
		try {
			
			Session session1 = HIbernateUtil.getSessionFactory().openSession();
			session1.getTransaction().begin();
			Message message1 = session1.get(Message.class, 22L);
			System.out.println(message1);
			session1.getTransaction().commit();
			session1.close();
			
			message1.setText("new changes - " + message1.getText());
			
			Session session2 = HIbernateUtil.getSessionFactory().openSession();
			session2.getTransaction().begin();
			Message message2 = session2.get(Message.class, 22L);
			session2.merge(message1);
			session2.getTransaction().commit();
			session2.close();
			
			
		} catch (Exception ex) {
			
		}
		
	
	}
}