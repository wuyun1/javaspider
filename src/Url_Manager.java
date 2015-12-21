import java.util.List;
import java.util.Stack;

public class Url_Manager {

	private Stack <String> urls;
	private Stack<String> crawed_urls;

	public Url_Manager() {
		// TODO Auto-generated constructor stub
		urls = new Stack<String>();
		crawed_urls = new Stack<String>();
	}

	public void add_new_url(String url) {
		// TODO Auto-generated method stub
		if (url == null || "".equals(url) || urls.contains(url)	|| crawed_urls.contains(url)) {
			return;
		}
		urls.push(url);

	}

	public boolean has_new_url() {
		// TODO Auto-generated method stub
		return urls.size()>0;
	}

	public String get_new_url() {
		// TODO Auto-generated method stub
		if(!has_new_url()){
			return null;
		}
		String new_url = urls.pop();
		crawed_urls.push(new_url);
		return new_url;
	}

	public void add_new_urls(String[] urls) {
		// TODO Auto-generated method stub
		if(urls==null || urls.length==0){
			return;
		}
		for (String url : urls) {
			add_new_url(url);
		}
	}

	public void add_new_urls(List<String> urls) {
		// TODO Auto-generated method stub
		if(urls==null || urls.size()==0){
			return;
		}
		for (String url : urls) {
			add_new_url(url);
		}
	}

}
