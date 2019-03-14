package com.example.nguyenvancong_1706020007;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lvDT;
    ArrayList<String> arCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvDT = (ListView)findViewById(R.id.lvDienThoai);
        arCourse = new ArrayList<>();

        arCourse.add("Samsung Galaxy J6");
        arCourse.add("Samsung Galaxy A7");
        arCourse.add("Xiaomi Redmi 6A");
        arCourse.add("Xiaomi Redmi Noe 7");

        ArrayAdapter adapter = new ArrayAdapter(Main2Activity.this, android.R.layout.simple_list_item_1, arCourse);
        lvDT.setAdapter(adapter);
        lvDT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(Main2Activity.this, arCourse.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        lvDT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(Main2Activity.this, "Long Click: "
                        + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
