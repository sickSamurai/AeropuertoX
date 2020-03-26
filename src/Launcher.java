
public class Launcher {
	public static void main(String[] args) {
		int option = 0;
		System.out.println("Bienvenido a AeropuertoX");
		do {
			Menu.showMenu();
			option = Menu.captureOption();
			if (option == 1) {
				Menu.addCity();
			} else if (option == 2) {
				Menu.removeCity();
			} else if (option == 3) {
				Menu.addFlight();
			} else if (option == 4) {
				Menu.showCityFlights();
			} else if (option == 5) {
				Menu.showSpecificFlight();
			} else if (option == 6) {
				Menu.reserveSeat();
			} else if (option == 7) {
				System.out.println("Hasta pronto");
			} else {
				System.out.println("Opcion incorrecta");
			}
		} while (option != 7);
	}
}
