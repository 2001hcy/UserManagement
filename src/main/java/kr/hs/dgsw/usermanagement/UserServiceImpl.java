package kr.hs.dgsw.usermanagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    List<User> userList;
    public UserServiceImpl(){
        this.userList = new ArrayList<>();
        this.userList.add(new User("user1","user1","user111@dgsw"));
        this.userList.add(new User("user2","user2","user222@dgsw"));
        this.userList.add(new User("user3","user3","user333@dgsw"));
    }
    @Override
    public List<User> list() {
        return this.userList;
    }
    @Override
    public User view(String id) {
        User found = this.userList.stream()
                .filter(user -> user.getID().equals(id))
                .findAny()
                .orElse(null);
        return found;
    }
    @Override
    public boolean add(User user) {
        User duplicate = this.userList.stream()
                .filter(user1 -> user1.getID().equals(user.getID()))
                .findAny()
                .orElse(null);
        if (user.getID() == null || duplicate != null){
            System.out.println("False");
            return false;
        }
        return this.userList.add(user);
    }
    @Override
    public User update(User user) {
        User found = this.view(user.getID());
        if (found != null){
            found.setEmail(user.getEmail());
            found.setName(user.getName());
        }
        return found;
    }
    @Override
    public boolean delete(String id) {
        User found = this.view(id);
        return this.userList.remove(found);
    }
}