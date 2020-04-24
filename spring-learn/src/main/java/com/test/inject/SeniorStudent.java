package com.test.inject;

/**
 * @create 2020-04-24
 */
public class SeniorStudent implements Student {

	private String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SeniorStudent{" +
				"level='" + level + '\'' +
				'}';
	}
}
