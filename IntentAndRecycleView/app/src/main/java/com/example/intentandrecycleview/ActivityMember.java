package com.example.intentandrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityMember extends AppCompatActivity {

    public RecyclerView rvMember;
    public TextView tv_title_activity, test;
    public ArrayList<MemberModel> memberList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        String groupName = checkIncoming();
        tv_title_activity = findViewById(R.id.title_activity_group);
        tv_title_activity.setText(groupName);

        rvMember = findViewById(R.id.activitymember_rv);
        rvMember.setHasFixedSize(true);
        if(groupName.equals("Blackpink")){
            memberList.addAll(BlackpinkData.getMember());
        }
        else if(groupName.equals("Itzy")){
            memberList.addAll(ItzyData.getMember());
        }
        else if(groupName.equals("Redvelvet")){
            memberList.addAll(RedvelvetData.getMember());
        }
        else if(groupName.equals("Twice")){
            memberList.addAll(TwiceData.getMember());
        }

        showRV(groupName);
    }

    private String checkIncoming(){
        String groupName = null;
        if(getIntent().hasExtra("groupName")){
            groupName = getIntent().getStringExtra("groupName");
        }
        return groupName;
    }

    private void showRV(String groupName){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvMember.setLayoutManager(linearLayoutManager);
        MemberAdapter memberAdapter = new MemberAdapter(this, memberList, groupName);
        rvMember.setAdapter(memberAdapter);
    }
}
