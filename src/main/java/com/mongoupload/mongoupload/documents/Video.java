package com.mongoupload.mongoupload.documents;

import java.io.InputStream;

public class Video {
	private String title;
	private InputStream stream;

	public Video() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}