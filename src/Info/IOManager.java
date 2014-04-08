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

	}
}
