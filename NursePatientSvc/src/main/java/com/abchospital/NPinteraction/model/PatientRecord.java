package com.abchospital.NPinteraction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PATIENTRECORDS")
public class PatientRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordid;
	private String patientusername;
	private String created_date;
	private String prescriptions;
	private String comments;

}