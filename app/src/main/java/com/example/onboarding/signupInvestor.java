package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.onboarding.data.MyDbHandler;

public class signupInvestor extends AppCompatActivity {

    Button signup;
    EditText reg,name,email,pass,desc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_investor);
        signup=findViewById(R.id.investor_signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(signupInvestor.this,mainscreen.class);
                reg=findViewById(R.id.RegNo);
                name=findViewById(R.id.Name);
                email=findViewById(R.id.Email);
                pass=findViewById(R.id.PassWord);
                desc=findViewById(R.id.FinanceInfo);
                MyDbHandler db=new MyDbHandler(signupInvestor.this);
                db.addContactInvestor(new InvestorClass(Integer.valueOf(reg.getText().toString().trim()),name.getText().toString(),email.getText().toString(),pass.getText().toString(),desc.getText().toString()));
                Log.d("Jack","Jack Inserted!");
                startActivity(i);
            }
        });
    }
}