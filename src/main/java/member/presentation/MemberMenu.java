package member.presentation;

import member.application.MemberApplication;
import member.infrastructure.MemberInMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class MemberMenu {
    private MemberApplication memberApplication;
    private BufferedReader br;
    private MemberSignUp memberSignUp;

    private static final int SIGN_UP = 1;
    private static final int SIGN_IN = 2;
    private static final int LOG_OUT = 3;
    private static final int READ = 4;
    private static final int UPDATE = 5;
    private static final int DELETE = 6;
    private static final int EXIT = 7;
    private static final int[] SUPPORT_MENUS = {1, 2, 3, 4, 5, 5, 7};

    public MemberMenu(MemberApplication memberApplication, BufferedReader br) {
        this.memberApplication = memberApplication;
        this.br = br;

        this.memberSignUp = new MemberSignUp(memberApplication, br);
    }

    public void execute() throws IOException {
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("4. 회원정보");
        System.out.println("5. 정보수정");
        System.out.println("6. 회원탈퇴");
        System.out.println("7. 종료");
        int input = Integer.parseInt(br.readLine());

        switch (input) {
            case 1:
                this.memberSignUp.execute();
        }
    }
}
