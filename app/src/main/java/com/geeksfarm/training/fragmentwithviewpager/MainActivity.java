package com.geeksfarm.training.fragmentwithviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MyAdapter myAdapter;

    private TabLayout tabMenu;

    ArrayList<String> menuTitleData = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();

    ArrayList<MenuMakanan> kumpulanMenuMakanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateTitle();
        generateData();
        generateMenu();


        viewPager = findViewById(R.id.view_pager);
        //myAdapter = new MyAdapter(getSupportFragmentManager()); // buat object adapter
        myAdapter = MyAdapter.newInstance(getSupportFragmentManager(),kumpulanMenuMakanan);
        viewPager.setAdapter(myAdapter);

        tabMenu = findViewById(R.id.tab_menu);
        tabMenu.setupWithViewPager(viewPager);
    }

    // membuat dummy title data
    private void generateTitle(){
        menuTitleData.add("Promo");
        menuTitleData.add("A La Carte");
        menuTitleData.add("Paket Hemat");
        menuTitleData.add("Ayam");
        menuTitleData.add("Makanan");
        menuTitleData.add("Minuman");

    }

    private void generateData(){
        data.add("Data 1");
        data.add("Data 2");
        data.add("Data 3");
        data.add("Data 4");
        data.add("Data 5");
        data.add("Data 6");
    }

    private void generateMenu(){
        kumpulanMenuMakanan.add(new MenuMakanan("Promo","Data 1" ));
        kumpulanMenuMakanan.add(new MenuMakanan("Discount","Data 2" ));
        kumpulanMenuMakanan.add(new MenuMakanan("Hemat","Data 3" ));
        kumpulanMenuMakanan.add(new MenuMakanan("Cashback","Data 4" ));
        kumpulanMenuMakanan.add(new MenuMakanan("Serba 10k","Data 5" ));
        kumpulanMenuMakanan.add(new MenuMakanan("Istimewa","Data 6" ));

    }



}
