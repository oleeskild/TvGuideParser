package Info;

public class Time {
	private int year;
	private int month;
	private int day;
	private int startTimeHour;
	private int startTimeMin;

	public Time(int y, int m, int d, int sh, int sMin) {
		year = y;
		month = m;
		day = d;
		startTimeHour = sh;
		startTimeMin = sMin;
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

	public int getStartTimeHour() {
		return startTimeHour;
	}

	public int getStartTimeMin() {
		return startTimeMin;
	}

}
