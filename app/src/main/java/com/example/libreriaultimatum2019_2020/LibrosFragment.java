package com.example.libreriaultimatum2019_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LibrosFragment extends Fragment implements LibrosAdapter.LibrosItemClick {

    ViewPager viewPager;
    int posicion;

    public LibrosFragment(int position) {
        this.posicion=position;
    }
    public static LibrosFragment newInstance(int position) {
        LibrosFragment fragment = new LibrosFragment(position);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_libros_fragment, container, false);
        viewPager=  view.findViewById(R.id.viewPager);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        LibrosAdapter adapter = new LibrosAdapter(getActivity(),this,posicion);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int position)
    {
        Intent intent=new Intent(getActivity(),LibrosIndividual.class);
        intent.putExtra("id", position);
        startActivity(intent);

    }












}
