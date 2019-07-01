package com.hibernate_postgres.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class CourseEntity {

	@Id
	private int id;
	
	private String name;

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(
			name = "course_student",
			joinColumns = {@JoinColumn(name = "course_id")},
			inverseJoinColumns = {@JoinColumn(name = "student_id")}
			)
	private List<StudentEntity> students;

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

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

	//convenience method
	public void add(StudentEntity student) {
		if(students==null) {
			students = new ArrayList<StudentEntity>();
		}
		
		students.add(student);
	}
}
