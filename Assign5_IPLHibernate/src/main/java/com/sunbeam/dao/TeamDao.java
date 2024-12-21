package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Team;

public interface TeamDao {

	//add a method to register new user
	String signupTeam(Team team);
	
	//Display all teams
	List<Team> getAllTeams();

	//
	List<Team> getSelectedTeamDetails(int age, double avg);

	//get selected team details
	List<Team> getOwnerAbbri(int age, double avg);

	//update the maxage
	String UpdateMaxAge(String name, int age);

	//delete team by id
	String deleteTeamById(long teamId);
	
}
