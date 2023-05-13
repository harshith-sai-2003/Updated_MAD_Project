package com.example.onboarding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onboarding.data.MyDbHandler;
import com.example.onboarding.params.Params;

public class LoginTabFragment extends Fragment {

    EditText email,pass;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_login_tab, container, false);
        email=v.findViewById(R.id.startup_reg);
        pass=v.findViewById(R.id.login_password);
        MyDbHandler db=new MyDbHandler(getContext());
        String exec="SELECT * FROM "+ Params.TABLE_NAME+" WHERE "+Params.KEY_REG_NO+"="+Integer.parseInt(email.getText().toString())+";";
        Cursor cur=db.getReadableDatabase().rawQuery(exec,null);
        if(cur.getCount()==0){
            Log.d("wrong regNo","Entered registration number is invali or not registered");
        }
        else{
            if(pass.getText().toString()==cur.getString(3)){
                Toast.makeText(getContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity(),startupDashboard.class);
                startActivity(i);
            }
            else{
                Log.d("wrong password", "Password Incorrect");
            }
        }
        return v;
    }
}