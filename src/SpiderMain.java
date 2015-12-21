import Model.ParserData;


public class SpiderMain {

	/**
	 * @param args
	 */
	
	Html_Downloader downloader = null;
	Url_Manager urls = null;
	Html_Parser parser = null;
	Html_Output outputer = null;
	
	
	public SpiderMain() {
		// TODO Auto-generated constructor stub
		downloader = new Html_Downloader();
		urls = new Url_Manager();
		parser = new Html_Parser();
		outputer = new Html_Output();
		
	}
	
	public void craw(String root_url) {
		// TODO Auto-generated method stub
		urls.add_new_url(root_url);
	  	int count = 1;
	  	while(urls.has_new_url()){
	  		
	  		if(count>=2000){
	  			break;
	  		}
	  		try{
	  			String new_url = urls.get_new_url();
		  		System.out.println(String.format("craw %d  :  %s", count,new_url));
				String html_cont = downloader.download(new_url);
		  		if(html_cont == null||"error".equals(html_cont) ){
		  			throw new Exception("URL: \""+new_url+"\" unable access!");
		  		}			  		
		  		ParserData pd = parser.parse(new_url, html_cont);
		  		urls.add_new_urls(pd.getUrls());
		  		outputer.collect_data(pd.getBaikeMsg());
		  		
	  		}catch(Exception e){
	  			e.printStackTrace();
	  		}	  			  		
	  		count++;
	  		
	  		
	  	}
  		outputer.output_html();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String root_url = "http://baike.baidu.com/view/3974030.htm";
		SpiderMain sd = new SpiderMain();
		
		sd.craw(root_url);
	}

}
