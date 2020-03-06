package modelB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ContryFinalist extends Country implements Comparable<ContryFinalist> {

	private int score;
	private Set<ContryFinalist> voted;

	public ContryFinalist(String name) {
		super(name);
		this.score = 0;
		voted = new HashSet<ContryFinalist>();
	}

	public String getName() {
		return super.getName();
	}

	public int getScore() {
		return score;
	}

	public void addScore(int points) {
		this.score += points;
	}

	public void vote(ArrayList<ContryFinalist> countries) {

		int i;
		for (int voto : Main.SCORES) {

			// Select a country through a random index while the selected country is itself or was previously selected
			do {
				i = (int) (Math.random() * countries.size());
			} while (countries.get(i) == this || voted.contains(countries.get(i)));

			countries.get(i).addScore(voto);
			voted.add(countries.get(i));
		}
	}

	@Override
	public String toString() {
		return getName() + " -> " + score;
	}

	@Override
	public int compareTo(ContryFinalist c) {
		return getName().compareTo(c.getName());
	}

}