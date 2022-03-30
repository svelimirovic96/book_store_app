package com.example.perce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class KomentariOceneListAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<KomentarOcena> komentariOcene=new ArrayList<>();

    public KomentariOceneListAdapter(Context mContext, ArrayList<KomentarOcena> komentariOcene) {
        this.mContext = mContext;
        this.komentariOcene = komentariOcene;
    }

    @Override
    public int getCount() {
        return komentariOcene.size();
    }

    @Override
    public Object getItem(int i) {
        return komentariOcene.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(this.mContext).inflate(R.layout.list_item_oc, viewGroup, false);

        }
        KomentarOcena tmpKomOcena= (KomentarOcena) getItem(i);
        TextView tvKomentarKnjige=(TextView) view.findViewById(R.id.komentarKnjige);
        TextView tvKomentator=(TextView) view.findViewById(R.id.komentator);
        RatingBar rating=(RatingBar) view.findViewById(R.id.ocenaKnjige);

        tvKomentarKnjige.setText(tmpKomOcena.getKomentar());
        for (int j=0; j<MainActivity.korisnici.size(); j++){
            if (MainActivity.korisnici.get(j).getKor_ime().equals(tmpKomOcena.getOcenio())){
            tvKomentator.setText(MainActivity.korisnici.get(j).getIme()+" "+MainActivity.korisnici.get(j).getPrezime());
            break;
            }
            }
        rating.setRating(tmpKomOcena.getOcena());
        return view;
    }
}
