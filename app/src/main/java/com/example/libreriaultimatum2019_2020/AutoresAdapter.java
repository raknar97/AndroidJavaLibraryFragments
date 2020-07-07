package com.example.libreriaultimatum2019_2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AutoresAdapter extends RecyclerView.Adapter {

    private ItemClickListener clicklistener;
    private LayoutInflater layoutInflater;

    AutoresAdapter(Context context, ItemClickListener clicklistener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.clicklistener = clicklistener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.autores_adapter, parent, false);
        return new AutoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AutoresViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class AutoresViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagen;
        TextView texto;

        AutoresViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imgAutor);
            texto = itemView.findViewById(R.id.nombreAutor);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            if (position == 1) {
                imagen.setImageResource(R.drawable.jkrowling);
                texto.setText(R.string.jk);
            } else {
                imagen.setImageResource(R.drawable.renegoscinny);
                texto.setText(R.string.rene);
            }
        }

        @Override
        public void onClick(View view) {
            clicklistener.onItemClick(getAdapterPosition());

        }
    }



}



