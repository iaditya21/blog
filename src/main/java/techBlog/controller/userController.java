package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techBlog.model.Post;
import techBlog.model.User;
import techBlog.service.PostService;

import java.util.ArrayList;

@Controller
public class userController {
    @Autowired
    private PostService post;

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
        return "redirect:/posts";
    }

    @RequestMapping(value = "users/logout",method = RequestMethod.POST)
    public String logout(Model model){
        ArrayList<Post> posts=post.getAllPost();

        model.addAttribute("posts",posts);
        return "index";
    }
}
