package com.GeeksterUserManagement.UserManagement.Controller;

import com.GeeksterUserManagement.UserManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.GeeksterUserManagement.UserManagement.Model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.util.List;
@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    public String addUser(@Valid @RequestBody User u){
        return userService.inputUser(u);
    }

    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User>u)
    {
        return userService.inputUsers(u);
    }

    @GetMapping("users")
    public List<User> getAllUsers()
    {
        return userService.getAllUser();
    }

    @GetMapping("user/{iD}")

    public User getUserById(@PathVariable Integer iD)
    {
        return userService.getUser(iD);
    }

    @PutMapping("user/{iD}/number/{num}")
    public String updateUserNumById(@PathVariable Integer iD,  @Size(min = 12,max = 12)
    @Pattern( regexp = "91[0-9]+") @PathVariable String num)
    {
        return userService.updateUserNumber(iD,num);
    }

    @PutMapping("user/{iD}/address/{updateUserEmail}")
    public String updateUserAddressById(@PathVariable Integer iD,
                                        @Email @PathVariable String updateUserEmail)
    {
        return userService.updateUserEmailAddress(iD,updateUserEmail);
    }

    @DeleteMapping("user/{iD}")
    public String deleteUserById(@PathVariable Integer iD)
    {
        return userService.deleteUser(iD);
    }






}
