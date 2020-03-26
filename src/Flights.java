import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Flights {
	private LinkedList<Flight> flights;	

	public void addFlightSortly(Flight flight) {
		if (flights.isEmpty())
			flights.add(flight);
		else {
			int i = 0;
			while (i < flights.size() && flight.compareTo(flights.get(i)) > 0)
				i++;
			flights.add(i, flight);
		}
	}

	public List<Flight> getFlights(City city) {
		return flights.stream().filter(e -> city.equals(e.getDestinyCity())).collect(Collectors.toList());
	}
	public Flight getFlight(String flightCode) {
		return flights.stream().filter(e -> flightCode.equals(e.getCode())).collect(Collectors.toList()).get(0);
	}
	
	public void reserveSeat(User user, String flightCode, int row, int column) {
		flights.forEach(e-> {
			if (flightCode.equals(e.getCode())) {
				e.reserveSeat(user, row, column);
			}
		});
	}
}
