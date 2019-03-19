package kr.hs.dgsw.usermanagement;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(String name);
    User update(User user);
    boolean add(User user);
    boolean delete(String name);
}