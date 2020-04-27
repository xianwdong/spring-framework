package com.test.inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @create 2020-04-24
 */
public class School implements InitializingBean {

	private String name;

	private SchoolMaster schoolMaster;

	@Autowired
	private Address address;

	@Autowired
	private List<Student> studentList;

	public School() {}

	public School(String name) {
		this.name = name;
	}

	public SchoolMaster getSchoolMaster() {
		return schoolMaster;
	}

	public void setSchoolMaster(SchoolMaster schoolMaster) {
		this.schoolMaster = schoolMaster;
	}

	// todo name可以不用有set方法，也能注入
	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public void init(){
		System.out.println("init");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public String toString() {
		return "School{" +
				"name='" + name + '\'' +
				", schoolMaster=" + schoolMaster +
				", address=" + address +
				", studentList=" + studentList +
				'}';
	}
}
