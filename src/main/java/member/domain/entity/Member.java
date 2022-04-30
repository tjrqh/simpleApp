package member.domain.entity;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member {
    private String id;
    private String password;
    private String name;
    private String email;

    private Member(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public static Member createMember(String id, String password, String name, String email) {
        // TODO: 나중에는 Exception을 throw하고 handling할 수 있는 구조로 변경
        if (!validateId(id)) {
            return null;
        }
        if (!validatePassword(password)) {
            return null;
        }
        if (!validateName(name)) {
            return null;
        }

        return new Member(id,password,name,email);
    }

    public static boolean validateId(String id) {
        if (id.length() < 5 && id.length() > 13) {
            return false;
        } else {
            String pattern = "^[a-z[0-9]]{5,13}$";
            Matcher m;
            m = Pattern.compile(pattern).matcher(id);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }

    private static boolean validatePassword(String password) {
        if (password.length() < 8 && password.length() > 20) {
            return false;
        } else {
            String pattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
            Matcher m;
            m = Pattern.compile(pattern).matcher(password);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateName(String name) {
        String pattern = "^[가-힣]{3,10}$";
        Matcher m;
        m = Pattern.compile(pattern).matcher(name);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
