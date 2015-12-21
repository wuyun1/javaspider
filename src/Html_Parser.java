import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import Model.BaikeMsg;
import Model.ParserData;


public class Html_Parser {


	public ParserData parse(String page_url, String html_cont) {
		// TODO Auto-generated method stub
		
		
		Document doc = Jsoup.parse(html_cont,"UTF-8");		
		
		ParserData result = new ParserData();
		
		List<String> new_urls = _get_new_urls(page_url,doc);
		BaikeMsg new_data = _get_new_data(page_url,doc);
		
		result.setBaikeMsg( new_data);
		result.setUrls(new_urls);	
		
		return result;
	}

	private BaikeMsg _get_new_data(String page_url, Document doc) {
		// TODO Auto-generated method stub
		String title = doc.select("dd.lemmaWgt-lemmaTitle-title>h1").get(0).text();
		List<String> summary=new ArrayList<String>();	
		Elements summary_nodes = doc.select("div.lemma-summary>.para");
		for (Element element : summary_nodes) {
			summary.add( element.text());			
		}		
		return new BaikeMsg(page_url,title,StringUtil.join(summary, "\n")  );
	}

	private List<String> _get_new_urls(String page_url, Document doc) {
		// TODO Auto-generated method stub
		URL base = null;
		try {
			base = new URL("http://baike.baidu.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pattern pattern = Pattern.compile("/view/\\d+\\.htm$");
		
		List<String> urls = new ArrayList<String>();
		for (Element ele : doc.select("a")) {
			String url = ele.attr("href");
			if(pattern.matcher(url).find()){
				if(url.indexOf("http://")!=0){
		  			try {
						url =  (new URL(base,url)).toString();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
				urls.add(url);
			}
		}
//	  	var links = $("a").toArray().map(function (ele) {
//	  		return $(ele).attr("href");
//	  	}).filter(function(value){
//	  		if(value){
//	  			return reg.test(value);
//	  		}
//	  	}).map(function (ele) {
//	  		if(ele.indexOf("http://")!==0){
//	  			return url.resolve(base,ele);
//	  		}else{
//	  			return ele;
//	  		}
//	  	});
		return urls;
	}

}
