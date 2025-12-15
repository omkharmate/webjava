package com.healthcare.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@AttributeOverride(name = "id", column = @Column(name = "patient_id"))
//Lombok annotations
@NoArgsConstructor
@Setter
@Getter
public class Patient extends BaseEntity{
	@Column(name = "blood_group")
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	
	private String familyHistory; 
	
	@Column(name = "Gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToMany
	Set<DiagTest> AppointmentList=new HashSet<>();
	
	public Patient(BloodGroup bloodGroup, String familyHistory, Gender gender) {
		super();
		this.bloodGroup = bloodGroup;
		this.familyHistory = familyHistory;
		this.gender = gender;
	}	
}
