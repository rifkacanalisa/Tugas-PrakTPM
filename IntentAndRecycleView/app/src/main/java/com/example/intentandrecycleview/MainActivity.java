package com.example.intentandrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView rvGroup;
    public ArrayList<GroupModel> groupList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGroup = findViewById(R.id.activitymain_rv);
        rvGroup.setHasFixedSize(true);
        groupList.addAll(GroupData.getGroup());

        rvGroup.setLayoutManager(new LinearLayoutManager(this));
        GroupAdapter groupAdapter = new GroupAdapter(this, GroupData.getGroup());
        rvGroup.setAdapter(groupAdapter);
    }
}
