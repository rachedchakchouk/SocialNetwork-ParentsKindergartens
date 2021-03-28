package se.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_Claims")
public class Claim implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Claims_ID")
	private Long Claims_Id ; 
	private String Claims_Description ; 
	private Date Claims_Date ; 
	private String Claims_image ; 
	private String Claims_Type ;
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claim(Long claims_Id, String claims_Description, Date claims_Date, String claims_image, String claims_Type) {
		super();
		Claims_Id = claims_Id;
		Claims_Description = claims_Description;
		Claims_Date = claims_Date;
		Claims_image = claims_image;
		Claims_Type = claims_Type;
	}
	public Long getClaims_Id() {
		return Claims_Id;
	}
	public void setClaims_Id(Long claims_Id) {
		Claims_Id = claims_Id;
	}
	public String getClaims_Description() {
		return Claims_Description;
	}
	public void setClaims_Description(String claims_Description) {
		Claims_Description = claims_Description;
	}
	public Date getClaims_Date() {
		return Claims_Date;
	}
	public void setClaims_Date(Date claims_Date) {
		Claims_Date = claims_Date;
	}
	public String getClaims_image() {
		return Claims_image;
	}
	public void setClaims_image(String claims_image) {
		Claims_image = claims_image;
	}
	public String getClaims_Type() {
		return Claims_Type;
	}
	public void setClaims_Type(String claims_Type) {
		Claims_Type = claims_Type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Claims_Date == null) ? 0 : Claims_Date.hashCode());
		result = prime * result + ((Claims_Description == null) ? 0 : Claims_Description.hashCode());
		result = prime * result + ((Claims_Id == null) ? 0 : Claims_Id.hashCode());
		result = prime * result + ((Claims_Type == null) ? 0 : Claims_Type.hashCode());
		result = prime * result + ((Claims_image == null) ? 0 : Claims_image.hashCode());
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
		Claim other = (Claim) obj;
		if (Claims_Date == null) {
			if (other.Claims_Date != null)
				return false;
		} else if (!Claims_Date.equals(other.Claims_Date))
			return false;
		if (Claims_Description == null) {
			if (other.Claims_Description != null)
				return false;
		} else if (!Claims_Description.equals(other.Claims_Description))
			return false;
		if (Claims_Id == null) {
			if (other.Claims_Id != null)
				return false;
		} else if (!Claims_Id.equals(other.Claims_Id))
			return false;
		if (Claims_Type == null) {
			if (other.Claims_Type != null)
				return false;
		} else if (!Claims_Type.equals(other.Claims_Type))
			return false;
		if (Claims_image == null) {
			if (other.Claims_image != null)
				return false;
		} else if (!Claims_image.equals(other.Claims_image))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Claim [Claims_Id=" + Claims_Id + ", Claims_Description=" + Claims_Description + ", Claims_Date="
				+ Claims_Date + ", Claims_image=" + Claims_image + ", Claims_Type=" + Claims_Type + "]";
	}

}
