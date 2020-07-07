package com.example.libreriaultimatum2019_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LibrosIndividual extends AppCompatActivity {
    private int[] ArrayLibros = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_individual);
        ImageView imageView=findViewById(R.id.imgDescLibro);
        TextView tituloTexto=(TextView)findViewById(R.id.txtTituloLibro);
        TextView txtDescLibro=(TextView)findViewById(R.id.txtDescLibro);
        int id = getIntent().getIntExtra("id", 0);
        imageView.setImageResource(ArrayLibros[id]);
        tituloTexto.setText(getResources().getStringArray(R.array.titulosLibros)[id]);
        txtDescLibro.setText(getResources().getStringArray(R.array.descripcionLibros)[id]);

    }
}
