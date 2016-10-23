package library.domain.borrow;

import java.util.Date;

import library.domain.barcode.Barcode;
import library.domain.operator.Operator;
import library.domain.reader.Reader;


public class Borrow {

	private Integer id;// �軹��¼id
	private Barcode barcodeT;// ͼ����
	private Reader readerT;// ��������
	private Operator operatorTByBorrowOperator;// ���������
	private Operator operatorTByGivebackOperator;// ���������
	private Date borrowTime;// ����ʱ��
	private Short renew;// �ɷ�����
	private Date forceBackTime;// ���ĵ���ʱ��
	private Short giveback;// �Ƿ�黹
	private Date givebackTime;// ����ʱ��

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