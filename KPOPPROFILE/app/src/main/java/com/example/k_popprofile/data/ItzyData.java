package com.example.k_popprofile.data;

import com.example.k_popprofile.R;
import com.example.k_popprofile.model.MemberModel;

import java.util.ArrayList;

public class ItzyData {
    private static String[] stageName = {
            "Yeji",
            "Lia",
            "Ryujin",
            "Chaeryoung",
            "Yuna"
    };

    private static String[] memberName = {
            "Hwang Yeji",
            "Julia Choi Jisu",
            "Shin Ryujin",
            "Lee Chaeryoung",
            "Shin Yuna"
    };

    private static String[] memberBirth = {
            "May 26th, 2000",
            "July 21st, 2000",
            "April 17th, 2001",
            "June 5th, 2001",
            "December 9th, 2003"
    };

    private static String[] memberPos = {
            "Leader, Main Dancer, Lead Vocalist, Sub Rapper",
            "Main Vocalist, Sub Rapper",
            "Main Rapper, Lead Dancer, Sub Vocalist, Center",
            "Main Dancer, Sub Vocalist, Sub Rapper",
            "Lead Rapper, Lead Dancer, Sub Vocalist, Visual, Maknae"
    };

    private static int[] memberImage = {
            R.drawable.yeji,
            R.drawable.lia,
            R.drawable.ryujin,
            R.drawable.chaeryoung,
            R.drawable.yuna
    };

    private static String[] memberBirthplace = {
            "Jeonju, South Korea",
            "Incheon, South Korea",
            "Seoul, South Korea",
            "Yongin, South Korea",
            "Suwon, South Korea"
    };

    private static String[] memberNickname = {
            "Lucy",
            "Julia",
            "Joanne",
            "Judy, Chocolate Holic",
            "Hussey"
    };

    public static ArrayList<MemberModel> getMember() {
        MemberModel memberModel = null;
        ArrayList<MemberModel> memberList = new ArrayList<>();
        for(int i = 0; i< memberName.length; i++){
            memberModel = new MemberModel();
            memberModel.setStageName(stageName[i]);
            memberModel.setMemberName(memberName[i]);
            memberModel.setMemberBirth(memberBirth[i]);
            memberModel.setMemberPos(memberPos[i]);
            memberModel.setMemberImage(memberImage[i]);
            memberModel.setMemberNickName(memberNickname[i]);
            memberModel.setMemberBirthplace(memberBirthplace[i]);
            memberList.add(memberModel);
        }
        return memberList;
    }

}
