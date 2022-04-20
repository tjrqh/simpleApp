package member.infrastructure;

import member.domain.entity.Member;

public class MemberInMemorySession {
    private Member member;


    public boolean set(Member member){
        return false;
    }

    public Member get(Member member){
        return member;
    }
}
