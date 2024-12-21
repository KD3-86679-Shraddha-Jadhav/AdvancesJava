package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

public class DisplayAllTeams {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()) {
			//create user dao instance
			TeamDao userDao = new TeamDaoImpl();
			userDao.getAllTeams().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
