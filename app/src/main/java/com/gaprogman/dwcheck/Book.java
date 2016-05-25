package com.gaprogman.dwcheck;

import java.util.Date;

/**
 * Created by JayTizzle on 25/05/2016.
 */

public class Book {
    public int id;
    public String title;
    public String isbn;
    public Date releaseDate;
    public String coverUrl;
    public String synopsis;
    public boolean hasRead;
    public Date lastReadDate;
    public int readCount;

    /**
     * Constructor for Book object. Assume that the Book
     * is not owned by the user in the first instance.
     */
    public Book() {
        hasRead = false;
    }

    /**
     * Used to return an integer representing whether the user has
     * marked that they have read this Book object
     * (SQLite stores boolean values as integers)
     * @return 1 if hasRead is true, or 0 if not
     */
    public int HasReadAsInt() {
        return this.hasRead ? 1 : 0;
    }
}
