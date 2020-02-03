package com.geeksfarm.training.fragmentwithviewpager;

public class MenuMakanan {
    private String namaMenu;
    private String data;

    public MenuMakanan(String namaMenu, String data){
        this.namaMenu = namaMenu;
        this.data = data;
    }

    public String getNamaMenu(){
        return namaMenu;
    }

    public String getData(){
        return data;
    }
}
