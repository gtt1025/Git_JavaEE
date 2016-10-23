package library.domain.barcode;

import java.util.HashSet;
import java.util.Set;

import library.domain.book.Book;
import library.domain.borrow.Borrow;


public class Barcode {

	private Integer id;//Õº È±‡∫≈id
	private Book bookT;//Õº È
	private String barcode;//Õº È±‡∫≈
	private Set<Borrow> borrowTs = new HashSet<Borrow>(0);//Õº ÈΩË‘ƒ

	public Barcode() {
	}

	public Barcode(Integer id) {
		this.id = id;
	}

	public Barcode(Integer id, Book bookT, String barcode, Set<Borrow> borrowTs) {
		this.id = id;
		this.bookT = bookT;
		this.barcode = barcode;
		this.borrowTs = borrowTs;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBookT() {
		return this.bookT;
	}

	public void setBookT(Book bookT) {
		this.bookT = bookT;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Set<Borrow> getBorrowTs() {
		return this.borrowTs;
	}

	public void setBorrowTs(Set<Borrow> borrowTs) {
		this.borrowTs = borrowTs;
	}

}