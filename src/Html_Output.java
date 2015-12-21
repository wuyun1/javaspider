import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import Model.BaikeMsg;


public class Html_Output {
	
	List<BaikeMsg> datas = null;
	
	public Html_Output() {
		// TODO Auto-generated constructor stub
		datas = new ArrayList<BaikeMsg>();
	}
	

	public void collect_data(BaikeMsg baikeMsg) {
		// TODO Auto-generated method stub
		datas.add(baikeMsg);
		
	}

	public void output_html() {
		// TODO Auto-generated method stub
		String html_tpl = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"gbk\"><title>Document</title></head><body></body></html>";
				
		Document out_html = Jsoup.parse(html_tpl,"UTF-8");
		Element table = out_html.createElement("table");
		for (BaikeMsg bkm : datas) {
			table.appendChild( out_html.createElement("tr").appendChild(out_html.createElement("td").text(bkm.getTitle())).appendChild(out_html.createElement("td").text(bkm.getSummary().replace("\n", "<br />\n"))));
		}
		out_html.getElementsByTag("body").get(0).appendChild(table);
		System.out.println(out_html);
		
		File html_file = new File("output_html.htm");
		try {
			new FileOutputStream(html_file).write(out_html.html().getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
