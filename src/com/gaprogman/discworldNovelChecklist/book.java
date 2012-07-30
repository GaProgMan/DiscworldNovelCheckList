package com.gaprogman.discworldNovelChecklist;

public class book {
	private String name;
	
	public book (){
		this.name = "";
	}
	
	public book(String nameOfBook){
		this.name = nameOfBook;
	}
	
	/* start GET methods */
	public String getName() {
		return name;
	}
	
	/* end GET methods */
	
	/* start SET methods */
	public void setName(String nameOfBook){
		this.name = nameOfBook;
	}
	/* end SET methods */
}
