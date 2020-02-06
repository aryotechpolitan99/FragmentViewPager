package com.geeksfarm.training.fragmentwithviewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripActivity extends AppCompatActivity {
    // 1.1 dekalarasi variabel yang dibutuhkan
    TextView judulMakanan, descMakanan;
    ImageView ivMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descrip);

        //2.2 tampilkan data pada file activity_descrip.xml
        judulMakanan = findViewById(R.id.tv_bakso);
        descMakanan = findViewById(R.id.tv_descrip);
        ivMakanan = findViewById(R.id.iv_descrip);

        // 2.3 Menerima data extra Parcelable
        MenuMakanan.Makanan descMenu = getIntent().getParcelableExtra("DescMenu");
        if(descMenu != null){
            String _judulMakanan = descMenu.getJudulMakanan();
            String _descMakanan = descMenu.getDescripsi();
            Integer _ivMakanan = descMenu.getImage();

            //2.4 Ambil data dari data yang dikirim parcelable
            judulMakanan.setText(_judulMakanan);
            descMakanan.setText(_descMakanan);
            ivMakanan.setImageResource(_ivMakanan);
        }
    }
}
