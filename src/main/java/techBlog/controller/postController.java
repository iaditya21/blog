package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import techBlog.model.Post;
import techBlog.service.PostService;

import java.util.ArrayList;

@Controller
public class postController {

    @Autowired
    private PostService post;

    @RequestMapping("posts")
    public String getPost(Model model){
        ArrayList<Post> posts=post.getOnePost();
        model.addAttribute("posts",posts);
        return "posts";
    }
}
