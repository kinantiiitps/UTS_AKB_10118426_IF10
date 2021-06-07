/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
package com.kinantips.uts_akb_10118426_if10;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomCursorAdapter extends CursorAdapter {

    private LayoutInflater ly;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags){
        super(context, c, flags);
        ly = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = ly.inflate(R.layout.fragment_catatan,viewGroup,false);
        MyHolder holder = new MyHolder();
        holder.listID = (TextView)v.findViewById(R.id.listID);
        holder.listNama = (TextView)v.findViewById(R.id.listNamaBarang);
        holder.listTanggal = (TextView)v.findViewById(R.id.listKeterangan);
        holder.listKeterangan = (TextView)v.findViewById(R.id.listJenisBarang);
        v.setTag(holder);
        return v;
    }

    public void bindView(View view, Context context, Cursor cursor){
        MyHolder holder = (MyHolder)view.getTag();
        holder.listID.setText(cursor.getString(cursor.getColumnIndex(DataHelper.ROW_ID)));
        holder.listNama.setText(cursor.getString(cursor.getColumnIndex(DataHelper.ROW_NAMA_NOTES)));
        holder.listTanggal.setText(cursor.getString(cursor.getColumnIndex(DataHelper.ROW_TANGGAL_NOTES)));
        holder.listKeterangan.setText(cursor.getString(cursor.getColumnIndex(DataHelper.ROW_KETERANGAN)));
    }

    class MyHolder{
        TextView listID;
        TextView listNama;
        TextView listTanggal;
        TextView listKeterangan;
    }


}
