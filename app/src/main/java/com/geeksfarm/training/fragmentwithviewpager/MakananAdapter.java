package com.geeksfarm.training.fragmentwithviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MakananAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MenuMakanan.Makanan> daftar;

    public MakananAdapter(Context context, ArrayList<MenuMakanan.Makanan> daftarmenu){
        this.context = context;
        this.daftar = daftarmenu;
    }

    @Override
    public int getCount() {
        return daftar.size();
    }

    @Override
    //3.panggil objek MenuMakanan.Makanan
    public MenuMakanan.Makanan getItem(int position) {
        MenuMakanan.Makanan food = daftar.get(position);
        return daftar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        MenuMakanan.Makanan cuuretItem = (MenuMakanan.Makanan) getItem(position);

        TextView tvnamaMAkanan = (TextView)convertView.findViewById(R.id.tvName);
        TextView tvnamaHarga = (TextView) convertView.findViewById(R.id.tvHome);

        tvnamaMAkanan.setText(cuuretItem.getNama());
        tvnamaHarga.setText(cuuretItem.getHarga());
        
        return convertView;
    }
}
