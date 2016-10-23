package library.service.back;

import library.domain.barcode.Barcode;
import library.domain.book.Book;

public interface BookInfoFacade {
	public boolean newBook(Book book, Integer num);

	public boolean addNum(Book book, Integer num);

	public String removeBookBarcode(Barcode barcode);

	public Object[] findBook(Integer page, Integer max);

	public Barcode showBook(Barcode barcode);

	public boolean editBook(Book book);
}
