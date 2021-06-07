/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
package com.kinantips.uts_akb_10118426_if10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashScreen.this, viewPager.class);
                splashScreen.this.startActivity(intent);
                splashScreen.this.finish();
            }
        }, 2000L);
    }
}