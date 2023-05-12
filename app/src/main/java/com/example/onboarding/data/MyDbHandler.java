package com.example.onboarding.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.onboarding.InvestorClass;
import com.example.onboarding.ModelClass;
import com.example.onboarding.StartupClass;
import com.example.onboarding.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+Params.TABLE_NAME+
                "(" +Params.KEY_REG_NO+" INTEGER PRIMARY KEY, "+
                Params.KEY_COMPANY_NAME+" TEXT, "+
                Params.KEY_PHONE+" INTEGER, "+Params.KEY_PASSWORD+" TEXT, "+Params.KEY_DESC+" TEXT);";
        db.execSQL(query);
         query="CREATE TABLE "+Params.TABLE_NAME2+
                "(" +Params.KEY_REG_NO2+" INTEGER PRIMARY KEY, "+
                Params.NAME+" TEXT, "+
                Params.KEY_INV_PASSWORD+" INTEGER, "+Params.KEY_EMAIL+" TEXT, "+Params.KEY_FIN_DESC+" TEXT);";
        db.execSQL(query);
        Log.d("tables","tables created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addContactStartup(StartupClass contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_REG_NO,contact.getReg_no());
        values.put(Params.KEY_COMPANY_NAME,contact.getCompany_name());
        values.put(Params.KEY_PHONE,contact.getPhone());
        values.put(Params.KEY_PASSWORD,contact.getPassword());
        values.put(Params.KEY_DESC,contact.getDescription());
        db.insert(Params.TABLE_NAME,null,values);
        db.close();
    }

    public void addContactInvestor(InvestorClass contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_REG_NO2,contact.getReg_no());
        values.put(Params.NAME,contact.getName());
        values.put(Params.KEY_EMAIL,contact.getEmail());
        values.put(Params.KEY_PASSWORD,contact.getPassword());
        values.put(Params.KEY_FIN_DESC,contact.getDescription());
        db.insert(Params.TABLE_NAME,null,values);
        db.close();
    }

    public List<StartupClass> getAllStartups(){
        List<StartupClass> startupList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String select="SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                StartupClass startup=new StartupClass();
                startup.setReg_no(Integer.parseInt(cursor.getString(0)));
                startup.setCompany_name(cursor.getString(1));
                startup.setPhone(cursor.getString(2));
                startup.setDescription(cursor.getString(4));
                startupList.add(startup);
            }while(cursor.moveToNext());
        }
        return startupList;
    }

}

