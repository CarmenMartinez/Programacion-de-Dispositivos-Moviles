package com.iteso.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carmenmartineznuno on 10/17/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 3;
    private static DataBaseHandler dataBaseHandler;

    private DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DataBaseHandler getInstance(Context context){
        if(dataBaseHandler == null){
            dataBaseHandler = new DataBaseHandler(context);
        }
        return dataBaseHandler;

    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createTable = "CREATE TABLE Student (id TEXT NOT NULL, " +
                "name TEXT, average DOUBLE)";
        sqLiteDatabase.execSQL(createTable);

        upgradeV2(sqLiteDatabase);
        upgradeV3(sqLiteDatabase);
    }

    public  void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        switch (oldVersion){
            case 1: upgradeV2(sqLiteDatabase);
            case 2: upgradeV3(sqLiteDatabase);
                break;

        }

    }

    private void upgradeV2(SQLiteDatabase sqLiteDatabase){
        String createTable = "CREATE TABLE Career (id INTEGER NOT NULL," +
                "name TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    private void upgradeV3(SQLiteDatabase sqLiteDatabase){
        String alterTable = "ALTER TABLE Student ADD COLUMN idCareer INTEGER";
        sqLiteDatabase.execSQL(alterTable);
    }


}