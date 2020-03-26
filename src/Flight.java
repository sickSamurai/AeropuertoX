import java.util.Date;
import java.util.Random;

public class Flight implements Comparable<Flight> {
	private String code;
	private City destinyCity;
	private Date date;
	private Seat[][] seats;
	private final static int ROWS = 15;
	private final static int COLUMNS = 5;

	public Flight(City destinyCity, Date date) {
		code = Integer.toString(new Random(new Date().getTime()).nextInt(10000));
		this.destinyCity = destinyCity;
		this.date = date;
		seats = new Seat[ROWS][COLUMNS];
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public City getDestinyCity() {
		return destinyCity;
	}

	public void setDestinyCity(City destinyCity) {
		this.destinyCity = destinyCity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void reserveSeat(User user, int row, int column) {
		seats[row][column].reserveSeat(user);
	}

	public boolean getSeatStatus(int row, int column) {
		return seats[row][column].getStatus();
	}

	public float getFreeSeatsPercentage() {
		int numberFreeSeats = 0;
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				numberFreeSeats += seats[row][column].getStatus() ? 0 : 1;
			}
		}
		return (float) (numberFreeSeats) / (ROWS * COLUMNS);
	}

	@Override
	public int compareTo(Flight o) {
		return (getDate().compareTo(o.getDate()));
	}

	@Override
	public String toString() {
		return "Codigo:" + " " + code + "/Ciudad: " + destinyCity.toString() + "/Fecha: " + date.toString() + "/"
				+ getFreeSeatsPercentage();
	}
}
