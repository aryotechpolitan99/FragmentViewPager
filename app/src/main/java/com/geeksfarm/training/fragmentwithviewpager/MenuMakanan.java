package com.geeksfarm.training.fragmentwithviewpager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MenuMakanan {
    private String namaMenu;
    private ArrayList<Makanan> data;

    //1.1 Implementasi parcelable dari class makanan
    public static class Makanan implements Parcelable {
        private String nama;
        private String harga;
        private Integer image;
        private String descripsi;
        private String judulMakanan;



        // 1.2 tambah parameter image, deskripsi dan judul makanan
        public Makanan(String nm, String price, Integer image, String deskripsi, String judulmakanan){
            this.nama = nm;
            this.harga = price;
            this.image = image;
            this.descripsi = deskripsi;
            this.judulMakanan = judulmakanan;
        }

        public String getNama() {
            return nama;
        }

        public String getHarga() {
            return harga;
        }
        public Integer getImage() {
            return image;
        }

        public String getDescripsi() {
            return descripsi;
        }
        public String getJudulMakanan() {
            return judulMakanan;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.nama);
            dest.writeString(this.harga);
            dest.writeValue(this.image);
            dest.writeString(this.descripsi);
            dest.writeString(this.judulMakanan);
        }

        protected Makanan(Parcel in) {
            this.nama = in.readString();
            this.harga = in.readString();
            this.image = (Integer) in.readValue(Integer.class.getClassLoader());
            this.descripsi = in.readString();
            this.judulMakanan = in.readString();
        }

        public static final Parcelable.Creator<Makanan> CREATOR = new Parcelable.Creator<Makanan>() {
            @Override
            public Makanan createFromParcel(Parcel source) {
                return new Makanan(source);
            }

            @Override
            public Makanan[] newArray(int size) {
                return new Makanan[size];
            }
        };
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
