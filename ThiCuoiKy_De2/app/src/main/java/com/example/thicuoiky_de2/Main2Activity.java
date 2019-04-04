package com.example.thicuoiky_de2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    Button total_cost;
    EditText edt_cost;
    Adapter adapter;
    TextView show_cost;
    Button btn_add_new;
    List<model> list;
    TextView tv_time;
    ImageView btn_time;
    EditText edt_product,edt_price,edt_currency,edt_note,edt_local;
    String product,price,currency,note,time,local;
    Button btn_add,btn_cancel;
    SQLiteDatabase sqLiteDatabase;
    SharedPreferences sharedPreferences;
    public static final String MYRE = "MyPress";
    public static final String TOTAL_COST = "total";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        Databae databae = new Databae(Main2Activity.this);
        btn_add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });


        Load();
//        list = databae.getAll();
//        model model = new model(product,price,note,currency,time,local);
//        databae.Add(model);
//        list.addAll(databae.getAll());
        total_cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Cost = Integer.parseInt(edt_cost.getText().toString());
                SaveDAta(Cost);
                Load();

            }
        });






        adapter = new Adapter(Main2Activity.this,R.layout.custom_list,list);
        adapter.notifyDataSetChanged();
//        listView.setAdapter(adapter);









    }

    private void ShowDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_khoanchi);

        btn_time = dialog.findViewById(R.id.btn_time);
        edt_product =dialog.findViewById(R.id.edt_product);
        edt_price = dialog.findViewById(R.id.edt_price);
        edt_currency = dialog.findViewById(R.id.edt_curency);
        edt_note = dialog.findViewById(R.id.edtn_note);
        edt_local = dialog.findViewById(R.id.edt_local);
        tv_time = dialog.findViewById(R.id.tv_time);
        btn_add = dialog.findViewById(R.id.btn_adđ);
        btn_cancel = dialog.findViewById(R.id.btn_cancel);





        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int Year = calendar.get(Calendar.YEAR);
                int Month = calendar.get(Calendar.MONTH);
                int Day = calendar.get(Calendar.DATE);

                DatePickerDialog dialogs = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year,month,dayOfMonth);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        tv_time.setText(format.format(calendar.getTime()));

                    }
                },Year,Month,Day);



                dialogs.show();


            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = edt_product.getText().toString();
                price = edt_price.getText().toString();
                currency = edt_currency.getText().toString();
                note = edt_note.getText().toString();
                local = edt_local.getText().toString();
                time = tv_time.getText().toString();
                Databae databae = new Databae(Main2Activity.this);
                Toast.makeText(Main2Activity.this, product, Toast.LENGTH_SHORT).show();

                list = databae.getAll();
                model smodel = new model(product,price,note,currency,time,local);
                databae.Add(smodel);
                list.addAll(databae.getAll());

                adapter = new Adapter(Main2Activity.this,R.layout.custom_list,list);
                listView.setAdapter(adapter);

                edt_product.setText("");
                edt_price.setText("");
                edt_currency.setText("");
                edt_note.setText("");
                edt_local.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private void init() {
        total_cost = findViewById(R.id.btn_Edit_cost);
        edt_cost = findViewById(R.id.Total_cost);
        show_cost = findViewById(R.id.show_cost);
        listView = findViewById(R.id.list_view);
        btn_add_new = findViewById(R.id.btn_add_new);

    }
    private  void SaveDAta(int cost)
    {
        sharedPreferences = getSharedPreferences(MYRE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TOTAL_COST,cost);
        editor.apply();
    }
    private  void Load()
    {
        sharedPreferences = getSharedPreferences(MYRE,Context.MODE_PRIVATE);
        show_cost.setText(sharedPreferences.getInt(TOTAL_COST,0)+"");
    }

}
