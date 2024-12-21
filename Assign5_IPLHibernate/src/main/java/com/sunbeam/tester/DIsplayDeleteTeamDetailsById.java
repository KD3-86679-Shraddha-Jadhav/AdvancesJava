package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

public class DIsplayDeleteTeamDetailsById {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			//create team dao instance
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter id to delete team");
			System.out.println(teamDao.deleteTeamById(sc.nextLong()));
					
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
