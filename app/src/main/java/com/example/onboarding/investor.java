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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onboarding.data.MyDbHandler;
import com.example.onboarding.params.Params;


public class investor extends Fragment {

    Button login;
    TextView register;
    EditText email,pass;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_investor, container, false);

        login=v.findViewById(R.id.login_button_investor);
        register=v.findViewById(R.id.register_investor);
        email=v.findViewById(R.id.login_email);
        pass=v.findViewById(R.id.login_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),investorDashboard.class);
                MyDbHandler db=new MyDbHandler(getContext());
                String exec="SELECT * FROM "+ Params.TABLE_NAME2+" WHERE "+Params.KEY_EMAIL+"=\""+(email.getText().toString())+"\";";
                Cursor cur=db.getReadableDatabase().rawQuery(exec,null);
                if(cur.getCount()==0){
                    Log.d("invalid", "Email not registered or incorrect!");
                }
                else{
                    cur.moveToFirst();
                    if(pass.getText().toString().trim().equals(cur.getString(2))){
                        Toast.makeText(getContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),signupInvestor.class);
                startActivity(i);
            }
        });

        return v;
    }
}