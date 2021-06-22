package com.video.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Video {
	protected String url;
	protected String titol;
	protected Date uploadDate;
	protected List<Tag> tags = new ArrayList<Tag>();
	protected String upload;
	protected String status;
	//protected long currentTime;
	//protected long maxTime;
	
	public Video(String titol) {
		this.titol = titol;
		this.url = "videoapp.com/" + titol;
		uploadDate = new Date();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void addTags(Tag tag) {
		if(tag != null) {
			tags.add(tag);
		}
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}
	
	public String getStatus() {
		if(upload == "Public") {
			return upload;
		} else {
			setStatus();
			return upload;
		}
	}
	
	public void setStatus() {
		Date actualTime = new Date();
		if(actualTime.getTime() - uploadDate.getTime() >= 2*60*1000 ) {
			upload = "Public";
		} else if (actualTime.getTime() - uploadDate.getTime() >= 60*1000) {
			upload = "Verifying";
		} else {
			upload = "Uploading";
		}
	}
}
