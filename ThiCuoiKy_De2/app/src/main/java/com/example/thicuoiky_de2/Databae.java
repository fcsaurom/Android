package com.example.thicuoiky_de2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Databae extends SQLiteOpenHelper {
    public  static final  String DATABASENAME ="spend";
    public  static final  String TABLEnAME ="TLBSPEND";
    public  static final  String ID = "Id";
    public  static final  String PRODUCT = "Product";
    public  static final  String PRICE ="price";
    public  static final  String NOTE = "note";
    public  static final  String CURRENCY ="currency";
    public  static final  String  LOCAL ="local";
    public  static final  String TIME = "Time";
    private  Context context;
    public Databae(Context context) {
        super(context, DATABASENAME,null , 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = String.format("CREATE TABLE IF NOT EXISTS %S (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT,%s TEXT)",
                TABLEnAME,ID,PRODUCT,PRICE,NOTE, CURRENCY,LOCAL,TIME);

        db.execSQL(createtable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public  void Add (model model)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put(ID,model.getId());
        values.put(PRODUCT,model.getProduct());
        values.put(PRICE,model.getPrice());
        values.put(NOTE,model.getNote());
        values.put(LOCAL,model.getLocal());
        values.put(CURRENCY,model.getCurency());
        values.put(TIME,model.getTime());

        db.insert(TABLEnAME,null,values);
        db.close();
    }

    public List<model> getAll()
    {
        List<model> models = new ArrayList<model>();
        String query = "SELECT * FROM " + TABLEnAME;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst())
        {
            do {
                model model = new model();
                model.setId(cursor.getInt(0));
                model.setProduct(cursor.getString(1));
                model.setPrice(cursor.getString(2));
                model.setNote(cursor.getString(3));
                model.setCurency(cursor.getString(4));
                model.setLocal(cursor.getString(5));
                model.setTime(cursor.getString(6));
                models.add(model);

            }while (cursor.moveToNext());
            cursor.close();
            sqLiteDatabase.close();
        }
        return  models;

    }
    public  void delete(model model)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLEnAME, ID + "=?",new String []{String.valueOf(model.getId())});
        db.close();
    }
}

