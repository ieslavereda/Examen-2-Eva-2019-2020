package modelA;

import java.io.Serializable;

public class Student extends Person implements Comparable<Student>, Serializable {

	private int NIA;

	public Student(String name, String surname, int NIA) {
		super(name, surname);
		this.NIA = NIA;
	}

	@Override
	public int compareTo(Student o) {
		if (o.getSurname().compareTo(this.getSurname()) != 0)
			return getSurname().compareTo(o.getSurname());
		else {
			return getName().compareTo(o.getName());
		}
	}

	public String toString() {
		return getName() + " "+ getSurname() + "  NIA: "+ NIA;
	}
}
