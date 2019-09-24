package com.topica.edu.itlab.springcsv;

import java.awt.image.SinglePixelPackedSampleModel;
import java.sql.Date;

import org.springframework.cglib.transform.impl.InterceptFieldTransformer;

public class Persion {
	private int id;
	private String name;
	private String birthOfDate;
	private String gender;
	
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
	public String getBirthOfDate() {
		return birthOfDate;
	}
	public void setBirthOfDate(String birthOfDate) {
		
		this.birthOfDate = birthOfDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPersion(String persion) {
		String[] strings = persion.split(",");
		for (int i = 0; i < strings.length; i++) {
			this.id= Integer.parseInt(strings[0]);
			this.name=strings[1];
			this.birthOfDate=strings[2];
			this.gender=strings[3];
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ID="+id+",Name="+name+",BirthOfDay="+birthOfDate+",Gender="+gender+"}";
	}
	
}
