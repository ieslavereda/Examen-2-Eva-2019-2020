package modelA;

import java.io.Serializable;
import java.util.Arrays;

public class Queue<T> implements Serializable {

	private int size;
	private Nodo<T> head;
	private Nodo<T> tail;

	public Queue() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public void add(T info) {

		Nodo<T> n = new Nodo<T>(info);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}
		
		size++;
	}

	public T remove() {
		if (head == null)
			return null;
		else if (head == tail) {
			T info = head.getInfo();
			head = null;
			tail = null;
			size--;
			return info;
		} else {
			T info = head.getInfo();
			head = head.getNext();
			size--;
			return info;
		}
	}

	public boolean removeElementAtIndex(int index) {

		Nodo<T> h, t;
		
		// If the queue is empty, return false
		if (size == 0)
			return false;
		
		// Check the index
		if (index > size || index < 0)
			return false;
		else {
			// Check if the queue only store one element, in this case we must update head and tail
			if (size == 1) {
				head = null;
				tail = null;
			} else {

				// Check if the element to remove is the first
				if (index == 0) {
					head = head.getNext();
				} else {

					h = head.getNext();
					t = head;

					while (index > 1) {
						t = h;
						h = h.getNext();
						index--;
					}
					// Check if the element to remove is the last
					if (h.getNext() == null) {
						tail = t;
						t.setNext(null);
					} else {
						t.setNext(h.getNext());
					}
				}
			}
		}
		size--;
		return true;
	}

	public String sort() {

		String text = "";
		Object[] o = new Object[size]; // Auxilary array to store students
		Nodo<T> n = head;

		// Add nodes to the array
		int i = 0;
		while (n != null) {
			o[i] = n.getInfo();
			n=n.getNext();
			i++;
		}

		// Sort the array using the interface Comparable
		Arrays.sort(o);

		// Generate the String
		for (int j = 0; j < o.length; j++) {
			text += o[j].toString() + "\n";
		}

		return text;
	}

	public String toString() {
		
		String text = "";
		Nodo<T> n = head;
		
		while (n != null) {
			text += n.toString() + "\n";
			n = n.getNext();
		}
		
		return text;
	}
}
