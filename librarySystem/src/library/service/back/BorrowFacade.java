package library.service.back;

import java.util.List;

import library.domain.borrow.Borrow;
import library.domain.operator.Operator;


public interface BorrowFacade {
	public String borrowBook(String barcode, String identiCode,
			Operator operator);

	public String giveBackBook(String barcode, Operator operator);

	public List<Borrow> warningBack();

	public Object[] historyBorrowed(Integer first, Integer max);
}
