package com.example.k_popprofile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.k_popprofile.ActivityDetailMember;
import com.example.k_popprofile.R;
import com.example.k_popprofile.model.MemberModel;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    public Context mcontext;
    public ArrayList<MemberModel> memberModels = new ArrayList<>();
    public String groupName = null;

    public MemberAdapter(Context context, ArrayList<MemberModel> memberModels, String groupName) {
        this.mcontext = context;
        this.memberModels = memberModels;
        this.groupName = groupName;
    }

    public ArrayList<MemberModel> getMemberModels() {
        return memberModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View groupRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new MemberAdapter.ViewHolder(groupRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mcontext).load(getMemberModels().get(position).getMemberImage()).into(holder.ivMember);
        holder.tvMemberStageName.setText(getMemberModels().get(position).getStageName());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mcontext, ActivityDetailMember.class);
                detail.putExtra("name", getMemberModels().get(position).getMemberName());
                detail.putExtra("birthday", getMemberModels().get(position).getMemberBirth());
                detail.putExtra("position", getMemberModels().get(position).getMemberPos());
                detail.putExtra("birthplace", getMemberModels().get(position).getMemberBirthplace());
                detail.putExtra("nickname", getMemberModels().get(position).getMemberNickName());
                detail.putExtra("image", getMemberModels().get(position).getMemberImage());
                mcontext.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getMemberModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMember;
        TextView tvMemberStageName;
        Button btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMember = itemView.findViewById(R.id.item_member_pict);
            tvMemberStageName = itemView.findViewById(R.id.item_member_name);
            btnDetail = itemView.findViewById(R.id.item_member_detail);
        }
    }
}
