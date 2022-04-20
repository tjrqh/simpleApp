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
        if(map.containsKey(member.getId())){
            return false;
        }
        createId(member);
        createPw(member);
        createName(member);



        return true;

    }

    @Override
    public boolean update(Member member) {
        if(map.equals(member.getName()==null)){
            return false;
        }
        map.put(member.getName(), member);
        return true;
    }
    public boolean createId(Member member){
        if(member.getId().length()<5 && member.getId().length()>13){
            return false;
        }
        else{
            String pattern = "^[a-z[0-9]]{5,13}$";
            Matcher m;
            m = Pattern.compile(pattern).matcher(member.getPassword());
            if(m.find()){
                return true;
            }
        }
        return false;
    }

    public boolean createPw(Member member){
        if(member.getPassword().length() < 8 && member.getPassword().length() >20){
            return false;
        }
        else{
            String pattern1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
            Matcher m;
            m = Pattern.compile(pattern1).matcher(member.getPassword());
            if(m.find()){
                return true;
            }
        }
        return false;
    }

    public  boolean createName(Member member) {
        String pattern = "^[가-힣]{3,10}$";
        Matcher m;
        m = Pattern.compile(pattern).matcher(member.getName());
        if(m.find()){
            return true;
        }
        return false;
    }

}
