package techBlog.repository;

import org.springframework.stereotype.Repository;
import techBlog.model.Post;
import techBlog.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceUnit(name = "techblog")
    private EntityManagerFactory emf;


    public User registerUser(User user){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans=em.getTransaction();
        trans.begin();
        em.persist(user);
        trans.commit();
        return user;
    }
}
