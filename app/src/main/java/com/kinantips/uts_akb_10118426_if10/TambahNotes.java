/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
package com.kinantips.uts_akb_10118426_if10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahNotes extends AppCompatActivity {

    DataHelper handler;
    EditText NamaNote, TanggalNote, Keterangan;
    Button TambahData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_notes);

        handler = new DataHelper(this);

        NamaNote = (EditText) findViewById(R.id.editJudul);
        TanggalNote = (EditText) findViewById(R.id.editTanggal);
        Keterangan = (EditText) findViewById(R.id.editKeterangan);

        TambahData = (Button) findViewById(R.id.btnTambah);

        TambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaNotes = NamaNote.getText().toString().trim();
                String tanggalNotes = TanggalNote.getText().toString().trim();
                String keterangan = Keterangan.getText().toString().trim();
                if (namaNotes.equals("") || tanggalNotes.equals("") || keterangan.equals("")){
                    Toast.makeText(TambahNotes.this, "Pastikan Semua Data Terisi", Toast.LENGTH_LONG).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put(DataHelper.ROW_NAMA_NOTES,namaNotes);
                    values.put(DataHelper.ROW_TANGGAL_NOTES,tanggalNotes);
                    values.put(DataHelper.ROW_KETERANGAN,keterangan);
                    handler.tambahData(values);
                    Toast.makeText(TambahNotes.this,"Berhasil Input Data", Toast.LENGTH_LONG).show();
                }



            }
        });


    }
}