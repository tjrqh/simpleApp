package member.domain.session;

import member.domain.entity.Member;

public interface MemberSession {

    public Member get();
    public boolean set(Member member);

}
