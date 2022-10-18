package data;

import java.util.Date;

public class User {
    public String id;
    public String username;
    public String email;
    public String password;

    public User(String id, String username, String email, String password, Date createtime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createtime = createtime;
    }
    public Date createtime;
}
