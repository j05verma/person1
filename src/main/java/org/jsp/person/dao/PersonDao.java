package org.jsp.person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.person.dto.Person;

public class PersonDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	
	public Person Register(Person person)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(person);
		transaction.begin();
		transaction.commit();
		return person;
	}
	public Person update(Person person)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(person);
		transaction.begin();
		transaction.commit();
		return person;
	}
	public Person viewDetails(long phone, String password)
	{
		String qry="select p from Person p where p.phone=?1 and p.password=?2";
		Query q=manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<Person> persons=q.getResultList();
		if(persons.size()>0)
		{
			for(Person p :persons) {
			System.out.println("ID: "+p.getId());
			System.out.println("Name: "+p.getName());
			System.out.println("Email: "+p.getEmail());
			System.out.println("Phone Number: "+p.getPhone());
			}
		}
		return null;
	}
	
	public boolean delete(int id)
	{
		Person p=manager.find(Person.class, id);
		if(p!=null)
		{
			manager.remove(p);
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

}
