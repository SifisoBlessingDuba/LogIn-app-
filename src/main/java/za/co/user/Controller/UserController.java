package za.co.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.user.Domain.User;
import za.co.user.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/home")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @GetMapping("/findById/{email}")
    public User findbyId(@PathVariable String email) {
        return userService.getById(email);

    }
    @DeleteMapping("/delete/{email}")
    public void delete(@PathVariable String email) {
        userService.deleteById(email);
    }
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }


}
