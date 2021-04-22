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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.k_popprofile.R;
import com.example.k_popprofile.data.BlackpinkData;
import com.example.k_popprofile.data.ItzyData;
import com.example.k_popprofile.data.RedvelvetData;
import com.example.k_popprofile.data.TwiceData;
import com.example.k_popprofile.model.GroupModel;
import com.example.k_popprofile.model.MemberModel;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    public ArrayList<MemberModel> memberList = new ArrayList<>();
    public ArrayList<MemberModel> memberList2 = new ArrayList<>();
    public ArrayList<MemberModel> memberList3 = new ArrayList<>();
    public ArrayList<MemberModel> memberList4 = new ArrayList<>();

    public Context context;
    public ArrayList<GroupModel> groupModels = new ArrayList<>();
    public String groupName;

    public GroupAdapter(Context context, ArrayList<GroupModel> groupModels) {
        this.context = context;
        this.groupModels = groupModels;
    }

    public ArrayList<GroupModel> getGroupModels() {
        return groupModels;
    }

    @NonNull
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View groupRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new ViewHolder(groupRow);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(getGroupModels().get(position).getGroupImage()).into(holder.ivGroup);
        holder.tvGroupName.setText(getGroupModels().get(position).getGroupName());
        holder.tvGroupDebut.setText(getGroupModels().get(position).getGroupDebut());
        holder.tvGroupEnt.setText(getGroupModels().get(position).getGroupEnt());
        groupName = getGroupModels().get(position).getGroupName();
        holder.tvGroupName2.setText(groupName);

        holder.rvMember.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.rvMember.getContext(), LinearLayoutManager.HORIZONTAL, false);
        holder.rvMember.setLayoutManager(linearLayoutManager);
        MemberAdapter memberAdapter;

        if(groupName.equals("Blackpink")){
            memberList.addAll(BlackpinkData.getMember());
            memberAdapter = new MemberAdapter(holder.rvMember.getContext(), memberList, groupName);
            holder.rvMember.setAdapter(memberAdapter);
        }
        else if(groupName.equals("Itzy")){
            memberList2.addAll(ItzyData.getMember());
            memberAdapter = new MemberAdapter(holder.rvMember.getContext(), memberList2, groupName);
            holder.rvMember.setAdapter(memberAdapter);
        }
        else if(groupName.equals("Redvelvet")){
            memberList3.addAll(RedvelvetData.getMember());
            memberAdapter = new MemberAdapter(holder.rvMember.getContext(), memberList3, groupName);
            holder.rvMember.setAdapter(memberAdapter);
        }
        else if(groupName.equals("Twice")){
            memberList4.addAll(TwiceData.getMember());
            memberAdapter = new MemberAdapter(holder.rvMember.getContext(), memberList4, groupName);
            holder.rvMember.setAdapter(memberAdapter);
        }

        holder.rvMember.setRecycledViewPool(viewPool);

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
        TextView tvGroupName, tvGroupDebut, tvGroupEnt, tvGroupName2;
        Button btnShare;
        public RecyclerView rvMember;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivGroup = itemView.findViewById(R.id.group_list_iv);
            tvGroupName = itemView.findViewById(R.id.group_list_nama);
            tvGroupDebut = itemView.findViewById(R.id.group_list_debut);
            tvGroupEnt = itemView.findViewById(R.id.group_list_ent);
            btnShare = itemView.findViewById(R.id.group_list_share);
            rvMember = itemView.findViewById(R.id.list_member);
            tvGroupName2 = itemView.findViewById(R.id.groupName);
        }
    }
}
