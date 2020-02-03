package com.geeksfarm.training.fragmentwithviewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStatePagerAdapter {

    private static ArrayList<String> myTitles;
    private static ArrayList<String> myData;
    private static ArrayList<MenuMakanan> myFoodMenu; // Buat ArrayList dengan Tipe data object (MenuMAkanan)= merupakan class


    private static int numOfItems;

    public static MyAdapter newInstance(FragmentManager fragmentManager, ArrayList<String> titles,ArrayList<String> data){ //3 parameter
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myTitles = titles;
        myData = data;
        numOfItems = data.size(); // set numOfItems as size of data or titles
        return myAdapter;
    }

    // Overload newInstance() above
    public static MyAdapter newInstance(FragmentManager fragmentManager, ArrayList<MenuMakanan> kumpulanMenuMakanan){ // menjadi 2 parameter
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myFoodMenu = kumpulanMenuMakanan;
        numOfItems = kumpulanMenuMakanan.size();
        return myAdapter;
    }




    //constructor
    public MyAdapter(FragmentManager fragmentManager){
        super(fragmentManager); //Deprecated
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { //function
        String text = myFoodMenu.get(position).getData(); // ambil dari getData Di class MenuMaknan

        //FirstFragment firstFragment = new FirstFragment();
        FirstFragment firstFragment = FirstFragment.newInstance(text); //call newInstance()

        return firstFragment;

    }

    @Override
    public int getCount() {
        return numOfItems;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = myFoodMenu.get(position).getNamaMenu(); //berubah jadi object MenuMakanan menu.getNamaMenu() dari class MenuMakanan
        return title;

    }
}
