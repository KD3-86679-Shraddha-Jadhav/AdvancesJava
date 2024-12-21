package com.ipl.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Player extends BaseEntity {

	
	
	@Column(length=20, name="first_name")
	private String firstName;
	
	@Column(length=20, name="last_name")
	private String lastName;
	
	private LocalDate dob; //column type date
	
	@Column(name="wickets_taken")
	private int wickets;
	
	@Column(name="batting_avg")
	private Double BatAvg;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team MyTeam;

	public Player(String firstName, String lastName, LocalDate dob, Double batAvg, int wickets) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.wickets = wickets;
		this.BatAvg = batAvg;
		
	}

	

	
	
	
	
	
	

}
