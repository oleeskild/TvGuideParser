package Info;

import java.util.ArrayList;

public class Channel {

	private String name;
	private String id;
	private ArrayList<Broadcast> broadcastList;

	public Channel(String name, String id) {
		this.name = name;
		this.id = id;
		broadcastList = new ArrayList<Broadcast>();
	}

	@Override
	public String toString() {
		return "name = " + name + "|id = " + id;
	}

	public void addBroadcast(Broadcast b) {
		broadcastList.add(b);
	}
}
