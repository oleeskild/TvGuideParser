package Info;

import java.util.ArrayList;

public class TvGuideParser {
	public static void main(String[] args) {
		IOManager iom = new IOManager();

		ArrayList<Channel> kanaler = iom.getChannels();

		iom.connectBroadcast(kanaler);

		System.out.println(kanaler.get(5).getBroadcast(3).getName());

		for (int i = 0; i < kanaler.size(); i++) {
			System.out.println(kanaler.get(i));
		}
	}
}
