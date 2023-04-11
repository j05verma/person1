package org.jsp.person.controller;

import java.util.Scanner;

import org.jsp.person.dao.PersonDao;
import org.jsp.person.dto.Person;

public class PersonController {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.err.println("1. ResiterDetails \n2. UpdateDetails \n3. ViewDetails \n4. DeleteDetails");
		System.out.println("choice the number");
		int choice=sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter your name");
			String name=sc.next();
			System.out.println("Enter your email");
			String email=sc.next();
			System.out.println("Enter your phone");
			long phone=sc.nextLong();
			System.out.println("Enter your password");
			String password=sc.next();
			
			Person p=new Person();
			p.setName(name);
			p.setEmail(email);
			p.setPhone(phone);
			p.setPassword(password);
			PersonDao dao=new PersonDao();
			p=dao.Register(p);
			break;
			
			case 2:
				System.out.println("Enter the Id to update record");
				int id=sc.nextInt();
				System.out.println("Enter your name");
				String name1=sc.next();
				System.out.println("Enter your email");
				String email1=sc.next();
				System.out.println("Enter your phone");
				long phone1=sc.nextLong();
				System.out.println("Enter your password");
				String password1=sc.next();
				
				Person p1=new Person();
				p1.setId(id);
				p1.setName(name1);
				p1.setEmail(email1);
				p1.setPhone(phone1);
				p1.setPassword(password1);
				PersonDao dao1=new PersonDao();
				p=dao1.update(p1);
				break;
				
			case 3:
				System.out.println("Enter your phone");
				long ph=sc.nextLong();
				System.out.println("Enter your password");
				String pass=sc.next();
				Person p2=new Person();
				PersonDao dao2=new PersonDao();
				p2=dao2.viewDetails(ph, pass);
				break;
				
			case 4:
				System.out.println("Enter your id to delete record");
				int id2=sc.nextInt();
				PersonDao dao3=new PersonDao();
				if(dao3.delete(id2)==true)
				{
					dao3.delete(id2);
					System.out.println("ID: "+id2+" is record deleted");
				}
				else
				{
					System.out.println("ID: "+id2+" is not found");
				}
				break;

		default:
			System.out.println("choice : "+ choice+" is not valid");
			System.exit(0);
			break;
		}
	}

}
