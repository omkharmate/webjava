package com.healthcare.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="appointments")
public class Appointment extends BaseEntity{
	@Column(name = "appointment_date_time")
	LocalDateTime AppointmentDateTime;
	
	@Enumerated(EnumType.STRING)
	Status st;
	
	@ManyToOne
	@JoinColumn(name="docter_id" ,nullable = false)
	Docter docterDetails;
	
	
	@ManyToOne
	@JoinColumn(name="patient_id" ,nullable = false)
	Patient patientDetails;
	
	
}
