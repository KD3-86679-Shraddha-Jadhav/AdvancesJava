package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

public class TestJPQLCtorExpression {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			//create user dao instance
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter age and batting avg");
			teamDao.getOwnerAbbri(
					sc.nextInt(),sc.nextDouble()
					).forEach(test -> System.out.println(test.getAbbreviation()+" "+test.getOwner()));
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
