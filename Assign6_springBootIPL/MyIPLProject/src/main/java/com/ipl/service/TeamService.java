package com.ipl.service;

import java.util.List;

import com.ipl.entities.Team;

public interface TeamService {
//get all teams
	List<Team> getAllTeams();
	//add new teams
	String addNewTeams(Team team);
}
