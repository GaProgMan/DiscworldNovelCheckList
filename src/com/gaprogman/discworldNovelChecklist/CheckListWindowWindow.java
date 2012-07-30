package com.gaprogman.discworldNovelChecklist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CheckListWindowWindow extends Activity {
	
	//public bookList listOfBooks;
	public String[] bookTitles;
	public book[] listOfBooks;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list_window_window);
        createBookList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_check_list_window_window, menu);
        return true;
    }
    
    public void createBookList(){
        bookTitles = getResources().getStringArray(R.array.bookTitles);
        listOfBooks = new book[bookTitles.length];
        for (int i = 0; i < bookTitles.length; i++){
        	listOfBooks[i] = new book(bookTitles[i]);
        }
    }
}
