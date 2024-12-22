package com.ecom.entitties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true,exclude= {"password","orders"})
public class UserEntity extends BaseEntity {
	
	@Column(name="first_name",length=30)
	private String firstName;
	
	@Column(name="last_name",length=30)
	private String lastName;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(length=30)
	private String location;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private UserRole role;
	
	@Column
	private Boolean staus=true;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,orphanRemoval=true)
	List<OrdersEntity>orders=new ArrayList<OrdersEntity>();

	public UserEntity(Long id, LocalDate createdOn, LocalDate updatedOn, String firstName, String lastName,
			String email, LocalDate dob, String password, String location, UserRole role, Boolean staus,
			List<OrdersEntity> oreders) {
		super(id, createdOn, updatedOn);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.location = location;
		this.role = role;
		this.staus = staus;
		
	}

	public void placeOrder(OrdersEntity orderEnt) {
		// TODO Auto-generated method stub
		this.orders.add(orderEnt);
		orderEnt.setCustomer(this);
		
		
	}

	
	
	
	

}
