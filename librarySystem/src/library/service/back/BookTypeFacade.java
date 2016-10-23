package library.service.back;

import java.util.List;

import library.domain.bookType.BookType;


public interface BookTypeFacade {
	public boolean newBookType(BookType readerType);

	public boolean removeBookType(BookType readerType);

	public List<BookType> findBookType();

	public BookType showBookType(BookType readerType);

	public boolean editBookType(BookType readerType);
}
