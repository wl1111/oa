package com.company.bean;

import java.util.Date;

public class Blog {

	private int id;

	private int kid;

	private int uid;

	private String title;

	private String schema;

	private String content;

	private int clicks;

	private Date datetime;

	 

	public Blog(int id, int kid, int uid, String title, String schema, String content, int clicks) {
		super();
		this.id = id;
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
	}

	/**
	 * 博客的构造方法，全部参数
	 */
	public Blog(int id, int kid, int uid, String title, String schema,
			String content, int clicks, Date datetime) {
		super();
		this.id = id;
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
		this.datetime = datetime;
	}

	public Blog(int kid, int uid, String title, String schema, String content,
			int clicks, Date datetime) {
		super();
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public Date getdatetime() {
		return datetime;
	}

	public void setdatetime(Date datetime) {
		this.datetime = datetime;
	}

}
