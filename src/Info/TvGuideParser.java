package Info;

import java.util.ArrayList;

public class TvGuideParser {
	public static void main(String[] args) {
		IOManager iom = new IOManager();

		ArrayList<Channel> kanaler = iom.getChannels();
		iom.connectBroadcast(kanaler);

		for (int j = 0; j < kanaler.size(); j++) {
			iom.writeFile("/Users/oleeskild/Documents/Kanaler/", kanaler.get(j));
		}
	
	}
}
