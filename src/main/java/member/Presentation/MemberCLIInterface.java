package member.Presentation;

import member.application.MemberApplication;
import member.application.MemberDto;
import member.domain.entity.Member;

public class MemberCLIInterface {
    private MemberApplication memberApplication;

    public MemberCLIInterface(MemberApplication memberApplication) {
        this.memberApplication = memberApplication;
    }

    public boolean signUp(String id, String password, String name, String email){
        return this.memberApplication.signUp(new MemberDto(id, password, name, email));
    }

    public boolean signIn(String id, String password){
        return this.memberApplication.signIn(id,password);
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
