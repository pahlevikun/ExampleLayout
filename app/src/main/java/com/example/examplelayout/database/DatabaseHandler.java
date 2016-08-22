package com.example.examplelayout.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.examplelayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farhan on 8/15/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // Versi Database
    public static final int DATABASE_VERSION = 4;

    // Nama Database
    public static final String DATABASE_NAME = "examplelayout";

    // Nama Tabel
    public static final String TABLE_MENU = "menu";

    // Tabel Nasihat
    public static final String KEY_ID = "_id";
    public static final String KEY_GAMBAR = "gambar";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_CLASS = "class";
    public Resources res;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        res = context.getResources();
    }

    // Creating Tables
    @Override
        public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MENU = "CREATE TABLE " + TABLE_MENU + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_GAMBAR + " INTEGER,"
                + KEY_NAMA + " TEXT," + KEY_CLASS + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_MENU);

        insertMenu(db);

    }

    public void insertMenu(SQLiteDatabase db){

        ContentValues value = new ContentValues();
        //Record 1
        value.put(KEY_GAMBAR, R.drawable.ic_menu_article);
        value.put(KEY_NAMA, "Article");
        value.put(KEY_CLASS, "");
        db.insert(TABLE_MENU, null, value);
        //Record 2
        value.put(KEY_GAMBAR, R.drawable.ic_menu_testimony);
        value.put(KEY_NAMA, "Testimony");
        value.put(KEY_CLASS, "");
        db.insert(TABLE_MENU, null, value);
        //Record 3
        value.put(KEY_GAMBAR, R.drawable.ic_menu_gallery);
        value.put(KEY_NAMA, "Gallery");
        value.put(KEY_CLASS, "");
        db.insert(TABLE_MENU, null, value);
        //Record 4
        value.put(KEY_GAMBAR, R.drawable.ic_menu_about);
        value.put(KEY_NAMA, "About");
        value.put(KEY_CLASS, "");
        db.insert(TABLE_MENU, null, value);
        //Record 5
        value.put(KEY_GAMBAR, R.drawable.ic_menu_reservation);
        value.put(KEY_NAMA, "Reservation");
        value.put(KEY_CLASS, "");
        db.insert(TABLE_MENU, null, value);
        //Record 6
        value.put(KEY_GAMBAR, 0);
        value.put(KEY_NAMA, "");
        value.put(KEY_CLASS, "");
        db.insert(TABLE_MENU, null, value);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);

        // Create tables again
        onCreate(db);
    }

}
