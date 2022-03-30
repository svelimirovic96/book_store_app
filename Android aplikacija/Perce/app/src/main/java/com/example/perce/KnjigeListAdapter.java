package com.example.perce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class KnjigeListAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Knjiga> knjige=new ArrayList<>();

    public KnjigeListAdapter(Context context, ArrayList<Knjiga> knjigeList){
        this.mContext=context;
        this.knjige=knjigeList;
    }

    @Override
    public int getCount() {
        return knjige.size();
    }

    @Override
    public Object getItem(int i) {
        return knjige.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view=LayoutInflater.from(this.mContext).inflate(R.layout.list_item, viewGroup, false);

        }
        Knjiga tmpKnjiga= (Knjiga) getItem(i);
        TextView tvNaziv=(TextView) view.findViewById(R.id.nazivKnjige);
        TextView tvAutor=(TextView) view.findViewById(R.id.autorKnjige);
        ImageView ivSlika=(ImageView) view.findViewById(R.id.slikaKnjige);

        tvNaziv.setText(tmpKnjiga.getNaziv());
        tvAutor.setText(tmpKnjiga.getAutor());
        ivSlika.setImageResource(tmpKnjiga.getIdSlika());

        if (tmpKnjiga.isPromocija()){

            ImageView ivProm=(ImageView) view.findViewById(R.id.promocija);
            ivProm.setImageResource(R.drawable.star);
        }
        return view;
    }
}
