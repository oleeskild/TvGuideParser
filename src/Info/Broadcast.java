package Info;

import java.util.ArrayList;

public class Broadcast {

	private String name;
	private String beskrivelse;
	private Time startTime;
	private Time stopTime;
	private ArrayList<String> category;
	private int duration;

	public Broadcast(String name, String beskrivelse, Time startTime,
			Time stopTime, ArrayList<String> category, int duration) {
		this.name = name;
		this.beskrivelse = beskrivelse;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.category = category;
		this.duration = duration;

	}

	public String getName() {
		return this.name;
	}

	public String getBeskrivelse() {
		return this.beskrivelse;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public ArrayList<String> getCategory() {
		return this.category;
	}

	public int getDuration() {
		return this.duration;
	}

	public Time getStopTime() {
		return this.stopTime;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " Duration: " + this.duration;
	}

}
