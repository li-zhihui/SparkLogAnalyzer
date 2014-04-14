package com.intel.spark.log.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author frank
 * 
 * @param <T1>
 *            Child
 * @param <T2>
 *            Parent
 */
public abstract class Node<T1, T2> {
	private List<T1> children = new ArrayList<T1>();
	private String str;
	private Node<T1, T2> parent;

	public List<T1> getChildren() {
		return children;
	}

	public void setChildren(List<T1> children) {
		this.children = children;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Node<T1, T2> getParent() {
		return parent;
	}

	public void setParent(Node<T1, T2> parent) {
		this.parent = parent;
	}

	public T1 getLastChild() throws Exception {
		if (children == null || children.isEmpty()) {
			throw new Exception(this + " hasn't child, can't be process.");
		}
		return children.get(children.size() - 1);
	}
}
