package com.example.intentandrecycleview;

import java.util.ArrayList;

public class GroupData {

    private static String[] groupName = {
            "Blackpink",
            "Itzy",
            "Redvelvet",
            "Twice"
    };

    private static String[] groupDebut = {
            "August 8th, 2016",
            "February 11, 2019",
            "August 1, 2014",
            "October 20, 2015"
    };

    private static String[] groupEnt = {
            "YG",
            "JYP",
            "SM",
            "JYP"
    };

    private static int[] groupImage = {
            R.drawable.blackpink,
            R.drawable.itzy,
            R.drawable.redvelvet,
            R.drawable.twice
    };

    public static ArrayList<GroupModel> getGroup() {
        GroupModel groupModel = null;
        ArrayList<GroupModel> groupList = new ArrayList<>();
        for(int i=0; i < groupName.length; i++){
            groupModel = new GroupModel();
            groupModel.setGroupName(groupName[i]);
            groupModel.setGroupDebut(groupDebut[i]);
            groupModel.setGroupEnt(groupEnt[i]);
            groupModel.setGroupImage(groupImage[i]);

            groupList.add(groupModel);
        }

        return groupList;
    }
}
