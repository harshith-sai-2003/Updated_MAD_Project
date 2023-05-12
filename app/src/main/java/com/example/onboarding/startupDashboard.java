package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.onboarding.data.MyDbHandler;

import java.util.ArrayList;
import java.util.List;

public class startupDashboard extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    List<StartupClass> startups;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_dashboard);

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initData() {


        userList = new ArrayList<>();
        MyDbHandler db=new MyDbHandler(startupDashboard.this);
        startups=db.getAllStartups();

        for(StartupClass startup:startups){
            userList.add(new ModelClass(R.drawable.image1,startup.getCompany_name(),startup.getDescription(),startup.getPhone(),"_____________________"));
        }

//        userList.add(new ModelClass(R.drawable.image1, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image4, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image4, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image1, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3, "People working", "6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2, "Company Logo", "6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3, "People working", "6:55 PM", "Yello!", "_____________________"));

    }
}