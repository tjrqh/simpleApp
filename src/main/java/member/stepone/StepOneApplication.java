package member.stepone;
import member.application.MemberDto;
import member.Presentation.MemberCLIInterface;
import member.application.MemberApplication;
import member.domain.repository.MemberRepository;
import member.infrastructure.MemberInMemoryRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class StepOneApplication {

    public static void main(String args[]) throws IOException{
        MemberRepository memberRepository = new MemberInMemoryRepository();
        MemberApplication memberApplication = new MemberApplication(memberRepository);
        MemberCLIInterface memberCLIInterface = new MemberCLIInterface(memberApplication);



        memberCLIInterface.memberMenu();
        memberCLIInterface.choice();
            }

        }



