package com.gaprogman.discworldNovelChecklist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.R.string;

public class CheckListWindowWindow extends Activity {
	
	bookList listOfBooks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list_window_window);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_check_list_window_window, menu);
        return true;
    }
}
