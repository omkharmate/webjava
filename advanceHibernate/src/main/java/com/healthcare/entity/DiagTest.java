package com.healthcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="diagnostic_test")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "name")

public class DiagTest extends BaseEntity{
	@Column(length=100 ,unique = true)
	private String name;
	@Column(length = 200)
	private String description;
 	private int price;
	
}
