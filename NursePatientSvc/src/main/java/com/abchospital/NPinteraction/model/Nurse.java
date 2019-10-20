package com.abchospital.NPinteraction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nurse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String mobile;
	private String email;
	private String address;

}
