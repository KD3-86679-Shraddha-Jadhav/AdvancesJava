package com.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.entities.Team;
import com.ipl.service.TeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins ="http://localhost:3000")
public class TeamController {
	
	//depcy
	@Autowired
	private TeamService teamService;
	
	
	public TeamController() {
		System.out.println("in ctor"+ getClass());
	}
	/*
	 * URL - http://host:port/categories Method - GET payload - none ! resp - JSON
	 * representation of List<Category> Desc - get all categories
	 */
	
	@GetMapping
	public ResponseEntity<?> getTeams(){
		System.out.println("get all");
		List<Team> team = teamService.getAllTeams();
	    if(team.isEmpty())
	    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    return ResponseEntity.ok(team);
	}
	
	/*
	 * URL - http://host:port/categories Method - POST payload - JSON representation
	 * of category -> Java - @RequestBody resp - String Desc - add new category
	 */
	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody Team team){
		System.out.println("in add team"+ team); //transient team
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(teamService.addNewTeams(team));
	}

}
