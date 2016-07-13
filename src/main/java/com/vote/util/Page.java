package com.vote.util;

import java.util.List;

public class Page {
	private Integer count;
	private List list;
	private Integer back;
	private Integer next;

	public Page(Integer count, List list) {
		super();
		this.list = list;
		this.count = count;
		// TODO Auto-generated constructor stub
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Page() {
		// TODO Auto-generated constructor stub
	}

	public void setBack(Integer back) {
		this.back = back;
	}

	public Integer getBack() {
		return back;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

}
