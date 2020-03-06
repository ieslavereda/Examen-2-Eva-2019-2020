package modelB;

public abstract class Country {
	
	private String name;

	public Country(String name) {
		this.name = name;
	}

	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}

}
