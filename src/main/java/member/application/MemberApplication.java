package member.application;

import member.domain.entity.Member;
import member.domain.repository.MemberRepository;
import member.domain.session.MemberSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MemberApplication {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Member> memberList;
    private MemberRepository memberRepository;
    private MemberSession memberSession;


    public MemberApplication(MemberSession memberSession) {
        this.memberSession = memberSession;
    }

    public MemberApplication(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public boolean signUp(MemberDto memberDto){
        if(memberDto.getId() != null) { // getId가 있으면 false 로 return
            return false;
        }

        return this.memberRepository.create(new Member(memberDto.getId(), memberDto.getPassword(),memberDto.getName(),memberDto.getEmail()));


    }
    public boolean signIn() {

        boolean isLogin = false;
        int loginCount = 0;

        while (true) {
            if (loginCount >= 5) {
                System.out.println("로그인 횟수를 초과했습니다.");
                System.out.println("관련 직원 혹은 관리자에게 문의해주세요.");
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
            String inputID = "";
            String inputPW = "";
            System.out.print("ID       : ");
            inputID =br.toString();
            System.out.print("PASSWORD : ");
            inputPW = br.toString();
            isLogin = signIn(inputID, inputPW);
            if (isLogin)
                break;

            if (!isLogin) {
                loginCount++;
                if (loginCount < 5) {
                    System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
                    System.out.println((3 - loginCount) + "회를 더 실패하면 프로그램이 종료됩니다.");
                }
            }
        }
        return isLogin;
    }

    public boolean logOut(String id){
        if(id == null){
            return false;
        }
        return true;
    }

    public boolean read(String id){
        if(memberList.isEmpty()){
            System.out.println("정보가 없습니다");
        }
        else{
            for(int i = 0; i < memberList.size(); i++) {
                if(memberList.get(i).getId().equals(id)==false){
                    continue;
                }
            }
        }
        return read(id);
    }

    public boolean update(Member name){
        for(int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).equals(name) == false) {
                continue;
            }
        }
        return this.memberRepository.update(name);
    }

    public boolean exit(String id){

        return false;
    }
}
