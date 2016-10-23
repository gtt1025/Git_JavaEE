package library.domain.bookType;

import java.util.HashSet;
import java.util.Set;

import library.domain.book.Book;


public class BookType {

	private Integer id;//ͼ������id
	private String name;//ͼ����������
	private Set<Book> bookTs = new HashSet<Book>(0);//������ͼ����

	public BookType() {
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

	public Set<Book> getBookTs() {
		return this.bookTs;
	}

	public void setBookTs(Set<Book> bookTs) {
		this.bookTs = bookTs;
	}

}