package techBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techBlog.model.Post;
import techBlog.model.User;
import techBlog.repository.PostRepository;
import techBlog.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepo;
    public boolean login(User user) {
        if(user.getUsername().equalsIgnoreCase("ishan")){
            return true;
        }
        return false;
    }

    public void registerUser(User user){
       userRepo.registerUser(user);
    }
}
