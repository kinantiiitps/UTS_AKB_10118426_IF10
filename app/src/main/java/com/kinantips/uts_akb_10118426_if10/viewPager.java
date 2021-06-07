/*Tanggal pengerjaan : 6 Juni 2021
NIM     : 10118426
Nama    : Kinanti Trimutiara Putri Setiawan
Kelas	: IF-10*/
package com.kinantips.uts_akb_10118426_if10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class viewPager extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    TextView tv_page_counter;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        List<Fragment> List = new ArrayList<>();
        List.add(new viewPager1());
        List.add(new viewPager2());
        List.add(new viewPager3());

        tv_page_counter = findViewById(R.id.defaultPager);


        pager = findViewById(R.id.viewPager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),List);

        pager.setAdapter(pagerAdapter);


    }

    public void pindahProfile(View view){
        Intent intent2 = new Intent(viewPager.this,MainActivity.class);
        startActivity(intent2);
        finish();

    }

}