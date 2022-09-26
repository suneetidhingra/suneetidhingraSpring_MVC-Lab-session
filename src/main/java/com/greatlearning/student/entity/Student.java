package com.greatlearning.student.entity;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Student")
public class Student {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;

	private String name;

	private String department;

	private String country;

	@Transient
	private LinkedHashMap<String, String> countries;
	
	@Transient
	private LinkedHashMap<String, String> departments;

	// define constructors
	public Student(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}

	public Student() {
		// populate countries
		countries = new LinkedHashMap<>();

		countries.put("Australia", "Australia");
		countries.put("Canada", "Canada");
		countries.put("India", "India");
		countries.put("USA", "USA");
		countries.put("Russia", "Russia");
		countries.put("New Zealand", "New Zealand");
		
		departments = new LinkedHashMap<>();

		departments.put("M.Tech", "M.Tech");
		departments.put("B.Tech", "B.Tech");
		departments.put("M.Com",   "M.Com");
		departments.put("B.Com", "B.Com");
		departments.put("MBA", "MBA");
		departments.put("B.Arch", "B.Arch");
	}

	// define getter/setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCountries(LinkedHashMap<String, String> countries) {
		this.countries = countries;
	}
	
	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}
	
	public void setDepartments(LinkedHashMap<String, String> departments) {
		this.departments = departments;
	}
	
	public LinkedHashMap<String, String> getDepartments() {
		return departments;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", country=" + country + "]";
	}

}
