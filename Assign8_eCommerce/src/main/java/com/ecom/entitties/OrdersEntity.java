package com.ecom.entitties;

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
@Table(name="orders")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class OrdersEntity extends BaseEntity{
	
	@Column(nullable=false)
	private int qauntity;
	
	@Column(nullable=false)
	private double Total;
	
	@Column
	private boolean status=true;
	
	@ManyToOne
	@JoinColumn(name="prod_id",nullable=false)
	private ProductsEntity product;
	
	@ManyToOne
	@JoinColumn(name="cust_id",nullable=false)
	private UserEntity customer;

	public OrdersEntity(Long id, LocalDate createdOn, LocalDate updatedOn, int qauntity, boolean status) {
		super(id, createdOn, updatedOn);
		this.qauntity = qauntity;
		this.status = status;
	}
	
	
	

}
