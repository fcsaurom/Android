package com.example.thicuoiky_de2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<model> {
    private Context mcontext;
    private int mresource;
    private List<model> list;
    TextView tv_product,tv_price,tv_currency,tv_note,tv_local,tv_time;
    public Adapter( Context context, int resource, List<model> objects) {
        super(context, resource, objects);
        this.mcontext = context;
        this.mresource = resource;
        this.list = objects;

    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {


        convertView = LayoutInflater.from(mcontext).inflate(mresource,parent,false);

        tv_product = convertView.findViewById(R.id.tv_product);
        tv_price = convertView.findViewById(R.id.tv_price);
        tv_note = convertView.findViewById(R.id.tv_note);
        tv_local = convertView.findViewById(R.id.tv_local);
        tv_currency = convertView.findViewById(R.id.tv_currency);
        tv_time = convertView.findViewById(R.id.tv_time);


        model model = list.get(position);
        tv_product.setText(model.getProduct());
        tv_price.setText(model.getPrice());
        tv_note.setText(model.getNote());
        tv_currency.setText(model.getCurency());
        tv_local.setText(model.getLocal());
        tv_time.setText(model.getTime());



        return convertView;
    }
}
