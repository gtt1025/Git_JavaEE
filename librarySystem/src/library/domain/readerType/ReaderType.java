package library.domain.readerType;

import java.util.HashSet;
import java.util.Set;

import library.domain.reader.Reader;


public class ReaderType {

	private Integer id;//读者类型id
	private String name;//类型名称
	private Integer quantity;//可借图书数量
	private Set<Reader> readerTs = new HashSet<Reader>(0);//相关联的读者类

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