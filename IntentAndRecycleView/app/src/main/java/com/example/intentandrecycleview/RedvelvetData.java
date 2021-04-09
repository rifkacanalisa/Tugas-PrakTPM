package com.example.intentandrecycleview;

import java.util.ArrayList;

public class RedvelvetData {
    private static String[] memberName = {
            "Irene Bae Juhyun",
            "Kang Seulgi",
            "Wendy Son Seungwan",
            "Joy Park Sooyoung",
            "Kim Yerim"
    };
    private static String[] memberBirth = {
            "March 29, 1991",
            "February 10, 1994",
            "February 21, 1994",
            "September 3, 1996",
            "March 5, 1999"
    };
    private static String[] memberPos = {
            "Leader, Main Rapper, Lead Dancer, Sub Vocalist, Visual, Center",
            "Main Dancer, Lead Vocalist",
            "Main Vocalist",
            "Lead Rapper, Sub Vocalist",
            "Sub Vocalist, Sub Rapper, Maknae"
    };
    private static int[] memberImage = {
            R.drawable.irene,
            R.drawable.seulgi,
            R.drawable.wendy,
            R.drawable.joy,
            R.drawable.yeri
    };

    private static String[] memberBirthplace = {
            "Daegu, South Korea",
            "Ansan, Gyeonggi-do, South Korea",
            "Seongbuk-dong, Seoul, South Korea",
            "Jeju Island, South Korea",
            "Seoul, South Korea"
    };

    private static String[] memberNickname = {
            "Baechu, The 2nd Tiffany, Hyun-ah",
            "Kkangseul, GomDoli and Teddy Bear",
            "Olaf, Wan-ah",
            "Doongdoongie, cute Joy, and Malgeumi (bright)",
            "Squirtle, Yeriana, and Malgeumi (bright)"
    };
    public static ArrayList<MemberModel> getMember() {
        MemberModel memberModel = null;
        ArrayList<MemberModel> memberList = new ArrayList<>();

        for(int i = 0; i< memberName.length; i++){
            memberModel = new MemberModel();
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
