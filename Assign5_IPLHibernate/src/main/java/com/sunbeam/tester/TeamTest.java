package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtils;
import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Team;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TeamTest {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)){
			
			//create dao instance
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter team details - String name, String abbreviation, String owner, int age, double batting_avg, int wickets");
			
			Team newTeam = new Team(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			System.out.println(teamDao.signupTeam(newTeam));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
