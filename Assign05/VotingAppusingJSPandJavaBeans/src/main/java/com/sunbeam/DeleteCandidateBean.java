package com.sunbeam;

import javax.management.RuntimeErrorException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class DeleteCandidateBean {

	private int id;
	
	
	public DeleteCandidateBean() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void deleteCandidate() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			int cand = candDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
