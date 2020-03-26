
public class Seat {
	private User user;
	private boolean status;
	
	public User getUser() {
		return user;
	}

	public boolean getStatus() {
		return status;
	}

	public void reserveSeat(User user) {
		this.status = true;
		this.user = user;
	}
}
