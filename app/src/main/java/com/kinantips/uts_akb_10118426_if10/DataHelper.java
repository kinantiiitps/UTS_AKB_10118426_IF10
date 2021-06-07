/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
package com.kinantips.uts_akb_10118426_if10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    public static final String NAMA_DATABASE = "db_notes";
    public static final String NAMA_TABEL = "tabel_notes";

    public static final String ROW_ID = "id";
    public static final String ROW_NAMA_NOTES = "Nama_notes";
    public static final String ROW_TANGGAL_NOTES = "Tanggal_notes";
    public static final String ROW_KETERANGAN = "Keterangan";

    public static final int DATABASE_VERSION = 2;

    private SQLiteDatabase db;

    public DataHelper(Context context) {
        super(context, NAMA_DATABASE, null, DATABASE_VERSION);
        db = getWritableDatabase();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
            String sql = "CREATE TABLE "+ NAMA_TABEL +"("+ ROW_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ ROW_NAMA_NOTES +" TEXT,"+ ROW_TANGGAL_NOTES +" TEXT,"+ ROW_KETERANGAN +" TEXT)";
            db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS" +NAMA_TABEL);
    }
    public Cursor semuaData() {
        Cursor cur = db.rawQuery("SELECT * FROM " +NAMA_TABEL,null);
        return cur;
    }
    public Cursor satuData(long id) {
        Cursor cur = db.rawQuery("SELECT * FROM " +NAMA_TABEL + "WHERE " +ROW_ID+"="+id,null);
        return cur;
    }
    public void tambahData(ContentValues values){
        db.insert(NAMA_TABEL,null,values);
    }
    public void editData(ContentValues values, long id){
        db.update(NAMA_TABEL, values,ROW_ID+"="+id,null);
    }
    public void hapusData(long id){
        db.delete(NAMA_TABEL,ROW_ID+"="+id,null);
    }


}
