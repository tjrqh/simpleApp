package member.stepone;

import member.Presentation.MemberCLIInterface;
import member.application.MemberApplication;
import member.domain.repository.MemberRepository;
import member.infrastructure.MemberInMemoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StepOneApplication {
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

    public static void main(String args[]) throws IOException {
        MemberRepository memberRepository = new MemberInMemoryRepository();
        MemberApplication memberApplication = new MemberApplication(memberRepository);
        MemberCLIInterface memberCLIInterface = new MemberCLIInterface(memberApplication);
        while(true){
            switch (memberMenu()){
                case signUp:

            }
        }

    }

    public static int memberMenu() {
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
                if(memberMenu >=signUp && memberMenu <= exit){
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
}

