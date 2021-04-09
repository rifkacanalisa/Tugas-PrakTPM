package com.example.intentandrecycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View groupRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new MemberAdapter.ViewHolder(groupRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // menggunakan glide agar tidak berat untuk menampilkan gambar
        Glide.with(mcontext).load(getMemberModels().get(position).getMemberImage()).into(holder.ivMember);
       // holder.ivMember.setImageResource(getMemberModels().get(position).getMemberImage());
        holder.tvMemberName.setText(getMemberModels().get(position).getMemberName());
        holder.tvMemberBirthday.setText(getMemberModels().get(position).getMemberBirth());
        holder.tvMemberPosition.setText(getMemberModels().get(position).getMemberPos());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mcontext, ActivityDetailsMember.class);
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
        TextView tvMemberName, tvMemberBirthday, tvMemberPosition;
        Button btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMember = itemView.findViewById(R.id.listMemberImage);
            tvMemberName = itemView.findViewById(R.id.listMemberName);
            tvMemberBirthday = itemView.findViewById(R.id.listMemberBirth);
            tvMemberPosition = itemView.findViewById(R.id.listMemberPos);
            btnDetail = itemView.findViewById(R.id.listMemberDetail);

        }
    }
}
