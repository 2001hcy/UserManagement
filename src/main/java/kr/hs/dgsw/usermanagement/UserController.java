package kr.hs.dgsw.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return userService.list();
    } //전체 조회

    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) {
        return this.userService.view(id);
    } // 조회

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.add(user);
    } // 가입

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.update(user);
    } // 수정

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id){
        return this.userService.delete(id);
    } // 삭제
}

//CRUD Create Read   Update Delete
//SQL  insert select update delete
//HTTP POST   GET    PUT    DELETE
