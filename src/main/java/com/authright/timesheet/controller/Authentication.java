package com.authright.timesheet.controller;

import com.authright.timesheet.model.User;
import com.authright.timesheet.service.UserService;
import com.authright.timesheet.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
@CrossOrigin
@RestController
public class Authentication {
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String errorMsg = "The name or password is wrong.";
    private String tokenKeyWord = "Authorization";
    private String tokenType = "Bearer";

    @PostMapping("/auth")
    public ResponseEntity authenticate(@RequestBody User user){

        String token = "";

        try {
            logger.info(user.toString());
            logger.info(user.getUserName()+"  "+ user.getPassword());
            User u = userService.findUserByCredentials(user.getUserName(), user.getPassword());

            logger.info(u.toString());
            if (u == null) return ResponseEntity.status(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION).body(errorMsg);
            logger.info(u.toString());
            token = JwtUtil.generateToken(u);
            logger.info(token);
        }
        catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            if (msg == null) msg = "BAD REQUEST!";
            logger.error(msg);
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body(msg);
        }
//        return ResponseEntity.status(HttpServletResponse.SC_OK).body(tokenKeyWord + ":" + tokenType + " " + token);
        HashMap<String, String> tokenJson = new HashMap<>();
        tokenJson.put(tokenKeyWord,token);
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(tokenJson);
        //return ResponseEntity.status(HttpServletResponse.SC_OK).body("Login successfully!!!");
    }

    @PostMapping("/auth/registration")
    public User save(@RequestBody User user){
        user.setAvatarUrl("");
        user.setCreateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        user.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        return userService.save(user);
    }
}
