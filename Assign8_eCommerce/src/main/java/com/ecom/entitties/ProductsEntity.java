package com.ecom.entitties;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class ProductsEntity extends BaseEntity {
	
	@Column(unique=true,length=30 )
	private String title;
	
	@Column(length=30)
	private String description;
	
	@Column(nullable=false,length=30)
	private double price;
	
	@Column(nullable=false)
	private int availCount;
	
	@Column
	private boolean status=true;

	public ProductsEntity(Long id, LocalDate createdOn, LocalDate updatedOn, String title, String description,
			double price, int availCount,boolean status) {
		super(id, createdOn, updatedOn);
		this.title = title;
		this.description = description;
		this.price = price;
		this.availCount = availCount;
		this.status=status;
	}
	
	
	
	

}
