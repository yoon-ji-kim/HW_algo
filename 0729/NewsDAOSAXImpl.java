package hw10;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements NewsDAO{
	List<News> list = new ArrayList<>();
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectXML(url);
		return list;
	}
	private void connectXML(String url) {
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			SaxHandler hanlder = new SaxHandler();
			parser.parse(new URL(url).openConnection().getInputStream(),hanlder);	
		} catch(Exception e) {
			throw new RuntimeException("정보를 전송 받는 중 오류 발생 !");
		}
	}
	
	public class SaxHandler extends DefaultHandler{
		String temp;
		News n;
		public void startElements(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("data")) {
				n = new News();
				list.add(n);
			}
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException {
			temp = new String(ch, start, length);
			
		}
		
		public void endElement(String uri, String localName, String qName) {
			if(qName.equals("title")) {
				n.setTitle(temp);
			} else if(qName.equals("desc")) {
				n.setDesc(temp);
			} else if(qName.equals("link")) {
				n.setLink(temp);
			}
		}
	}

	@Override
	public News search(int index) {
		return null;
	}
}
