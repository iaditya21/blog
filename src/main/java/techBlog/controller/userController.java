package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techBlog.model.Post;
import techBlog.model.User;
import techBlog.service.PostService;
import techBlog.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class userController {
    @Autowired
    private PostService post;
    @Autowired
    private UserService usr;

    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registartion(){

        return "users/registration";
    }

    @RequestMapping(value = "users/login",method = RequestMethod.POST)
    public String userLogin(User user){
        if(usr.login(user)) {
            return "redirect:/posts";
        }
        else{
            return "users/login";
        }
    }

    @RequestMapping(value = "users/logout",method = RequestMethod.POST)
    public String logout(Model model){
        List<Post> posts=post.getAllPost();

        model.addAttribute("posts",posts);
        return "index";
    }

    @RequestMapping(value = "users/registration",method = RequestMethod.POST)
    public String registerUser(User user){
        return "users/login";
    }
}
