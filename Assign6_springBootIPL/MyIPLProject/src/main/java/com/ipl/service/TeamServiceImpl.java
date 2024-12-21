package com.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.dao.TeamDao;
import com.ipl.entities.Team;

@Service
@Transactional

public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamDao teamDao;
	
	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamDao.findAll();
	}

	@Override
	public String addNewTeams(Team team) {
		Team persistTeam = teamDao.save(team);
		return "Added new team with id="+persistTeam;
	}

	
}
