package com.ipl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="owner")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper= true)
public class Owner extends BaseEntity{

	@Column(name="ownermame", length=20)
	private String name;
	@Column(length = 25, unique = true) // adds unique constraint
	private String email;
	@Column(name="Company", length=20)
	private String company;
	@OneToOne
	@JoinColumn(name ="owner_id")
	private Team myTeam;
	
	public Owner(String name, String email, String company) {
		super();
		this.name = name;
		this.email = email;
		this.company = company;
		
	}
	
	
	
	
	
	

}
