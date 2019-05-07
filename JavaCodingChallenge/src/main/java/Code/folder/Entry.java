package folder;

public class Entry {
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Integer Passenger;
	public Integer getPassenger() {
		return Passenger;
	}
	public void setPassenger(Integer passenger) {
		Passenger = passenger;
	}
	public Integer getSurvived() {
		return Survived;
	}
	public void setSurvived(Integer survived) {
		Survived = survived;
	}
	public Integer getPclass() {
		return Pclass;
	}
	public void setPclass(Integer pclass) {
		Pclass = pclass;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public Integer getSibSp() {
		return SibSp;
	}
	public void setSibSp(Integer sibSp) {
		SibSp = sibSp;
	}
	public Integer getParch() {
		return Parch;
	}
	public void setParch(Integer parch) {
		Parch = parch;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public float getFare() {
		return Fare;
	}
	public void setFare(float fare) {
		Fare = fare;
	}
	private Integer Survived;
	private Integer Pclass;
	private String Name;
	private String Sex;
	private Integer Age;
	private Integer SibSp;
	private Integer Parch;
	private String Ticket;
	private float Fare; 

	
}
