package com.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class File {

	@Id
	private int id;
	private String fileName;

	public File() {
	}

	public File(int id, String fileName) {
		this.id = id;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", fileName=" + fileName + "]";
	}

}
