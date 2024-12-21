package com.sunbeam.dao;

import org.hibernate.*;


import com.sunbeam.entities.Team;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String signupTeam(Team team) {
		String mesg="User registration failed!!!!";
		// 1. Get Session from SessionFactory
				/*
				 * Method of SessionFactory public Session getCurrentSession() throws
				 * HibernateException
				 */
		Session session = getSessionFactory().getCurrentSession();
		// 2 . Begin a Transaction
				/*
				 * Method of Session 
				 * public Transaction beginTransaction() throws
				 * HibernateException
				 */
		Transaction tx=session.beginTransaction();
		try {
			/*
			 * Session API
			 * public Serializable save(Object transientEntity) throws  HibernateException
			 */
			Serializable teamId = session.save(team);
			//success
			tx.commit();
			mesg="Team signed up!,ID" + teamId;
		} catch (RuntimeException e) {
			//failure - rollback the tc
			if(tx != null)
				tx.rollback();
			//re throw the same exception to caller
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Team> getAllTeams() {
		String jpql = "select t from Team t";
		List<Team> teams = null;
		//1. get session from sessionfactory
		
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class)
					.getResultList();
			//teams-list of persistance entities
			tx.commit();
		} catch (RuntimeException e) {
			//roll back the tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception of thee  caller
			throw e;
		}
		
		return teams; // teams - list of detached entities
	}

	@Override
	public List<Team> getSelectedTeamDetails(int age, double avg) {
		List<Team> teams = null;
		String jpql ="select t from Team t where t.age < :ag and t.batting_avg > :savg ";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("ag",age).setParameter("savg", avg)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	 return teams;
	}

	@Override
	public List<Team> getOwnerAbbri(int age, double avg) {
		List<Team> teams = null;
		String jpql = "select new com.sunbeam.entities.Team(owner,abbreviation) from Team t where t.age < :ag and t.batting_avg > :savg";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("ag",age).setParameter("savg", avg)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return teams;
		
	}

	@Override
	public String UpdateMaxAge(String name, int age) {
		Team team = null;
		String mesg = "Age Updation Failed!!";
		String jpql ="select t from Team t where t.name=:nm";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			team=session.createQuery(jpql, Team.class)
					.setParameter("nm",name)
					.getSingleResult();
			//in case of no results - throws NoResultException
			//user : Persistent (exists L1 cache , exists in db)
			/*
			 * updating state of the persistent entity
			 */
			team.setAge(age);//team-persistent
			//session.evict(team);
			//team - detached
			tx.commit();
			mesg="Age is Updated";
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
	
		return mesg;
	}

	@Override
	public String deleteTeamById(long teamId) {
		String mesg="Deletion Failed!!";
		Team team = null;
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			team=session.get(Team.class, teamId);
			if(team != null)
			{
			   session.delete(team);
			   mesg="deleted team details";
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}

	

	

	

	
	
	}


