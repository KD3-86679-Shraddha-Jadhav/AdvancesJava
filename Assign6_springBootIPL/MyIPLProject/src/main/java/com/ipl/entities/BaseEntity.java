package com.ipl.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	
//id prop must be - serializable
@Id //pk
   //For auto id generation using auto increment constraint
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column //column name - team_id
private Long id; //mapped to pk
//creation date
@CreationTimestamp
@Column(name="created_on")
private LocalDate createdOn;

//updation time stamp
@UpdateTimestamp
@Column(name="updated_on")
private LocalDateTime updatedOn;
//@Version //used for optimistic locking
//private int entityVersion;


}
