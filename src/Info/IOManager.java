package Info;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class IOManager {

	private SAXBuilder builder;
	private final File xmlFile;
	private Document document;

	public IOManager() {
		this.builder = new SAXBuilder();
		this.xmlFile = new File("xmltv.xml");
		try {
			this.document = (Document) this.builder.build(this.xmlFile);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeFile(String fileName, Channel kanal) {
		
		
		File fileChannel = new File(fileName + kanal.getName().replace("/", " ") + ".txt");
		
		try {
			fileChannel.createNewFile();
		} catch (IOException e) {
			System.out.println("Failed to get file handle");
		}
		
		try (FileWriter fw = new FileWriter(fileChannel, false)) {
			PrintWriter pw = new PrintWriter(fw);
			for (int j = 0; j < kanal.getNumberOfBroadcast(); j++) {
				pw.println(kanal.getBroadcast(j));
			}
			pw.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	public void writeObject(String filePath, Channel kanal){
		try {
			kanal.writeObject(filePath + kanal.getName().replace("/", " "));
		} catch (IOException e) {
			//TODO Try to write again or something like that!
		}
	}

	/**
	 * Creates an array of channel objects containing all the channels found in
	 * the xml file
	 * 
	 * @return an arraylist with channels
	 */
	public ArrayList<Channel> getChannels() {

		ArrayList<Channel> channelList = new ArrayList<Channel>();

		Element rootNode = this.document.getRootElement();
		List list = rootNode.getChildren("channel");

		for (int i = 0; i < list.size(); i++) {

			Element node = (Element) list.get(i);

			channelList.add(new Channel(node.getChild("display-name")
					.getValue(), node.getAttribute("id").getValue()));

		}

		return channelList;
	}

	/**
	 * Connects all the broadcasts in the xml file to the right channel in the channel list provided in the parameters
	 * @param ch An arraylist of channels
	 */
	public void connectBroadcast(ArrayList<Channel> ch) {

		Element rootNode = this.document.getRootElement();
		List programList = rootNode.getChildren("programme");

		Element node;

		String id = "";
		String start, stop;
		String name, description, durationS;

		// Variables holding both start and stoptime in for-loop
		int year, month, day, hour, min, duration;

		// Time variables using the integers above as arguments
		Time startTime, stopTime;

		for (int i = 0; i < programList.size(); i++) {

			node = (Element) programList.get(i);

			id = node.getAttribute("channel").getValue();

			start = node.getAttributeValue("start");
			year = Integer.parseInt(start.substring(0, 4));
			month = Integer.parseInt(start.substring(4, 6));
			day = Integer.parseInt(start.substring(6, 8));
			hour = Integer.parseInt(start.substring(8, 10));
			min = Integer.parseInt(start.substring(10, 12));

			startTime = new Time(year, month, day, hour, min);

			stop = node.getAttributeValue("stop");
			year = Integer.parseInt(stop.substring(0, 4));
			month = Integer.parseInt(stop.substring(4, 6));
			day = Integer.parseInt(stop.substring(6, 8));
			hour = Integer.parseInt(stop.substring(8, 10));
			min = Integer.parseInt(stop.substring(10, 12));

			stopTime = new Time(year, month, day, hour, min);

			name = node.getChildText("title");
			description = node.getChildText("desc");
			durationS = node.getChildText("length");
			duration = 0;
			if (durationS != null) {
				duration = Integer.parseInt(durationS);
			}

			// Making the list of categories
			List categoryList = node.getChildren("category");
			ArrayList<String> categories = new ArrayList<String>();
			for (int j = 0; j < categoryList.size(); j++) {
				Element category = (Element) categoryList.get(j);
				categories.add(category.getValue());
			}

			for (int j = 0; j < ch.size(); j++) {
				if (ch.get(j).getId().equals(id)) {
					ch.get(j).addBroadcast(
							new Broadcast(name, description, startTime,
									stopTime, categories, duration));
					break;
				}
			}

		}
	}
}
