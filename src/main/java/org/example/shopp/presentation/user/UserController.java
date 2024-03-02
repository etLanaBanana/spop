package org.example.shopp.presentation.user;

import lombok.AllArgsConstructor;
import org.example.shopp.application.cart.CartService;
import org.example.shopp.application.user.UserService;


import org.example.shopp.domain.entity.User;
import org.example.shopp.presentation.user.dto.command.CreateUserCommand;
import org.example.shopp.presentation.user.dto.command.CreateUserCommandToCart;
import org.example.shopp.presentation.user.dto.command.UpdateUserCommand;
import org.example.shopp.presentation.user.dto.query.UserQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private ModelMapper modelMapper;
    private CartService cartService;

    @PostMapping("/addNewUser")
    private UserQuery addNewUser(@RequestBody CreateUserCommand createUserCommand) {
        User user = modelMapper.map(createUserCommand, User.class);
        user = userService.addNewUser(user);
        return modelMapper.map(user, UserQuery.class);
    }
    @GetMapping("/getUsers")
    private List<UserQuery> getUsers() {
        List<User> users = userService.getUsers();
        List<UserQuery> userQueries = new ArrayList<>();
        for (User user : users) {
            userQueries.add(modelMapper.map(user, UserQuery.class));
        }
        return userQueries;
    }
    @GetMapping("/getUserById/{id}")
    private UserQuery getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return modelMapper.map(user, UserQuery.class);
    }
    @GetMapping("/getUserByFirstName/{firstName}")
    private UserQuery getUserByFirstName(@PathVariable String firstName) {
        User user = userService.getUserByFirstName(firstName);
        return modelMapper.map(user, UserQuery.class);
    }

    @PostMapping("/add-to-cart")
    public void addToCart(@RequestBody CreateUserCommandToCart createUserCommand) {
        userService.addProductToCart(createUserCommand);
    }

}
