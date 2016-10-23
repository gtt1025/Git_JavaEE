package library.domain.readerType;

import java.util.HashSet;
import java.util.Set;

import library.domain.reader.Reader;


public class ReaderType {

	private Integer id;//��������id
	private String name;//��������
	private Integer quantity;//�ɽ�ͼ������
	private Set<Reader> readerTs = new HashSet<Reader>(0);//������Ķ�����

	public ReaderType() {
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Set<Reader> getReaderTs() {
		return this.readerTs;
	}

	public void setReaderTs(Set<Reader> readerTs) {
		this.readerTs = readerTs;
	}

}