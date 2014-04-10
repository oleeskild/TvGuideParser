package Info;

import java.util.ArrayList;

public class Broadcast {

	private String name;
	private String beskrivelse;
	private Time time;
	private ArrayList<String> category;
	private int duration;

	public Broadcast(String name, String beskrivelse, Time time,
			ArrayList<String> category, int duration) {
		this.name = name;
		this.beskrivelse = beskrivelse;
		this.time = time;
		this.category = category;
		this.duration = duration;

	}

	public String getName() {
		return name;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public Time getTime() {
		return time;
	}

	public ArrayList<String> getCategory() {
		return category;
	}

	public int getDuration() {
		return duration;
	}

}
