package com.sap.domain;

public class Member {
    private Long member_id;//데이터베이스에 저장되는 아이디
    private String user_id;
    private String name;
    private String password;
    private String phone_number;
    private String address;
    private String email;
    private boolean agreed_to_policy;

    public Member(Long member_id, String user_id, String name, String password, String phone_number, String address, String email, boolean agreed_to_policy) {
        this.member_id = member_id;
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.agreed_to_policy = agreed_to_policy;
    }

    public Member() {

    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreed_to_policy() {
        return agreed_to_policy;
    }

    public void setAgreed_to_policy(boolean agreed_to_policy) {
        this.agreed_to_policy = agreed_to_policy;
    }
}
