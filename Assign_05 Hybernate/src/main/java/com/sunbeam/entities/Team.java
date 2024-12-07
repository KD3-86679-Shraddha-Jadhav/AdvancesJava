package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity     //manditory class level annotation
@Table(name = "new_IPLTeam")  //to customize table name
public class Team {
@Id //pk
 //for auto id generation using auto increament constraint-
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="team_id" )  //column name- player_id
	private Long teamId;

@Column(length = 20, name="player_name") //varchar20
	private String name;

@Column(length = 10, unique=true) //varchar10
	private String abbreviation;

@Column(length=20,nullable= false)//not null constraints
	private String owner;

@Column(name="max_player_age")
	private int age;

@Column(name="batting_avg")
	private double batting_avg;

@Column(name="wickets_taken")
	private int wickets;
	

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team( String name, String abbreviation, String owner, int age, double batting_avg, int wickets) {
		super();
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.age = age;
		this.batting_avg = batting_avg;
		this.wickets = wickets;
	}

	//all getters and setters
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBatting_avg() {
		return batting_avg;
	}

	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", age=" + age + ", batting_avg=" + batting_avg + ", wickets=" + wickets + "]";
	}
	
	
	
	
	

	
}
