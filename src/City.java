
public class City {
	private String name;
	private String coordinates;

	public City(String name, String coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public String toString() {
		return "Nombre:" + " " + name + " " + "(" + coordinates + ")";
	}
}
