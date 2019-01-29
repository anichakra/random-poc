package me.anichakra.poc.ruleservice.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roll_number")
	private Integer rollNumber;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="class_spec")
	private String classSpec;
	
	@Column(name="fab_sub")
	private String fabSub;
	
	@Column(name="score")
	private int score;
	
	@Column(name="gdpa")
	private int gdpa;
	
	

	public int getGdpa() {
		return gdpa;
	}

	public void setGdpa(int gdpa) {
		this.gdpa = gdpa;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassSpec() {
		return classSpec;
	}

	public void setClassSpec(String classSpec) {
		this.classSpec = classSpec;
	}

	public String getFabSub() {
		return fabSub;
	}

	public void setFabSub(String fabSub) {
		this.fabSub = fabSub;
	}
	
	
}
