packagejaymin com.jaymin.TaskDemo.DAO;

import com.jaymin.TaskDemo.DTO.Master;
import com.jaymin.TaskDemo.Entity.Owner;
import com.jaymin.TaskDemo.Entity.OwnerRepositry;
import com.jaymin.TaskDemo.Entity.UserRepositry;
import com.jaymin.TaskDemo.Entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    private EntityManager entityManager;
    private final UserRepositry userRepositry;
    private final OwnerRepositry ownerRepositry;

    @Autowired
    public UserDAO(EntityManager theentityManager,UserRepositry theuserRepositry,OwnerRepositry theownerRepositry){
        entityManager = theentityManager;
        userRepositry = theuserRepositry;
        ownerRepositry = theownerRepositry;
    }
    public String SaveAllUsers(Master response){
        List<Owner> abc = new ArrayList<>();
        List<Users> xyz = new ArrayList<>();
        for(int i=0;i<response.getData().size();i++) {
            abc.add(Owner.builder().ownerId(response.getData().get(i).getOwner().getId()).firstName(response.getData().get(i).getOwner().getFirstName()).lastName(response.getData().get(i).getOwner().getLastName()).owner_img(response.getData().get(i).getOwner().getPicture()).build());
            ownerRepositry.save(abc.get(i));
            xyz.add(Users.builder().id(response.getData().get(i).getId()).userMessage(response.getData().get(i).getMessage()).ownerId(abc.get(i)).postId(response.getData().get(i).getPost()).publishDate(response.getData().get(i).getPubDate()).build());
            userRepositry.save(xyz.get(i));
        }
        return "Success";
    }
    public List<Owner> getAllUser(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Owner",Owner.class);
        List<Owner> owner = theQuery.getResultList();
        return owner;
    }
    public List<Users> getAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Users",Users.class);
        List<Users> owner = theQuery.getResultList();
        return owner;
    }

    public String getFirstName(String id){
        Session curretSession = entityManager.unwrap(Session.class);
        Owner owner = curretSession.get(Owner.class,id);
        return owner.getFirstName();
    }

    public String getLastName(String id){
        Session curretSession = entityManager.unwrap(Session.class);
        Owner owner = curretSession.get(Owner.class,id);
        return owner.getLastName();
    }

    public void updateLastName(String lastName){
        Session curretSession = entityManager.unwrap(Session.class);
        String hql = "UPDATE OWNER SET owner_last_name=:lastName";
        Query q =  curretSession.createQuery(hql);
        curretSession.setProperty("lastName",lastName);
        q.executeUpdate();
    }
    public void updateFirstName(String FirstName){
        Session curretSession = entityManager.unwrap(Session.class);
        String hql = "UPDATE OWNER SET owner_first_name=:firstName";
        Query q =  curretSession.createQuery(hql);
        curretSession.setProperty("firstName",FirstName);
        q.executeUpdate();
    }

}
