package techBlog.repository;

import org.springframework.stereotype.Repository;
import techBlog.model.Post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {
    @PersistenceUnit(name = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPost() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("Select p from Post p", Post.class);
        return query.getResultList();
    }

    public Post getLatestPost(){
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class,2);
    }

    public Post createPost(Post newPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans=em.getTransaction();
        trans.begin();
        em.persist(newPost);
        trans.commit();
        return newPost;
    }
}
