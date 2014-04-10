package Info;

public class Time {
	private int year;
	private int month;
	private int day;
	private int timeHour;
	private int timeMin;

	public Time(int y, int m, int d, int tH, int sMin) {
		year = y;
		month = m;
		day = d;
		timeHour = tH;
		timeMin = sMin;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getTimeHour() {
		return timeHour;
	}

	public int getTimeMin() {
		return timeMin;
	}

}
