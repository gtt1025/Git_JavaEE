package library.domain.reader;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import library.domain.borrow.Borrow;
import library.domain.operator.Operator;
import library.domain.readerType.ReaderType;


public class Reader {

	private Integer id;// 读者id
	private ReaderType readerTypeT;// 读者类型
	private Operator operatorT;// 操作人
	private String name;// 读者登录帐号
	private String password;// 读者登录密码
	private String identiCode;// 读者借书证号
	private String realName;// 读者真实姓名
	private Short sex;// 性别
	private String papertype;// 注册证件类型
	private String paperNo;// 注册证件号码
	private String tel;// 联系电话
	private String email;// Email地址
	private Date registTime;// 注册时间
	private String description;// 备注
	private Set<Borrow> borrowTs = new HashSet<Borrow>(0);// 关联的借还操作

	public Reader() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ReaderType getReaderTypeT() {
		return this.readerTypeT;
	}

	public void setReaderTypeT(ReaderType readerTypeT) {
		this.readerTypeT = readerTypeT;
	}

	public Operator getOperatorT() {
		return this.operatorT;
	}

	public void setOperatorT(Operator operatorT) {
		this.operatorT = operatorT;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentiCode() {
		return this.identiCode;
	}

	public void setIdentiCode(String identiCode) {
		this.identiCode = identiCode;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public String getPapertype() {
		return this.papertype;
	}

	public void setPapertype(String papertype) {
		this.papertype = papertype;
	}

	public String getPaperNo() {
		return this.paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Borrow> getBorrowTs() {
		return this.borrowTs;
	}

	public void setBorrowTs(Set<Borrow> borrowTs) {
		this.borrowTs = borrowTs;
	}

}