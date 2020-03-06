package modelB;

import java.util.*;
import java.io.*;

public class Main {

	// Possible scores
	public static final int[] SCORES = { 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	// Collection to store countries
	public static ArrayList<ContryFinalist> countries;

	public static void main(String[] args) {

		loadCountriesFromFile("country.txt");

		// Vote
		for (ContryFinalist contryFinalist : countries) {
			contryFinalist.vote(countries);
		}

		// Sort countries using the interface Comparator
		Collections.sort(countries, new Comparator<ContryFinalist>() {
			public int compare(ContryFinalist p1, ContryFinalist p2) {
				return p2.getScore() - p1.getScore();
			}
		});
		System.out.println("Countries for scores \n" + countries);

		// Save the list to a file
		saveListToFile(countries, "listado.txt");

		// Sort countries using their natural order (Comparable)
		Collections.sort(countries);
		System.out.println("Countries in alphabetical order \n" + countries);

	}

	private static void saveListToFile(ArrayList<ContryFinalist> list, String file) {

		try (PrintWriter out = new PrintWriter(new FileWriter(new File(file)))) {

			for (ContryFinalist contryFinalist : list) {
				out.println(contryFinalist);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadCountriesFromFile(String file) {

		String nombre;
		countries = new ArrayList<ContryFinalist>();

		try (BufferedReader in = new BufferedReader(new FileReader(new File(file)));) {

			while ((nombre = in.readLine()) != null) {
				countries.add(new ContryFinalist(nombre));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}