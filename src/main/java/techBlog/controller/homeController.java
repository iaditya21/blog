package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import techBlog.model.Post;
import techBlog.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class homeController {
    @Autowired
    private PostService post;

    @RequestMapping("/")
    public String getAllPost(Model model){

        List<Post> posts=post.getAllPost();

        model.addAttribute("posts",posts);
        return "index";
    }
}
