
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
	private static Cities cities = new Cities();
	private static Flights flights = new Flights();

	public static void showMenu() {
		System.out.println("1. Agregar ciudad");
		System.out.println("2. Eliminar ciudad");
		System.out.println("3. Agregar vuelo");
		System.out.println("4. Listar todos los vuelos a una ciudad");
		System.out.println("5. Presentar informacion de un vuelo especifico");
		System.out.println("6. Hacer una reserva de un vuelo");
		System.out.println("7. Salir");
	}

	public static int captureOption() {
		return new Scanner(System.in).nextInt();
	}

	public static void addCity() {
		System.out.println("Digite el nombre de la ciudad");
		String cityName = new Scanner(System.in).nextLine();
		System.out.println("Digite las coordenadas de la ciudad");
		String cityCoordinates = new Scanner(System.in).nextLine();
		cities.addCity(new City(cityName, cityCoordinates));
	}

	public static void removeCity() {
		System.out.println("Digite el nombre de la ciudad");
		String cityCoordinates = new Scanner(System.in).nextLine();
		cities.removeCity(cityCoordinates);
	}

	public static void addFlight() {
		System.out.println("Digite el nombre de la ciudad de destino");
		String cityName = new Scanner(System.in).nextLine();
		System.out.println("Digite las coordenadas de la ciudad de destino");
		String coordinates = new Scanner(System.in).nextLine();
		System.out.println("Digite la fecha (YY/MM/dd)");
		String day = new Scanner(System.in).nextLine();
		System.out.println("Digite la hora (hh:mm)");
		String time = new Scanner(System.in).nextLine();
		Integer[] splitedDay = new Integer[3];
		Arrays.asList(day.split("/")).stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList())
				.toArray(splitedDay);
		Integer[] splitedTime = new Integer[2];
		Arrays.asList(time.split(":")).stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList())
				.toArray(splitedTime);
		Date date = new Date(splitedDay[0], splitedDay[1], splitedDay[2], splitedTime[0], splitedTime[1]);
		flights.addFlightSortly(new Flight(new City(cityName, coordinates), date));
	}

	public static void showCityFlights() {
		System.out.println("Digite el nombre de la ciudad");
		String cityName = new Scanner(System.in).nextLine();
		System.out.println("Digite las coordenadas de la ciudad");
		String coordinates = new Scanner(System.in).nextLine();
		for (Flight flight : flights.getFlights(new City(cityName, coordinates)))
			System.out.println(flight.toString());
	}

	public static void showSpecificFlight() {
		System.out.println("Digite el codigo del vuelo");
		System.out.println(flights.getFlight(new Scanner(System.in).nextLine()).toString());
	}
	
	public static void reserveSeat() {
		System.out.println("Digite su cedula");
		String id = new Scanner(System.in).nextLine();
		System.out.println("Digite su nombre");
		String name = new Scanner(System.in).nextLine();
		User user = new User(id, name);
		showCityFlights();
		System.out.println("Seleccione el vuelo que desee digitando su codigo:");
		String code = new Scanner(System.in).nextLine();
		System.out.println("Digite la fila y columna de su asiento separadas por un espacio:");
		String seatLocation = new Scanner(System.in).nextLine();
		int row = Integer.parseInt(seatLocation.split(" ")[0]);
		int column = Integer.parseInt(seatLocation.split(" ")[1]);
		flights.reserveSeat(user, code, row, column);
	}
}
