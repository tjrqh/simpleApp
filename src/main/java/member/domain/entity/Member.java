package member.domain.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String name;
    private String email;

    public Member(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private ArrayList<Member> memberList;
    Scanner sc = new Scanner(System.in);

    public Member(){
        memberList = new ArrayList<Member>();
        memberList.add(new Member("admin", "1234", "관리자","주소없음"));
    }



}
