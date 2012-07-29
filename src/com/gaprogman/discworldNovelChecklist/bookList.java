package com.gaprogman.discworldNovelChecklist;

import android.R.string;

public class bookList {
	book[] listOfBooks;
	
	public bookList(int numberOfBooks){
		listOfBooks = new book[numberOfBooks];
	}
	
	/* GET method */
	public book getBook (int ID){
		/* If the supplied index does not fall within
		 * the list of available books, then return
		 * the value of the first book in the list.
		 * Otherwise, return the value of the IDth
		 * book in the list */
		if (ID < listOfBooks.length){
			return listOfBooks[ID];
		}
		else{
			return listOfBooks[0];
		}
	}
	
	/* start SET methods */
	public void setBook(int ID, string nameOfBook, int releaseNumber, string releaseDate){
		listOfBooks[ID].setName(nameOfBook);
		listOfBooks[ID].setReleaseNumber(releaseNumber);
		listOfBooks[ID].setReleaseDate(releaseDate);
	}
	
	public void setBook(int ID, string nameOfBook, int releaseNumber){
		listOfBooks[ID].setName(nameOfBook);
		listOfBooks[ID].setReleaseNumber(releaseNumber);
	}
	/* end SET methods */
}