package library.domain.liberInfo;

import java.util.Date;

public class LiberInfo {

	private Integer id;// 图书馆id
	private String liberName;// 图书馆名称
	private String curator;// 图书馆馆长
	private String tel;// 图书馆电话
	private String address;// 图书馆地址
	private String email;// 图书馆电子邮件
	private String url;// 图书馆网址
	private Date buildDate;// 图书馆建馆时间
	private String introduce;// 图书馆的简介

	public LiberInfo() {
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLiberName() {
		return this.liberName;
	}

	public void setLiberName(String liberName) {
		this.liberName = liberName;
	}

	public String getCurator() {
		return this.curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getBuildDate() {
		return this.buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}