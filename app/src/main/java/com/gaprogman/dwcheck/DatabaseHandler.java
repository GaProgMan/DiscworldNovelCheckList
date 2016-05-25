package com.gaprogman.dwcheck;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by JayTizzle on 25/05/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // Table data
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dwCheck";
    private static final String BOOK_TABLE = "books";

    // column names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_ISBN = "isbn";
    private static final String KEY_RELEASE_DATE = "release_date";
    private static final String KEY_COVER_URL = "cover_url";
    private static final String KEY_SYNOPSIS = "synopsis";
    private static final String KEY_HAS_READ = "has_read";
    private static final String KEY_LAST_READ_DATE = "last_read_date";
    private static final String KEY_READ_COUNT = "read_count";

    // used for all date formatting
    private static final SimpleDateFormat ISO_DATE = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    // constructor
    public DatabaseHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOKS_TABLE = "CREATE TABLE " + BOOK_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
                + KEY_ISBN + " TEXT," + KEY_RELEASE_DATE + " TEXT,"
                + KEY_COVER_URL + " TEXT," + KEY_SYNOPSIS + " TEXT,"
                + KEY_HAS_READ + " INTEGER, " + KEY_LAST_READ_DATE + " TEXT, "
                + KEY_READ_COUNT + "INTEGER" + ")";
        db.execSQL(CREATE_BOOKS_TABLE);
    }

    // upgrade tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE);
        onCreate(db);
    }

    /*
     * CREATE methods - used to create instances in the database
     */

    /**
     * Adds a new Book record to the database
     * @param bookToAdd the instance of the Book class to add to the database
     */
    public void addBook(Book bookToAdd) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = BookToContenValues(bookToAdd);

        db.insert(BOOK_TABLE, null, values);
    }

    /*
     * READ methods - used to read values from the database
     */

    /**
     * Used to read a single DB record into a book object
     * @param _id the Id of the DB Record
     * @return a Book object, instanciated with the data in the DB Record
     */
    public Book getBook(int _id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + BOOK_TABLE + " WHERE " + KEY_ID + " == " + _id;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Book bookToReturn = ReadCursorToBook(cursor);
        cursor.close();

        return bookToReturn;
    }

    /**
     * Used to read all book records in teh database to a list of Book objects
     * @return a list of Book objects, instanciated from all records in teh database
     */
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<Book>();
        String selectQuery = "SELECT * FROM " + BOOK_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                allBooks.add(ReadCursorToBook(cursor));
            } while(cursor.moveToNext());
        }

        cursor.close();

        return allBooks;
    }

    /**
     * Used to get a count of all Book records in the database
     * @return the count of all Book records in the database
     */
    public int getBookCount() {
        String countQuery = "SELECT * FROM " + BOOK_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int recordCount = cursor.getCount();

        cursor.close();

        return recordCount;
    }

    /*
     * UPDATE methods - used to update database rows
     */

    /**
     * Used to update a Book DB Record with the values from a passed
     * in Book object
     * @param book The Book object to use
     * @return Id of the Book record updated
     */
    public int updateBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = BookToContenValues(book);

        return db.update(BOOK_TABLE, values, KEY_ID + " =?", new String[] {String.valueOf(book.id)});
    }


    /*
     * EXTENSION methods - Useful methods for the above CRUD ops
     */

    /**
     * Used to read the contents of a DB Cursor to a Book object
     * @param cursor the DB Cursor to read from
     * @return a Book object instanciated by
     */
    private Book ReadCursorToBook(Cursor cursor) {
        Book book = new Book();
        book.id = Integer.parseInt(cursor.getString(0));
        book.title = cursor.getString(1);
        book.isbn = cursor.getString(2);
        book.coverUrl = cursor.getString(4);
        book.synopsis = cursor.getString(5);
        book.hasRead = cursor.getString(6) == "1" ? true : false;
        book.readCount = Integer.parseInt(cursor.getString(8));

        // need to wrap these in try catches, but I'm not bothered
        // if there's an exception, as null date is a valid value
        try {
            book.releaseDate = ISO_DATE.parse(cursor.getString(3));
            book.lastReadDate = ISO_DATE.parse(cursor.getString(7));
        } catch (ParseException e) {
        }

        return book;
    }

    /**
     * Used to convert a Book object to a ContentValues object
     * for Create and Update operations
     * @param bookToAdd The Book object whos values to use in the ContentValues
     * @return a ContentValues object which represents the values of the Book passed in
     */
    private ContentValues BookToContenValues (Book bookToAdd) {
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, bookToAdd.title);
        values.put(KEY_ISBN, bookToAdd.isbn);
        values.put(KEY_RELEASE_DATE, ISO_DATE.format(bookToAdd.releaseDate));
        values.put(KEY_COVER_URL, bookToAdd.coverUrl);
        values.put(KEY_SYNOPSIS, bookToAdd.synopsis);
        values.put(KEY_HAS_READ, bookToAdd.HasReadAsInt());
        values.put(KEY_LAST_READ_DATE, bookToAdd.releaseDate != null ? ISO_DATE.format(bookToAdd.releaseDate) : "");
        values.put(KEY_READ_COUNT, bookToAdd.readCount);

        return values;
    }
}
