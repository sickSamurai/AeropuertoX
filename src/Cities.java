import java.util.LinkedList;
import java.util.List;

public class Cities {
	private List<City> cities;

	public void addCity(City city) {
		cities.add(city);
	}

	public void removeCity(String coordinates) {
		cities.removeIf((City city) -> coordinates.equals(city.getCoordinates()));
	}
	 
	public City getCity(String cityName) {
		int i = 0;
		while (i < cities.size() && !cityName.equals(cities.get(i).getName()))
			i++;
		return i < cities.size() ? cities.get(i) : null;
	}
	
	public Cities() {
		cities = new LinkedList<>();
	}
}
