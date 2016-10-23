package library.domain.operator;

import java.util.HashSet;
import java.util.Set;

import library.domain.book.Book;
import library.domain.borrow.Borrow;
import library.domain.reader.Reader;


public class Operator {

	private Integer id;//
	private String name;//
	private String password;//
	private Short system;//
	private Short reader;//
	private Short book;//
	private Short borrow;//
	private Short query;//
	//关联的读者
	private Set<Reader> readerTs = new HashSet<Reader>(0);
	//关联的借书操作
	private Set<Borrow> borrowTsForBorrowOperator = new HashSet<Borrow>(0);
	//关联的还书操作
	private Set<Borrow> borrowTsForGivebackOperator = new HashSet<Borrow>(0);
	//关联的图书
	private Set<Book> bookTs = new HashSet<Book>(0);

	public Operator() {
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Short getSystem() {
		return this.system;
	}

	public void setSystem(Short system) {
		this.system = system;
	}

	public Short getReader() {
		return this.reader;
	}

	public void setReader(Short reader) {
		this.reader = reader;
	}

	public Short getBook() {
		return this.book;
	}

	public void setBook(Short book) {
		this.book = book;
	}

	public Short getBorrow() {
		return this.borrow;
	}

	public void setBorrow(Short borrow) {
		this.borrow = borrow;
	}

	public Short getQuery() {
		return this.query;
	}

	public void setQuery(Short query) {
		this.query = query;
	}

	public Set<Reader> getReaderTs() {
		return this.readerTs;
	}

	public void setReaderTs(Set<Reader> readerTs) {
		this.readerTs = readerTs;
	}

	public Set<Borrow> getBorrowTsForBorrowOperator() {
		return this.borrowTsForBorrowOperator;
	}

	public void setBorrowTsForBorrowOperator(
			Set<Borrow> borrowTsForBorrowOperator) {
		this.borrowTsForBorrowOperator = borrowTsForBorrowOperator;
	}

	public Set<Borrow> getBorrowTsForGivebackOperator() {
		return this.borrowTsForGivebackOperator;
	}

	public void setBorrowTsForGivebackOperator(
			Set<Borrow> borrowTsForGivebackOperator) {
		this.borrowTsForGivebackOperator = borrowTsForGivebackOperator;
	}

	public Set<Book> getBookTs() {
		return this.bookTs;
	}

	public void setBookTs(Set<Book> bookTs) {
		this.bookTs = bookTs;
	}

}