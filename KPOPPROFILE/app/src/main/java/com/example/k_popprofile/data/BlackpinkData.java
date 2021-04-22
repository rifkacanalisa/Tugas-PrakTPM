package com.example.k_popprofile.data;

import com.example.k_popprofile.R;
import com.example.k_popprofile.model.MemberModel;

import java.util.ArrayList;

public class BlackpinkData {

    private static String[] stageName = {
            "Jisoo",
            "Jennie",
            "Rose",
            "Lisa"
    };

    private static String[] memberName = {
            "Kim Jisoo",
            "Kim Jennie",
            "Roseanne Park Chaeyoung",
            "Lalisa Manoban"
    };

    private static String[] memberBirth = {
            "January 3, 1995",
            "January 16, 1996",
            "February 11, 1997",
            "March 27, 1997"
    };

    private static String[] memberPos = {
            "Lead Vocalist, Visual",
            "Main Rapper, Lead Vocalist",
            "Main Vocalist, Lead Dancer",
            "Main Dancer, Lead Rapper, Sub Vocalist, Maknae"
    };

    private static int[] memberImage = {
            R.drawable.jisoo,
            R.drawable.jennie,
            R.drawable.rose,
            R.drawable.lisa
    };

    private static String[] memberBirthplace = {
            "Gunpo, South Korea",
            "Anyang, South Korea",
            "Auckland, New Zealand",
            "Buriram, Thailand"
    };

    private static String[] memberNickname = {
            "Chi Choo, Jichu",
            "NiNi, Jendeukie",
            "Rose, Rosie, Pasta",
            "Lili, Lalice, Laliz, Pokpak"
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
