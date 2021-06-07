/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
package com.kinantips.uts_akb_10118426_if10;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Notes extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView ls;
    DataHelper handler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_info);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Notes.this, MainActivity.class);
                startActivity(inte);
            }
        });

        handler = new DataHelper(this);
        ls = (ListView) findViewById(R.id.listNotes);
        ls.setOnItemClickListener(this);
        setupListView();


    }

    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(Notes.this);
        builder.setMessage("Apakah anda ingin keluar dari Aplikasi?");
        builder.setCancelable(true);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void setupListView(){
        Cursor cursor = handler.semuaData();
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor, 1);
        ls.setAdapter(customCursorAdapter);
        ls.setDividerHeight(0);
    }

    public void onItemClick(AdapterView<?>adapterView, View view, int i, long l){
        TextView getId = (TextView) view.findViewById(R.id.listID);
        final long id = Long.parseLong(getId.getText().toString());
        Cursor cur = handler.satuData(id);
        cur.moveToFirst();

        String ket = cur.getString(cur.getColumnIndex(DataHelper.ROW_KETERANGAN));
        final String namaNotes = cur.getString(cur.getColumnIndex(DataHelper.ROW_NAMA_NOTES));
        final AlertDialog.Builder builder = new AlertDialog.Builder(Notes.this);
        builder.setTitle("Daftar Notes");
        builder.setMessage(ket);
        builder.setPositiveButton("HAPUS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogHapusItem(id ,namaNotes);
            }
        });
        builder.setNegativeButton("EDIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent tanggalNotes = new Intent(Notes.this, EditNotes.class);
                tanggalNotes.putExtra(DataHelper.ROW_ID, id);
                startActivity(tanggalNotes);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void dialogHapusItem(final long id, String nama) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Notes.this);
        builder1.setTitle("Hapus Data " + nama);
        builder1.setMessage("Apakah Anda Yakin Ingin Menghapus Data " + nama +"?");
        builder1.setPositiveButton("HAPUS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handler.hapusData(id);
                setupListView();
            }
        });
        builder1.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Cancel
            }
        });
        AlertDialog dialog = builder1.create();
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupListView();
    }


}
