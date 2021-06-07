package com.kinantips.uts_akb_10118426_if10;
/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
import android.content.ContentValues;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TambahData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TambahData extends Fragment {

    DataHelper handler;
    EditText NamaNote, TanggalNote, Keterangan;
    Button TambahData;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TambahData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TambahData.
     */
    // TODO: Rename and change types and number of parameters
    public static TambahData newInstance(String param1, String param2) {
        TambahData fragment = new TambahData();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tambah_data, container, false);

        handler = new DataHelper(getActivity());
        NamaNote = (EditText) v.findViewById(R.id.editJudul);
        TanggalNote = (EditText) v.findViewById(R.id.editTanggal);
        Keterangan = (EditText) v.findViewById(R.id.editKeterangan);

        TambahData = (Button) getActivity().findViewById(R.id.btnTambah);

        TambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaNotes = NamaNote.getText().toString().trim();
                String tanggalNotes = TanggalNote.getText().toString().trim();
                String keterangan = Keterangan.getText().toString().trim();
                /*if (namaNotes.equals("") || tanggalNotes.equals("") || keterangan.equals("")){
                    Toast.makeText(TambahData.this, "Pastikan Semua Data Terisi", Toast.LENGTH_LONG).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put(DataHelper.ROW_NAMA_NOTES,namaNotes);
                    values.put(DataHelper.ROW_TANGGAL_NOTES,tanggalNotes);
                    values.put(DataHelper.ROW_KETERANGAN,keterangan);
                    handler.tambahData(values);
                    Toast.makeText(TambahData.this,"Berhasil Input Data", Toast.LENGTH_LONG).show();
                }*/



            }
        }); return v;

    }
}