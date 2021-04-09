package com.example.intentandrecycleview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import java.io.File;
import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    public Context context;
    public ArrayList<GroupModel> groupModels = new ArrayList<>();

    public GroupAdapter(Context context, ArrayList<GroupModel> groupModels) {
        this.context = context;
        this.groupModels = groupModels;
    }

    public ArrayList<GroupModel> getGroupModels() {
        return groupModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View groupRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new ViewHolder(groupRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(getGroupModels().get(position).getGroupImage()).into(holder.ivGroup);
//        holder.ivGroup.setImageResource(getGroupModels().get(position).getGroupImage());
        holder.tvGroupName.setText(getGroupModels().get(position).getGroupName());
        holder.tvGroupDebut.setText(getGroupModels().get(position).getGroupDebut());
        holder.tvGroupEnt.setText(getGroupModels().get(position).getGroupEnt());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityMember.class);
                intent.putExtra("groupName", getGroupModels().get(position).getGroupName());
                context.startActivity(intent);
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareSubject = getGroupModels().get(position).getGroupName();
                String shareBody = getGroupModels().get(position).getGroupName()+"\nDebut on "+getGroupModels().get(position).getGroupDebut()+" from "+getGroupModels().get(position).getGroupEnt()+" Entertainment.";
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(share, "Share using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getGroupModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGroup;
        TextView tvGroupName, tvGroupDebut, tvGroupEnt;
        Button btnDetail, btnShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivGroup = itemView.findViewById(R.id.group_list_iv);
            tvGroupName = itemView.findViewById(R.id.group_list_nama);
            tvGroupDebut = itemView.findViewById(R.id.group_list_debut);
            tvGroupEnt = itemView.findViewById(R.id.group_list_ent);
            btnDetail = itemView.findViewById(R.id.group_list_detail);
            btnShare = itemView.findViewById(R.id.group_list_share);

        }
    }
}
