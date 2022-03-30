package com.example.perce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KorisniciListAdapter extends BaseAdapter {
    ArrayList<Korisnik> listaKorisnika;
    Context mContext;
    Korisnik izabrani;

    private int mKorisnik = 0;


    public KorisniciListAdapter(Context mContext, ArrayList<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
        this.mContext = mContext;
        this.izabrani=null;
    }
    public void oznaciKorisnika(int i) {
        mKorisnik = i;
        this.izabrani=this.listaKorisnika.get(i);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int i) {
        if (i == mKorisnik) return 1;
        else return 0;
    }

    @Override
    public int getCount() {
        return listaKorisnika.size();
    }

    @Override
    public Object getItem(int i) {
        return listaKorisnika.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(this.mContext).inflate(R.layout.list_item_korisnik_za_preporuku, viewGroup, false);

        }
        Korisnik tmpKorisnik= (Korisnik) getItem(i);
        TextView tvIme=(TextView) view.findViewById(R.id.ime);
        TextView tvPrezime=(TextView) view.findViewById(R.id.prezime);

        tvIme.setText(tmpKorisnik.getIme());
        tvPrezime.setText(tmpKorisnik.getPrezime());

        int oznacen = getItemViewType(i);
        if(oznacen == 1) {
            view.setBackgroundColor(R.color.blue);
            tvIme.setTextColor(R.color.white);
            tvPrezime.setTextColor(R.color.white);
        }
        else {
            view.setBackgroundColor(R.color.white);
            tvIme.setTextColor(R.color.black);
            tvPrezime.setTextColor(R.color.black);
        }
        return view;
    }
}
