package com.ScrumTool.BacklogItems;


import java.util.List;
import java.util.ArrayList;

public class Tree {
	 private long id;
	 private String name;
	 private long type;
	 private List<Tree> children;
	
	 public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public Tree(long id,String name,long type) {
	    this.id = id;
	    this.name = name;
	    this.type = type;
	    this.children = new ArrayList<>();
	 }
	
	 public String getName() {
		return name;
	 }

	 public void setName(String name) {
		this.name = name;
	 }

	 public long getId() {
	    return id;
	 }

	 public void setId(long id) {
	    this.id = id;
	 }

	 public List<Tree> getChildren() {
	    return children;
	 }

	 public void setChildren(List<Tree> children) {
	    this.children = children;
	 }
}