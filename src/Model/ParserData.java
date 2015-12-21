package Model;

import java.util.List;

public class ParserData {
	private BaikeMsg baikeMsg;
	private List<String> urls;
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> new_urls) {
		this.urls = new_urls;
	}
	public BaikeMsg getBaikeMsg() {
		return baikeMsg;
	}
	public void setBaikeMsg(BaikeMsg baikeMsg) {
		this.baikeMsg = baikeMsg;
	}
}
