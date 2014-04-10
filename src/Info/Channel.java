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
		return "name = " + name + "|id = " + id + "|broadcast 1 = "
				+ broadcastList.get(1).getBeskrivelse();
	}

	public void addBroadcast(Broadcast b) {
		broadcastList.add(b);
	}

	public Broadcast getBroadcast(int index) {
		return broadcastList.get(index);
	}
}
