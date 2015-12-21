package Model;

public class BaikeMsg {
	String url;
	private String title;
	private String summary;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public BaikeMsg(String url, String title, String summary) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.setTitle(title);
		this.setSummary(summary);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


}
