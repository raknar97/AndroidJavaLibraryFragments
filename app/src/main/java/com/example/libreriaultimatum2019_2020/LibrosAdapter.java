package com.example.libreriaultimatum2019_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class LibrosAdapter extends PagerAdapter {
    Context context;
    int posicion;
    LibrosItemClick librosItemClick;

    public LibrosAdapter(Context context, LibrosItemClick librosItemClick, int posicion) {
        this.context = context;
        this.posicion = posicion;
        this.librosItemClick = librosItemClick;
    }

    public int getCount() {
        if (posicion == 0) {
            return 1;
        } else if (posicion == 1) {
            return 2;
        } else return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView libro = new ImageView(context);
        int id = 0;
        switch (posicion) {
            case 0:
                switch (position) {
                    case 0:
                        //posicion 0)rene goscini
                        id = R.drawable.img3;
                        break;

                }
                //id = R.drawable.img1;
                break;
            case 1:
                switch (position) {
                    case 0:
                        //posicion 0)JK Rowling
                        id = R.drawable.img1;
                        break;
                    case 1:
                        id = R.drawable.img2;
                        break;
                }
                //id = R.drawable.img2;
                break;
            case 2:
                switch (position) {
                    case 0:
                        id = R.drawable.img1;
                        break;
                    case 1:
                        id = R.drawable.img2;
                        break;
                    case 2:
                        id = R.drawable.img3;
                        break;

                }
                //id = R.drawable.img3;
                break;

        }
        libro.setImageResource(id);
        final int posi = position;
        libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                librosItemClick.onItemClicked(posi);
            }
        });
        container.addView(libro);
        return libro;
    }

    public interface LibrosItemClick {
        void onItemClicked(int position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}
