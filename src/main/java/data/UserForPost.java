package data;

public class UserForPost {
    public  String username;
    public String email;
    public String password;


    public UserForPost(String username, String email, String password){
        this.username = username;
                this.email = email;
                        this.password= password;

    }
    public String toJsinStrin(){
        return "{\"username\": \""+username+"\",\n" +
                "\"email\": \""+email+"\",\n" +
                "\"password\": \""+password+"\",\n" +
                "}";
    }

}
