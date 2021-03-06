package com.sk.user;

import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
private static List<User> users = new ArrayList<>();
private static int userCount=3;
static {
    users.add(new User(1,"Adam", LocalDateTime.now()));
    users.add(new User(2,"Eve",LocalDateTime.now()));
    users.add(new User(3,"Jack",LocalDateTime.now()));
}

public List<User> findAll(){
    return users;
}
public User save(User user){
    if(user.getId() == null){
        user.setId(++userCount);
    }
   users.add(user);
    return user;
}
public User findOne(int id){
    for(User user:users){
       if(user.getId() == id){
           return user;
       }
    }
    return null;
}

}
