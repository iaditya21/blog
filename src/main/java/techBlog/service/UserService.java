package techBlog.service;

import org.springframework.stereotype.Service;
import techBlog.model.Post;
import techBlog.model.User;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserService {



    public boolean login(User user) {
        if(user.getUsername().equalsIgnoreCase("ishan")){
            return true;
        }
        return false;
    }
}
