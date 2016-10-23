package library.domain.borrow;

import java.util.Date;

import library.domain.barcode.Barcode;
import library.domain.operator.Operator;
import library.domain.reader.Reader;


public class Borrow {

	private Integer id;// 借还记录id
	private Barcode barcodeT;// 图书编号
	private Reader readerT;// 读者类型
	private Operator operatorTByBorrowOperator;// 借书操作人
	private Operator operatorTByGivebackOperator;// 还书操作人
	private Date borrowTime;// 借书时间
	private Short renew;// 可否续借
	private Date forceBackTime;// 借阅到期时间
	private Short giveback;// 是否归还
	private Date givebackTime;// 还书时间

	public Borrow() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Barcode getBarcodeT() {
		return this.barcodeT;
	}

	public void setBarcodeT(Barcode barcodeT) {
		this.barcodeT = barcodeT;
	}

	public Reader getReaderT() {
		return this.readerT;
	}

	public void setReaderT(Reader readerT) {
		this.readerT = readerT;
	}

	public Operator getOperatorTByBorrowOperator() {
		return this.operatorTByBorrowOperator;
	}

	public void setOperatorTByBorrowOperator(Operator operatorTByBorrowOperator) {
		this.operatorTByBorrowOperator = operatorTByBorrowOperator;
	}

	public Operator getOperatorTByGivebackOperator() {
		return this.operatorTByGivebackOperator;
	}

	public void setOperatorTByGivebackOperator(
			Operator operatorTByGivebackOperator) {
		this.operatorTByGivebackOperator = operatorTByGivebackOperator;
	}

	public Date getBorrowTime() {
		return this.borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Short getRenew() {
		return this.renew;
	}

	public void setRenew(Short renew) {
		this.renew = renew;
	}

	public Date getForceBackTime() {
		return this.forceBackTime;
	}

	public void setForceBackTime(Date forceBackTime) {
		this.forceBackTime = forceBackTime;
	}

	public Short getGiveback() {
		return this.giveback;
	}

	public void setGiveback(Short giveback) {
		this.giveback = giveback;
	}

	public Date getGivebackTime() {
		return this.givebackTime;
	}

	public void setGivebackTime(Date givebackTime) {
		this.givebackTime = givebackTime;
	}

}