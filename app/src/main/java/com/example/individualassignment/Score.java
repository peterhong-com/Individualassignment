package com.example.individualassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class Score {
    public static final String MYDATABASE_NAME = "RankList" +
            "";
    public static final String MYDATABASE_TABLE = "MY_TABLE";
    public static final int MYDATABASE_VERSION = 2;
    public static final String KEY_CONTENT = "SCORE";
    public static final String KEY_CONTENT1="NAME";

    private static final String SCRIPT_CREATE_DATABASE = "create table " + MYDATABASE_TABLE + "("+KEY_CONTENT +  " int not null," + KEY_CONTENT1 + " text not null"+");";
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;
    public Score(Context c) {
        context = c;
    }
    public Score openToRead() throws
            android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }
    public Score openToWrite() throws
            android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null,MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        sqLiteHelper.close();
    }
    public long insert(int content2,String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CONTENT, content2);
        contentValues.put(KEY_CONTENT1, name);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null,
                contentValues);
    }
    public int deleteAll() {
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);}
    public String queue25() {
        ArrayList<Integer> ss = new ArrayList<>();
        String[] columns = new String[] { KEY_CONTENT,KEY_CONTENT1 };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,null,
                null, null, null, KEY_CONTENT+" DESC", "25");
        String result = "";
        int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
        int index_CONTENT1 =cursor.getColumnIndex(KEY_CONTENT1);
        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            System.out.println(cursor.getString(index_CONTENT1));
            result = result + cursor.getString(index_CONTENT)+"                         "+cursor.getString(index_CONTENT1)+"\n";}
        return result;
    }
    public ArrayList<Integer> queue() {
        ArrayList<Integer> a = new ArrayList<>();
        String[] columns = new String[]{KEY_CONTENT,KEY_CONTENT1};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, null,
                null, null, null, KEY_CONTENT + " DESC", "25");

        int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);

        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            a.add(Integer.parseInt(cursor.getString(index_CONTENT)));
        }
        return a;
    }
    public class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SCRIPT_CREATE_DATABASE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }
    }
    /*Use the ideas from Q1, modify the SQLiteAdapter to create a table with one autoincrement ID and 3 other content fields (2 Strings and 1 integer).
            3. Show only results that are fulfilling specific criteria for one of the String content.
4. Sort the data according to the other String content.
5. Show the sum of the integer based on the String content.
6. Allow user to key in the information from the interface and display upon a button
            click.*/
}
