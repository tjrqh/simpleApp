package member.stepone;

import member.presentation.MemberMenu;
import member.application.MemberApplication;
import member.domain.repository.MemberRepository;
import member.infrastructure.MemberInMemoryRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


@SpringBootApplication
public class StepOneApplication {

    public static void main(String args[]) throws IOException {
        MemberRepository memberRepository = new MemberInMemoryRepository();
        MemberApplication memberApplication = new MemberApplication(memberRepository);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MemberMenu memberMenu = new MemberMenu(memberApplication, br);
        while (true) {
            memberMenu.execute();
        }
    }
}



