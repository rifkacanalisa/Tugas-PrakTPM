package com.example.k_popprofile.data;

import com.example.k_popprofile.R;
import com.example.k_popprofile.model.MemberModel;

import java.util.ArrayList;

public class TwiceData {

    private static String[] stageName = {
            "Nayeon",
            "Jeongyeon",
            "Momo",
            "Sana",
            "Jihyo",
            "Mina",
            "Dahyun",
            "Chaeyoung",
            "Tzuyu"
    };

    private static String[] memberName = {
            "Im Nayeon",
            "Yoo Jeongyeon",
            "Hirai Momo",
            "Minatozaki Sana",
            "Park Jihyo",
            "Sharon Myoui Mina",
            "Kim Dahyun",
            "Son Chaeyoung",
            "Chou Tzuyu"
    };
    private static String[] memberBirth = {
            "September 22, 1995",
            "November 1, 1996",
            "November 9, 1996",
            "December 29, 1996",
            "February 1, 1997",
            "March 24, 1997",
            "May 28, 1998",
            "April 23, 1999",
            "June 14, 1999"
    };
    private static String[] memberPos = {
            "Lead Vocalist, Lead Dancer, Center",
            "Lead Vocalist",
            "Main Dancer, Sub Vocalist, Sub Rapper",
            "Sub Vocalist",
            "Leader, Main Vocalist",
            "Main Dancer, Sub Vocalist",
            "Lead Rapper, Sub Vocalist",
            "Main Rapper, Sub Vocalist",
            "Lead Dancer, Sub Vocalist, Visual, Maknae"
    };
    private static int[] memberImage = {
            R.drawable.nayeon,
            R.drawable.jeongyeon,
            R.drawable.momo,
            R.drawable.sana,
            R.drawable.jihyo,
            R.drawable.mina,
            R.drawable.dahyun,
            R.drawable.chaeyoung,
            R.drawable.tzuyu
    };
    private static String[] memberBirthplace = {
            "Seoul, South Korea",
            "Suwon, South Korea",
            "Kyōtanabe, Kyoto, Japan",
            "Tennōji-ku, Osaka, Japan",
            "Guri, Gyeonggi-do, South Korea",
            "San Antonio, Texas, United States",
            "Seongnam, Gyeonggi-do, South Korea",
            "Seoul, South Korea",
            "Tainan, Taiwan"
    };

    private static String[] memberNickname = {
            "Nabongs, Nasoong, Bunny unnie, Squirtle, Fake Maknae, Mat-nae, Princess Nayeon, Bunny Smile, Rabbit Nayeon, Pretty Girl, Little Eugene",
            "Dad of TWICE, Ostrich, No Jam Hyung, Yoojung Sunbae, Girl Crush",
            "mom of TWICE, Peach, Momorin, Moguri, Racoon, Dancing Mo-chine, Muk-Mo, Jokbal Queen",
            "SShana, Satang, Kim Sana, Sandarella, Hamjji Sana, Squirrel, Hamster, Sanake, Sanaconda",
            "Thomas, Kimchi-hyo, god-Jihyo, Mic",
            "Minari, Miguri, Black Swan, Penguin, Mitang, Jeongnam, Annoying Orange",
            "Dubu, Baby Eagle, Heung-bu, Tofu, Dah-ong",
            "Chaeng, No Jam Dongsaeng, Baby Beast, Chaengcasso, Strawberry Princess, Pretty Rap Star, Tiger Cub",
            "Chocolate, Chewy, Jayoo, and Yoda"
    };

    public static ArrayList<MemberModel> getMember() {
        MemberModel memberModel = null;
        ArrayList<MemberModel> memberList = new ArrayList<>();
        for(int i=0; i< memberName.length; i++){
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
