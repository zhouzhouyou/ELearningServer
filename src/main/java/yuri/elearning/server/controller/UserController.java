package yuri.elearning.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuri.elearning.server.model.User;
import yuri.elearning.server.service.UserService;
import yuri.elearning.server.util.RF;

import java.util.List;

@Api(tags = "用户API")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("获得所有用户")
    @PostMapping(value = "/all")
    @ResponseBody
    public ResponseEntity<List<User>> selectAll() {
        return userService.selectAll();
    }

    @PostMapping("/signIn")
    @ResponseBody
    public ResponseEntity<Integer> signIn(@RequestParam("name") String name,
                                          @RequestParam("password") String password) {
        return userService.signIn(name, password);
    }

    @PostMapping("/signUp")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestParam("name") String name,
                                         @RequestParam("password") String password) {
        return userService.signUp(name, password);
    }

    @PostMapping("/recharge")
    @ResponseBody
    public ResponseEntity<String> recharge(@RequestParam("id") Integer id,
                                           @RequestParam("cost") Double cost) {
        return userService.recharge(id, cost);
    }
}
