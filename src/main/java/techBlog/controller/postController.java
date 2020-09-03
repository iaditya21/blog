package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techBlog.model.Post;
import techBlog.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class postController {

    @Autowired
    private PostService post;

    @RequestMapping("posts")
    public String getPost(Model model){
        List<Post> posts=post.getAllPost();
       // posts.add(post.getOnePost());

        model.addAttribute("posts",posts);
        return "posts";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        post.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts/newPost")
    public String newPost(Post newPost) {

        return "createPost";
    }


}
