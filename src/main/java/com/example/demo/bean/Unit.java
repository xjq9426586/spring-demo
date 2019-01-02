package com.example.demo.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Unit {
	@Id
    @GeneratedValue
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="unit")
	private Set<User> users;
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
	
}
