package member.domain.repository;

import member.domain.entity.Member;

public interface MemberRepository {
    Member getById(String id);

    boolean create(Member member);
    boolean update(Member member);

}


