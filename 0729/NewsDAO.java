package hw10;

import java.util.List;

public interface NewsDAO {
	List<News> getNewsList(String url);
	News search(int index);
}
