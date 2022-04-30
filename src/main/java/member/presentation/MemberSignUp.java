package member.presentation;

import member.application.MemberApplication;
import member.application.MemberDto;
import member.infrastructure.MemberInMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class MemberSignUp {
    private MemberApplication memberApplication;
    private BufferedReader br;

    public MemberSignUp(MemberApplication memberApplication, BufferedReader br) {
        this.memberApplication = memberApplication;
        this.br = br;
    }

    public void execute() throws IOException {
        System.out.println("아이디를 입력해주세요: ");
        String id = br.readLine();
        System.out.println("비밀번호를 입력해주세요: ");
        String pw = br.readLine();
        System.out.println("이름을 입력해주세요: ");
        String name = br.readLine();
        System.out.println("이메일 입력해주세요: ");
        String email = br.readLine();

        MemberDto memberDto = new MemberDto(id, pw, name, email);
        boolean result = memberApplication.signUp(memberDto);
        if (result == true){
            System.out.println("회원가입에 성공했습니다.");
            return;
        }
        System.out.println("회원가입에 실패했습니다.");
    }
}
