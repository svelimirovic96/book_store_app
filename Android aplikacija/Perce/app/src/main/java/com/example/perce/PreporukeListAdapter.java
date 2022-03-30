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

public class PreporukeListAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Preporuka> preporuke=new ArrayList<>();

    public PreporukeListAdapter(Context mContext, ArrayList<Preporuka> preporuke) {
        this.mContext = mContext;
        this.preporuke = preporuke;
    }

    @Override
    public int getCount() {
        return preporuke.size();
    }

    @Override
    public Object getItem(int i) {
        return preporuke.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(this.mContext).inflate(R.layout.list_item_preporuceno, viewGroup, false);

        }
        Preporuka tmpPreporuka= (Preporuka) getItem(i);
        TextView tvNazivKnjige=(TextView) view.findViewById(R.id.nazivKnj);
        TextView tvPreporucio=(TextView) view.findViewById(R.id.preporucio);
        ImageView ivSlikaKnjige=(ImageView) view.findViewById(R.id.slikaKnj);

        for (int j=0; j<MainActivity.korisnici.size(); j++){
            if (MainActivity.korisnici.get(j).getKor_ime().equals(tmpPreporuka.getPosiljalac())){
                tvPreporucio.setText("Preporučio/la: "+MainActivity.korisnici.get(j).getIme()+" "+MainActivity.korisnici.get(j).getPrezime());
                break;
            }
        }
        for (int j=0; j<MainActivity.knjige.size(); j++){
            if (MainActivity.knjige.get(j).getId()==tmpPreporuka.getKnjiga_id()){
                tvNazivKnjige.setText(MainActivity.knjige.get(j).getNaziv());
                ivSlikaKnjige.setImageResource(MainActivity.knjige.get(j).getIdSlika());
                break;
            }
        }
        return view;
    }
}
