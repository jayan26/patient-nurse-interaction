package com.abchospital.NPinteraction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	@Id
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String mobile;
	private String email;
	private String address;

}
