package se.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long User_Id ; 
	private String User_Email ;
	private String User_Password ;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long user_Id, String user_Email, String user_Password) {
		super();
		User_Id = user_Id;
		User_Email = user_Email;
		User_Password = user_Password;
	}
	public Long getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(Long user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Email() {
		return User_Email;
	}
	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((User_Email == null) ? 0 : User_Email.hashCode());
		result = prime * result + ((User_Id == null) ? 0 : User_Id.hashCode());
		result = prime * result + ((User_Password == null) ? 0 : User_Password.hashCode());
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
		User other = (User) obj;
		if (User_Email == null) {
			if (other.User_Email != null)
				return false;
		} else if (!User_Email.equals(other.User_Email))
			return false;
		if (User_Id == null) {
			if (other.User_Id != null)
				return false;
		} else if (!User_Id.equals(other.User_Id))
			return false;
		if (User_Password == null) {
			if (other.User_Password != null)
				return false;
		} else if (!User_Password.equals(other.User_Password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [User_Id=" + User_Id + ", User_Email=" + User_Email + ", User_Password=" + User_Password + "]";
	}

}
