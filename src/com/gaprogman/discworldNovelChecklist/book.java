package com.gaprogman.discworldNovelChecklist;

import android.R.string;

public class book {
	private android.R.string name;
	private int releaseNumber;
	private android.R.string releaseDate;
	
	/* start GET methods */
	public android.R.string getName() {
		return name;
	}
	
	public int getNumber(){
		return releaseNumber;
	}
	
	public android.R.string getReleaseDate(){
		return releaseDate;
	}
	/* end GET methods */
	
	/* start SET methods */
	public void setName(android.R.string nameOfBook){
		this.name = nameOfBook;
	}
	
	public void setReleaseNumber(int release){
		this.releaseNumber = release;
	}
	
	public void setReleaseDate(android.R.string dateOfRelease){
		this.releaseDate = dateOfRelease;
	}
	/* end SET methods */
}
