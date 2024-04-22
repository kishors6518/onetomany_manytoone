package onetomany_manytoone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_manytoone.dto.BankAccount;
import onetomany_manytoone.dto.Person;

public class Main {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Piyush");
		p.setPhone(9874563210l);
		p.setAddress("Khed");
		List<BankAccount>list=new ArrayList<BankAccount>();
		
		BankAccount bac1=new BankAccount();
		bac1.setName("SBI");
		bac1.setIfsc("sbi@123");
		bac1.setBalance(5000000);
		bac1.setP(p);
		list.add(bac1);
		
		BankAccount bac2=new BankAccount();
		bac2.setName("ICCI");
		bac2.setIfsc("icci@123");
		bac2.setBalance(800000);
		bac2.setP(p);
		list.add(bac2);
		
		BankAccount bac3=new BankAccount();
		bac3.setName("AXIS");
		bac3.setIfsc("axis@123");
		bac3.setBalance(4000000);
		bac3.setP(p);
		list.add(bac3);
		
		BankAccount bac4=new BankAccount();
		bac4.setName("IDFC");
		bac4.setIfsc("idfc@123");
		bac4.setBalance(10000000);
		bac4.setP(p);
		list.add(bac4);
		
		p.setList(list);
		
		EntityManager manager=Persistence.createEntityManagerFactory("kishor").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(p);
		manager.persist(bac1);
		manager.persist(bac2);
		manager.persist(bac3);
		manager.persist(bac4);
		transaction.commit();
		
		

	}

}
