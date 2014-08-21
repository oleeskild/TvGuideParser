package Info;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Channel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4163942207029525677L;
	private String name;
	private String id;
	private ArrayList<Broadcast> broadcastList;

	public Channel(String name, String id) {
		this.name = name;
		this.id = id;
		this.broadcastList = new ArrayList<Broadcast>();
	}

	@Override
	public String toString() {
		if (this.broadcastList.size() > 0) {
			return "name = " + this.name + "|id = " + this.id
					+ "|broadcast 1 = "
					+ this.broadcastList.get(0).getBeskrivelse();
		}
		return "No Broadcast: " + this.name + " " + this.id;
	}

	public void addBroadcast(Broadcast b) {
		this.broadcastList.add(b);
	}

	public Broadcast getBroadcast(int index) {
		return this.broadcastList.get(index);
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getNumberOfBroadcast() {
		return this.broadcastList.size();
	}
	
	public void writeObject(String filePath) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(filePath);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		out.close();
		fileOut.close();
	}
}

