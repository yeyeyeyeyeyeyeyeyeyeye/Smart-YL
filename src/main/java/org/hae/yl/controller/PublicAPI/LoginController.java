package org.hae.yl.controller.PublicAPI;

import org.hae.yl.Util.JwtUtil;
import org.hae.yl.entity.AuthResponse;
import org.hae.yl.entity.User;
import org.hae.yl.facade.UserFacade;
import org.hae.yl.model.LoginRequest;
import org.hae.yl.model.Userparameter;
import org.hae.yl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/publicapi/login")
public class LoginController {

    @Resource
    UserFacade facade;

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest) {
        System.out.println("请求到达登录授权接口~~~~");
        return facade.Loginauth(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Userparameter registerRequest) {
        System.out.println("请求到达注册接口~~~~");
        return facade.register(registerRequest);
    }
}
