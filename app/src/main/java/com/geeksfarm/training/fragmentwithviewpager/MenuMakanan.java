package com.geeksfarm.training.fragmentwithviewpager;

import java.util.ArrayList;

public class MenuMakanan {
    private String namaMenu;
    private ArrayList<Makanan> data;

    public static class Makanan{
        private String nama;
        private String harga;

        public Makanan(String nm, String price){
            this.nama = nm;
            this.harga = price;
        }

        public String getNama() {
            return nama;
        }

        public String getHarga() {
            return harga;
        }
    }

    public MenuMakanan(String namaMenu, ArrayList<Makanan> data){
        this.namaMenu = namaMenu;
        this.data = data;
    }

    public String getNamaMenu(){
        return namaMenu;
    }

    public ArrayList<Makanan> getData(){
        return data;
    }
}
