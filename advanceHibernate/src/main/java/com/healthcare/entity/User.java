package com.healthcare.entity;

import java.time.LocalDate;
 
 import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="user_id"))
@ToString(exclude = {"image","password"})

public class User extends BaseEntity {
//	Enter User details - firstName,  lastName, "
//			+ "dob,  email ,password,  phone,regAmount
	public User() {
		
	}
public User(String next, String next2, LocalDate localDate, String next3, String next4, String next5, int nextInt) {
	this.firstName=next;
	this.last_name=next2;
	this.birthDate=localDate;
	this.email=next3;
	this.password=next4;
	this.phone=next5;
	this.regAmmount=nextInt;
}
@Column(name = "dob")
 private LocalDate birthDate ;
@Column(length = 50, unique = true )
 private String email;
@Column(name = "first_name", length = 40,unique = true)
 private String firstName;
@Column()
 private byte[] image;

 private String last_name;
 
 @Column(nullable = false)
 private String password ;
 
 @Column(unique = true)
 private String phone;
 private int regAmmount;
 @Column(nullable = false)
 private Role user_role;
}

