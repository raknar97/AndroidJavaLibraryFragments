package com.example.libreriaultimatum2019_2020;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AutoresFragment extends Fragment implements ItemClickListener {
    RecyclerView listaAutores;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup=(ViewGroup)inflater.inflate(R.layout.autores_fragment,container,false);
        listaAutores=viewGroup.findViewById(R.id.autoresListFragment);
        AutoresAdapter autoresAdapter=new AutoresAdapter(getActivity(), this);
        listaAutores.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        listaAutores.setAdapter(autoresAdapter);
        return viewGroup;
    }

    public static AutoresFragment newInstance(){
        return new AutoresFragment();
    }
    //click hacia los libros del autor
    @Override
    public void onItemClick(int position)
    {
        LibrosFragment librosFragment = LibrosFragment.newInstance(position);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragments,librosFragment);
        fragmentTransaction.commit();

    }




}

