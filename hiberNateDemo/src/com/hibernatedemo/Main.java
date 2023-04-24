package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			//Unit of work
			session.beginTransaction();
			
			//HQL Hibernate Query LAnguage
			//select * from city
			//from City c where c.countryCode='TUR' AND c.district='Ankara' 
			// ASC Ascending  A-Z ye
			//DESC Descending Z-A ya
			
			//List<City> cities = session.createQuery("from City c ORDER BY c.name DESC").getResultList();
			
			/*
			 * List<String> countryCodes = session.
			 * createQuery("select c.countryCode from City c GROUP BY c.countryCode ").
			 * getResultList();
			 * 
			 * for(String countryCode:countryCodes) { System.out.println(countryCode); }
			 */
			
			//INSERT
//			City city=new City();
//			city.setName("Düzce 10");
//			city.setCountryCode("TUR");
//			city.setDistrict("Karadeniz");
//			city.setPopulation(100000);
			
//			session.save(city);
			
			//UPDATE
//			City city=session.get(City.class,4087);
//			city.setPopulation(110000);
//			
//			session.save(city);
//			
			//CRUD Create Read Update Delete
			
			//DELETE
			City city=session.get(City.class, 4087);
			session.delete(city);
			
			
			session.getTransaction().commit();
			System.out.println("Şehir güncellendi");
			
		} finally {
			factory.close();
			
		}

	}

}
