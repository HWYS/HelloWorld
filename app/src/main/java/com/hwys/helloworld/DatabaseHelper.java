package com.hwys.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htetwaiyanswe on 3/31/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    final String dbName = "Student";
    final int dbVersion = 1;

    public DatabaseHelper(Context context) {
        super(context, "Album", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE tbl_Student (id INTEGER PRIMARY KEY, subject TEXT, desp TEXT)");
        db.execSQL("CREATE TABLE tbl_Album(id INTEGER PRIMARY KEY, songName TEXT, artistName TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertAlbum(AlbumInfo albumInfo){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("songName", albumInfo.getSongName());
        cv.put("artistName", albumInfo.getArtistName());
        db.insert("tbl_Album", null, cv);

        db.close();
    }

    public void updateAlbum(AlbumInfo albumInfo){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        //cv.put("id", albumInfo.getId());
        cv.put("songName", albumInfo.getSongName());
        cv.put("artistName", albumInfo.getArtistName());
        db.update("tbl_Album", cv, "id = ? ", new String[] { Integer.toString(albumInfo.getId()) });

        db.close();
    }

    public List<AlbumInfo> getAllBum(){
        SQLiteDatabase db = getReadableDatabase();
        List<AlbumInfo>albumInfoList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Album", null);

        if(cursor.moveToFirst()){
            do{
                AlbumInfo info = new AlbumInfo();
                info.setSongName(cursor.getString(cursor.getColumnIndex("songName")));
                info.setArtistName(cursor.getString(cursor.getColumnIndex("artistName")));
                info.setId(cursor.getInt(cursor.getColumnIndex("id")));
                albumInfoList.add(info);
            }while (cursor.moveToNext());
        }

        return albumInfoList;
    }
}
