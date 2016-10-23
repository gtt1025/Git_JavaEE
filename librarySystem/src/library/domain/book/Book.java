package library.domain.book;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import library.domain.barcode.Barcode;
import library.domain.bookType.BookType;
import library.domain.operator.Operator;


public class Book {

	private Integer id;// 图书id
	private BookType booktypeT;// 图书类型
	private Operator operatorT;//图书名称
	private String bookName;//图书名称
	private String author;//作者
	private String publisher;//图书出版社
	private Float price;//图书价格
	private Date inTime;//入馆时间
	private Set<Barcode> barcodeTs = new HashSet<Barcode>(0);//图书编号

	public Book() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BookType getBooktypeT() {
		return this.booktypeT;
	}

	public void setBooktypeT(BookType booktypeT) {
		this.booktypeT = booktypeT;
	}

	public Operator getOperatorT() {
		return this.operatorT;
	}

	public void setOperatorT(Operator operatorT) {
		this.operatorT = operatorT;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getInTime() {
		return this.inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Set<Barcode> getBarcodeTs() {
		return this.barcodeTs;
	}

	public void setBarcodeTs(Set<Barcode> barcodeTs) {
		this.barcodeTs = barcodeTs;
	}

}