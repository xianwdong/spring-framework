package com.test.xsd;

/**
 * @create 2021-06-30
 */
public class UserXsd {

	private String name;

	private String idCard;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "UserXsd{" +
				"name='" + name + '\'' +
				", idCard='" + idCard + '\'' +
				'}';
	}
}
