package Info;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		builder = new SAXBuilder();
		xmlFile = new File("xmltv.xml");
		try {
			document = (Document) builder.build(xmlFile);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String fileName) {
		try (FileWriter fw = new FileWriter(fileName, false)) {
			PrintWriter pw = new PrintWriter(fw);
			pw.println();
			pw.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	/**
	 * Creates an array of channel objects containg all the channels found in
	 * the xml file
	 * 
	 * @return an arraylist with channels
	 */
	public ArrayList<Channel> getChannels() {

		ArrayList<Channel> channelList = new ArrayList<Channel>();

		Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("channel");

		for (int i = 0; i < list.size(); i++) {

			Element node = (Element) list.get(i);

			channelList.add(new Channel(node.getChild("display-name")
					.getValue(), node.getAttribute("id").getValue()));

		}

		return channelList;
	}

	public void connectBroadcast(ArrayList<Channel> ch) {

		Element rootNode = document.getRootElement();
		List programList = rootNode.getChildren("programme");
		String id = "";
		int counter = 0;
		for (int i = 0; i < programList.size(); i++) {

			Element node = (Element) programList.get(i);

			id = node.getAttribute("channel").getValue();

			String start = node.getAttributeValue("start");
			int year = Integer.parseInt(start.substring(0, 4));
			int month = Integer.parseInt(start.substring(4, 6));
			int day = Integer.parseInt(start.substring(6, 8));
			int hour = Integer.parseInt(start.substring(8, 10));
			int min = Integer.parseInt(start.substring(10, 12));

			Time startTime = new Time(year, month, day, hour, min);

			String name = node.getChildText("title");
			String description = node.getChildText("desc");

			// Making the list of categories
			List categoryList = node.getChildren("category");
			ArrayList<String> categories = new ArrayList<String>();
			for (int j = 0; j < categoryList.size(); j++) {
				Element category = (Element) categoryList.get(j);
				categories.add(category.getValue());
			}

			// int duration =
			// Integer.parseInt(node.getChild("length").getValue());

			ch.get(counter)
					.addBroadcast(
							new Broadcast(name, description, startTime,
									categories, 20));

			if (i != programList.size() - 1) {
				Element nextProg = (Element) programList.get(i + 1);
				if (id != nextProg.getValue()) {
					counter++;
				}
			}

		}
	}
}
