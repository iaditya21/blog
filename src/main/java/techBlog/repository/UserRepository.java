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

    public User checkUser(String username,String password){
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<User> query = em.createQuery("Select u from User u where u.username=:username and u.password=:password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
