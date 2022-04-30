package member.infrastructure;

import member.domain.entity.Member;
import member.domain.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberInMemoryRepository implements MemberRepository {
    private Map<String, Member> map = new HashMap<>();

    @Override
    public Member getById(String id) {
        return this.map.get(id);
    }

    @Override
    public boolean create(Member member) {
        if (map.get(member.getId()) != null) {
            return false;
        }
        map.put(member.getId(), member);
        return true;
    }

    @Override
    public boolean update(Member member) {
        if (map.equals(member.getName() == null)) {
            return false;
        }
        map.put(member.getName(), member);
        return true;
    }
}
