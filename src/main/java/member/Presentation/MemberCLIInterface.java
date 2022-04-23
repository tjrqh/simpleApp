package member.Presentation;

import member.application.MemberApplication;
import member.application.MemberDto;
import member.domain.entity.Member;
import member.stepone.StepOneApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberCLIInterface {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final int signUp =1;
    public static final int signIn =2;
    public static final int logOut =3;
    public static final int read =4;
    public static final int update =5;
    public static final int exit =6;


    public static List<String> fileLineRead(String name) throws IOException {
        List<String> retStr = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(name));
        String s;
        while ((s = in.readLine()) != null) {
            retStr.add(s);
        }
        in.close();
        return retStr;
    }

    public int memberMenu() {
        Scanner sc = new Scanner(System.in);
        int memberMenu = 0;
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("4. 회원정보");
        System.out.println("5. 정보수정");
        System.out.println("6. 종료");

        while(true){
            try{
                memberMenu = sc.nextInt();
                if(memberMenu >= MemberCLIInterface.signUp && memberMenu <= MemberCLIInterface.exit){
                    break;
                }
                else{
                    System.out.printf("잘못 입력 되었습니다.");
                }
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println(" ! ");
            }
        }

        return memberMenu;
    }

    private MemberApplication memberApplication;

    public MemberCLIInterface(MemberApplication memberApplication) {
        this.memberApplication = memberApplication;
    }

    public boolean signUp(String id, String password, String name, String email){
        return this.memberApplication.signUp(new MemberDto(id, password, name, email));
    }

    public boolean signIn(String id, String password){
        return this.memberApplication.signIn();
    }

    public boolean logOut(String id){
        return this.memberApplication.logOut(id);
    }

    public MemberDto read(String id){
        return read(id);
    }

    public boolean updateName(String id){
        return false;
    }

    public boolean exit(String id){
        return false;
    }
}
