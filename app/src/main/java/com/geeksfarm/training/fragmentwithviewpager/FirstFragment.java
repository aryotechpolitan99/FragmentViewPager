package com.geeksfarm.training.fragmentwithviewpager;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public ArrayList<MenuMakanan.Makanan> menuList;
    public MakananAdapter AdapterMakanan;
    public ListView lvMenumakanan;

    public static FirstFragment newInstance(String text){
        FirstFragment firstFragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString("text",text);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    // 4.1 Buat fungsi OnItemClickListener
    public void lvClick(){
        lvMenumakanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //4.2 pindah Activity dengan Intent
                Intent intent = new Intent(getActivity(),DescripActivity.class);
                intent.putExtra("DescMenu",AdapterMakanan.getItem(position));
                startActivity(intent);
            }
        });
    }

    private TextView textData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_first, container, false);


        AdapterMakanan = new MakananAdapter(getContext(),menuList);
        lvMenumakanan = rootView.findViewById(R.id.lv_firstfragment);

        lvMenumakanan.setAdapter(AdapterMakanan);

        //4.3 panggil fungsi onItemClick
        lvClick();

        return rootView;

    }

    public void setData(ArrayList<MenuMakanan.Makanan> dataMakanan){
        menuList = dataMakanan;
    }

}
