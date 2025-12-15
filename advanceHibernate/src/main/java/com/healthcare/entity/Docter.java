package com.healthcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Docter")
@NoArgsConstructor

public class Docter extends BaseEntity{
	@Column(name = "experience_in_years")
	private int experienceInYears;
	
	
	private int fees;
	
	private String Qualification;
	
	private String speciality;
	
	@OneToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User u;
	
	
}
