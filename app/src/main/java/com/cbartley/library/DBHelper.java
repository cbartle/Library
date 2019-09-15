package com.cbartley.library;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;

import android.content.ContentValues;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {


    //information of database

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Library.db";

    public static final String TABLE_NAME = "Books";

    public static final String COLUMN_ID = "BookID";

    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_AUTHOR = "Author";
    public static final String COLUMN_GENRE = "Genre";



    //initialize the database

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ", "+
                COLUMN_TITLE + " TEXT" + ", " +
                COLUMN_AUTHOR + " TEXT" + ", " +
                COLUMN_GENRE + " TEXT )";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public List<Book> loadHandler() {

        //return GetFakeBooks();

        List<Book> books = new ArrayList();
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {

            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            String result_3 = cursor.getString(3);
            Book book = new Book(result_1, result_2, Genre.get(result_3));

            book.SetId(result_0);
            books.add(book);

        }
        cursor.close();
        return books;
    }

    public void addHandler(Book book) {

        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, 1);
        values.put(COLUMN_TITLE, book.GetTitle());
        values.put(COLUMN_AUTHOR, book.GetAuthor());
        values.put(COLUMN_GENRE, book.GetGenre().toString());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);

    }

    //search
    //public Book findHandler(String studentname) {}

    //Delete
    //public boolean deleteHandler(int ID) {}

    //Edit
    //public boolean updateHandler(int ID, String name) {}

    private List<Book> GetFakeBooks(){
        List<Book> books = new ArrayList<Book>();

        int i = 0;
        while( i < 11){
            books.add(new Book("Test Title " + Integer.toString(i), "Test Author " + Integer.toString(i), Genre.Action));
            i++;

        }
        return books;
    }
}
