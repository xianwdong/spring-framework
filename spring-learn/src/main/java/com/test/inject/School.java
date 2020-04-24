package com.test.inject;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @create 2020-04-24
 */
public class School {

	private String name;

	@Autowired
	private Address address;

	@Autowired
	private List<Student> studentList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School{" +
				"name='" + name + '\'' +
				", address=" + address +
				", studentList=" + studentList +
				'}';
	}
}