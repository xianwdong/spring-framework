package com.test.inject;

import org.springframework.beans.factory.annotation.Autowired;

public class SchoolMaster {

	@Autowired
	private School school;

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

//	@Override
//	public String toString() {
//		return "SchoolMaster{" +
//				"school=" + school +
//				'}';
//	}
}
