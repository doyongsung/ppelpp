package com.bitcamp.orl.member.domain;


import org.springframework.web.multipart.MultipartFile;

public class MemberEditRequest {

    private MultipartFile memberPhoto;
    private String memberName;
    private String memberEmail;
    private String memberNickname;
    private String birth;

    public MemberEditRequest() {
    }

    public MemberEditRequest(MultipartFile memberPhoto, String memberName, String memberEmail, String memberNickname, String birth) {
        this.memberPhoto = memberPhoto;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberNickname = memberNickname;
        this.birth = birth;
    }

    public MultipartFile getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(MultipartFile memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "MemberEditRequest{" +
                "memberPhoto=" + memberPhoto +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}