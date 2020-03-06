package modelA;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		// Create the students
		Student s1 = new Student("Joaquin","Alonso",4523452);
		Student s2 = new Student("Pedro","Saiz",4523452);
		
		// Create the Queue
		Queue<Student> q = new Queue<Student>();
		
		// Add the students
		q.add(s1);
		q.add(s2);
		
		// Show the queue
		System.out.println(q);
		
		// Remove the last element
		q.removeElementAtIndex(1);
		
		// Show the queue
		System.out.println(q);
		
		// Uncomment to check sort method
		// System.out.println(q.sort());
		
		// Store the queue into a file
		save(q,"queue.file");
		
		// This method is unnecessary. Only for check the save method
		Queue<Student> qFromFile = load("queue.file");
		System.out.println(qFromFile);
		
	}
	
	// Method to store the Queue
	public static void save(Queue<Student> q, String file) {
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(file)))){
			
			out.writeObject(q);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// This method is unnecessary. Only for check the save method
	public static Queue<Student> load (String file) {
		
		Queue<Student> q=null;
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(file)))){
			
			q = (Queue<Student>)in.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return q;
	}

}
