package hw10;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements NewsDAO {
	List<News> list = new ArrayList<>();
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectXML(url);
		return list;
	}
	
	@Override
	public News search(int index) {
		return list.get(index);
	}
	
	private void connectXML(String url) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			NodeList n = root.getElementsByTagName("data");
			
			for (int i = 0; i < n.getLength(); i++) {
				News news = new News();
				Node item = n.item(i);
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if(name.equalsIgnoreCase("title")) {
						news.setTitle(kid.getFirstChild().getNodeValue());
					} else if(name.equalsIgnoreCase("desc")) {
						news.setDesc(kid.getFirstChild().getNodeValue());
					} else if(name.equalsIgnoreCase("link")) {
						news.setLink(kid.getFirstChild().getNodeValue());
					}
				}
				System.out.println(news);
				list.add(news);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
