package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.onboarding.data.MyDbHandler;

import java.util.ArrayList;
import java.util.List;

public class investorDashboard extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    List<StartupClass> investors=new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor_dashboard);

        initData();
        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initData() {


        userList=new ArrayList<>();
        MyDbHandler db=new MyDbHandler(investorDashboard.this);
//        investors.add(new InvestorClass(1321, "Top Investor","shjah@gmail.com","skyrim123","Invested in more than 10 companies and made them unicorns"));
//        investors.add(new InvestorClass(2638, "Top Investor, I guess","djgufw@gmail.com","skyrim123","Invested in more than 10 companies and made them unicorns"));
//        investors.add(new InvestorClass(8013, "Top Investor, sure","uhrdue@gmail.com","skyrim123","Invested in more than 10 companies and made them unicorns"));
//        investors.add(new InvestorClass(1439, "Top Investor, maybe","ufhuawe@gmail.com","skyrim123","Invested in more than 10 companies and made them unicorns"));
//        investors.add(new InvestorClass(8237, "Top Investor, not really","rdhfqia@gmail.com","skyrim123","Invested in more than 10 companies and made them unicorns"));

        for(StartupClass investor:investors){
            db.addContactStartup(investor);
        }
        investors=db.getAllStartups();
        for(StartupClass investor:investors){
            userList.add(new ModelClass(R.drawable.image1,investor.getCompany_name(),investor.getPhone(),investor.getDescription(),"___________________________________________________________________"));
        }



//        userList.add(new ModelClass(R.drawable.image1,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image4,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image4,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image1,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3,"People working","6:55 PM", "Yello!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image2,"Company Logo","6:54 PM", "Looking sick eh!", "_____________________"));
//
//        userList.add(new ModelClass(R.drawable.image3,"People working","6:55 PM", "Yello!", "_____________________"));


    }

}