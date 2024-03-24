package com.test.test.controller;

import com.test.test.model.Response;
import com.test.test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("db2any/bykey")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getjson/{key}")
    public ResponseEntity<Response> getPartnerTypes(@PathVariable Integer key) {
        Response response = new Response();
        response.setRequest(key);

        try {
            Map<String, String> userData = userService.getUserByKey(key);
            response.setData(userData);
            response.setResponse("ok");
        } catch (Exception e) {
            response.setResponse(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }
}
