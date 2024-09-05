import java.util.ArrayList;

public class Database {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<String> username = new ArrayList<>();

    public void AddUser(User s){
     users.add(s);
     username.add(s.getName());
    }

    public int login(String phonenumber, String email){
        int n = -1;
        for(User u : users){
            if (u.getPhoneNumber().matches(phonenumber) && u.getEmail().matches(email)){
                n = users.indexOf(u);
                break;
            }
        }
        return n;
    }

    public User getUser (int n){
       return  users.get(n);

    }
}
