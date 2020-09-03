package techBlog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import techBlog.model.Post;
import techBlog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

//    @PersistenceUnit(name = "techblog")
//    private EntityManagerFactory emf;

    @Autowired
    private PostRepository postRepo;

    public List<Post> getAllPost()  {
        return postRepo.getAllPost();

    }

    public Post getOnePost() {

        return postRepo.getLatestPost();
    }

    public Post createPost(Post newPost){
        newPost.setDate(new Date());
        return postRepo.createPost(newPost);
    }
}
