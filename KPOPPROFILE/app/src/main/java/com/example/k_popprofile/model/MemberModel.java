package com.example.k_popprofile.model;

public class MemberModel {
    public String memberName, memberBirth, memberPos, memberBirthplace, memberNickName, stageName;
    public int memberImage;

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberBirth() {
        return memberBirth;
    }

    public void setMemberBirth(String memberBirth) {
        this.memberBirth = memberBirth;
    }

    public String getMemberPos() {
        return memberPos;
    }

    public void setMemberPos(String memberPos) {
        this.memberPos = memberPos;
    }

    public int getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(int memberImage) {
        this.memberImage = memberImage;
    }

    public String getMemberBirthplace() {
        return memberBirthplace;
    }

    public void setMemberBirthplace(String memberBirthplace) {
        this.memberBirthplace = memberBirthplace;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }
}
