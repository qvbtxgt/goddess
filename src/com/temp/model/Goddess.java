package com.temp.model;
import java.util.Date;
public class Goddess {
	private Integer id;
	private String name;
	private Integer age;
	private Date birthday;
	private String tele;
	private String email;
	
	public Goddess() {
		
	}
	
	public Goddess(Integer id,String name,Integer age,Date birthday,String tele,String email) {
		this.age=age;
		this.birthday=birthday;
		this.email=email;
		this.id=id;
		this.name=name;
		this.tele=tele;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
