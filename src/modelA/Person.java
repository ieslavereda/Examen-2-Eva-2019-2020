package modelA;

import java.io.Serializable;

public abstract class Person implements Serializable {
	
	private String name;
	private String surname;

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	protected String getName() {
		return name;
	}

	protected String getSurname() {
		return surname;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setSurname(String surname) {
		this.surname = surname;
	}
	
}
