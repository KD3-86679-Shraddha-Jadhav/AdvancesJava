package com.ipl.entities;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity     //manditory class level annotation
@Table(name = "new_IPLTeam")  //to customize table name
@NoArgsConstructor
@Getter
@Setter
//@ToString(callSuper = true)

public class Team extends BaseEntity {


@Column(length = 20, name="name") //varchar20
	private String name;

@Column(length = 10, unique=true) //varchar10
	private String abbreviation;

//@Column(length=20,nullable= false)//not null constraints
	//private String owner;

@Column(name="max_player_age")
	private int age;

@Column(name="batting_avg")
	private double batting_avg;

@Column(name="wickets_taken")
	private int wickets;
	
//one to many
//@OneToMany(mappedBy ="MyTeam", cascade = CascadeType.ALL,
//orphanRemoval = true )
//List<Player> player = new ArrayList<Player>();

public Team(String name, String abbreviation,  int age, double batting_avg, int wickets
		) {
	super();
	this.name = name;
	this.abbreviation = abbreviation;
	
	this.age = age;
	this.batting_avg = batting_avg;
	this.wickets = wickets;
	
}
	

	
}
