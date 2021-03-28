package se.pidev.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_Courses")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Courses_ID")
	private Long Courses_ID ; 
	private String Courses_name ; 
	private String Courses_Details ;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Long courses_ID, String courses_name, String courses_Details) {
		super();
		Courses_ID = courses_ID;
		Courses_name = courses_name;
		Courses_Details = courses_Details;
	}
	public Long getCourses_ID() {
		return Courses_ID;
	}
	public void setCourses_ID(Long courses_ID) {
		Courses_ID = courses_ID;
	}
	public String getCourses_name() {
		return Courses_name;
	}
	public void setCourses_name(String courses_name) {
		Courses_name = courses_name;
	}
	public String getCourses_Details() {
		return Courses_Details;
	}
	public void setCourses_Details(String courses_Details) {
		Courses_Details = courses_Details;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Courses_Details == null) ? 0 : Courses_Details.hashCode());
		result = prime * result + ((Courses_ID == null) ? 0 : Courses_ID.hashCode());
		result = prime * result + ((Courses_name == null) ? 0 : Courses_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (Courses_Details == null) {
			if (other.Courses_Details != null)
				return false;
		} else if (!Courses_Details.equals(other.Courses_Details))
			return false;
		if (Courses_ID == null) {
			if (other.Courses_ID != null)
				return false;
		} else if (!Courses_ID.equals(other.Courses_ID))
			return false;
		if (Courses_name == null) {
			if (other.Courses_name != null)
				return false;
		} else if (!Courses_name.equals(other.Courses_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [Courses_ID=" + Courses_ID + ", Courses_name=" + Courses_name + ", Courses_Details="
				+ Courses_Details + "]";
	}

}
