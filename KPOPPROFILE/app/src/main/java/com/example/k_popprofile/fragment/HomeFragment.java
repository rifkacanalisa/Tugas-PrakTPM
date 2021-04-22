package com.example.k_popprofile.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k_popprofile.R;
import com.example.k_popprofile.adapter.GroupAdapter;
import com.example.k_popprofile.data.GroupData;
import com.example.k_popprofile.model.GroupModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public RecyclerView rvGroup;
    public ArrayList<GroupModel> groupList = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvGroup = view.findViewById(R.id.activitymain_rv);
        rvGroup.setHasFixedSize(true);
        groupList.addAll(GroupData.getGroup());

        rvGroup.setLayoutManager(new LinearLayoutManager(getContext()));
        GroupAdapter groupAdapter = new GroupAdapter(getContext(), GroupData.getGroup());
        rvGroup.setAdapter(groupAdapter);
    }
}