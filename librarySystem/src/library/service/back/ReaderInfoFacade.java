package library.service.back;

import library.domain.reader.Reader;

public interface ReaderInfoFacade {
	public boolean newReader(Reader reader);

	public String removeReader(Reader reader);

	public Object[] findReader(Integer page, Integer max);

	public Reader showReader(Reader reader);

	public boolean editReader(Reader readerType);
}
