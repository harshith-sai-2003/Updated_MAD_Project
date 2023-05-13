package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.onboarding.data.MyDbHandler;

public class signupStartup extends AppCompatActivity {

    Button signup;
    EditText reg,name,email,desc,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_startup);
        signup=findViewById(R.id.startup_signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(signupStartup.this,mainscreen.class);
                reg=findViewById(R.id.RegNo);
                name=findViewById(R.id.companyName);
                email=findViewById(R.id.emailId);
                desc=findViewById(R.id.companyDesc);
                pass=findViewById(R.id.password);
                MyDbHandler db=new MyDbHandler(signupStartup.this);
                db.addContactStartup(new StartupClass(Integer.valueOf(reg.getText().toString().trim()),name.getText().toString(),email.getText().toString(),pass.getText().toString(),desc.getText().toString()));
                startActivity(i);
            }
        });
    }
}