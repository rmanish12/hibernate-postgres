package com.hibernate_postgres.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {

	@Id
	private int id;
	
	private String name;
	
	@Column(name = "class")
	private String grade;
	
	private int mark;
	private String sex;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(
			name = "course_student",
			joinColumns = {@JoinColumn(name = "student_id")},
			inverseJoinColumns = {@JoinColumn(name = "course_id")}
			)
	private List<CourseEntity> courses;

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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", grade=" + grade + ", mark=" + mark + ", sex=" + sex
				+ ", courses=" + courses + "]";
	}

}
