package com.sunbeam.dao;

import org.hibernate.*;

import com.sunbeam.entities.Team;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

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

}
