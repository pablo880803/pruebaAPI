package com.microservicios.app.zuul.dto;

public class articles {

	private source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;
	
	
	
	/**
	 * 
	 */
	public articles() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param source
	 * @param author
	 * @param title
	 * @param description
	 * @param url
	 * @param urlToImage
	 * @param publishedAt
	 * @param content
	 */
	public articles(com.microservicios.app.zuul.dto.source source, String author, String title, String description,
			String url, String urlToImage, String publishedAt, String content) {
		super();
		this.source = source;
		this.author = author;
		this.title = title;
		this.description = description;
		this.url = url;
		this.urlToImage = urlToImage;
		this.publishedAt = publishedAt;
		this.content = content;
	}
	public source getSource() {
		return source;
	}
	public void setSource(source source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlToImage() {
		return urlToImage;
	}
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
}
