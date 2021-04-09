package com.example.intentandrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ActivityDetailsMember extends AppCompatActivity {
    Button btnShare;
    TextView tvNama, tvNickname, tvPosition, tvBirthday, tvBirthplace;
    ImageView ivMember;

    String name, birthday, position, birthplace, nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_member);

        tvNama = findViewById(R.id.member_name);
        tvBirthday = findViewById(R.id.member_birthday);
        tvPosition = findViewById(R.id.member_pos);
        tvBirthplace = findViewById(R.id.member_birthplace);
        tvNickname = findViewById(R.id.member_nickname);
        btnShare = findViewById(R.id.member_share);
        ivMember = findViewById(R.id.member_iv);

        Boolean check = checkIncoming();
        if (check.equals(true)){
            name = getIntent().getStringExtra("name");
            birthday = getIntent().getStringExtra("birthday");
            position = getIntent().getStringExtra("position");
            birthplace = getIntent().getStringExtra("birthplace");
            nickname = getIntent().getStringExtra("nickname");

            tvNama.setText(name);
            tvBirthday.setText(birthday);
            tvPosition.setText(position);
            tvBirthplace.setText(birthplace);
            tvNickname.setText(nickname);
            Glide.with(this).load(getIntent().getIntExtra("image",0)).into(ivMember);
        }

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareSubject = name;
                String shareBody = name+"\nBirth on "+birthday+" in "+birthplace+".\nHer position in the group is "+position+".\nHer nicknames is "+nickname+".";
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                share.putExtra(Intent.EXTRA_STREAM, getIntent().getIntExtra("image", 0));
                startActivity(Intent.createChooser(share, "Share using"));
            }
        });
    }

    private Boolean checkIncoming(){
        Boolean check = false;
        if(getIntent().hasExtra("name") && getIntent().hasExtra("birthday")){
            check = true;
        }
        return check;
    }
}
