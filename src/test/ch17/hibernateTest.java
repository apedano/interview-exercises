package ch17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.cglib.core.CollectionUtils;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 24/08/2017.
 */

public class hibernateTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUpSession() {
        //one session factory fo all classes
        Configuration configuration = new Configuration();
        configuration.configure("ch17/hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        System.out.println("Hibernate one to one (XML mapping)");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = new User();
            user.setName("apedano");
            user.setEmail("pedano.alessandro@gmail.com");
            user.setDate(new Date());
            user.setTime(new Date());
            //persists object to db
            session.saveOrUpdate(user);
            List<String> roleNames = Arrays.asList("admin", "user", "visitor", "none");
            roleNames.forEach(roleName -> {
                Role role = new Role(roleName);
                session.saveOrUpdate(role);
            });

            //one to many association
            user = (User) session.createCriteria(User.class, "from User where id=1").list().get(0);
            Set<Post> postSet = new HashSet<Post>();
            postSet.add(createPost(user, "primo post", LocalDateTime.of(2012, Month.DECEMBER, 31, 23, 59).plusMinutes(1)));
            postSet.add(createPost(user, "secondo post", LocalDateTime.of(2012, Month.DECEMBER, 31, 23, 59).plusMinutes(2)));
            postSet.add(createPost(user, "terzo post", LocalDateTime.of(2012, Month.DECEMBER, 31, 23, 59).plusMinutes(3)));
            user.setPosts(postSet);
            //persists object to db
            session.saveOrUpdate(user);

            //manhy-to-many association

            List<Role> roles = (List<Role>) session.createCriteria(Role.class, "from Role where name = ").list();
            Set<Role> roleSet = new HashSet<>(CollectionUtils.filter(roles, r -> ((Role) r).getName().equals("user") || ((Role) r).getName().equals("admin")));
            //we can make this because user is the owner of the association and hibernate will do the dirty checking to find modifications and save it
            //If the role entity had been the owner the construction would be the following role.getUsers().add(user)
            user.setRoles(roleSet);
            //persists object to db
            session.saveOrUpdate(user);
            //commit transaction
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    @Test
    public void oneToManyTest(){
        Session session = sessionFactory.openSession();
        try {
            //test persistence
            List<Post> userPost = (List<Post>) session.createCriteria(Post.class, "from Post where creator_id=1 order by timestamp asc").list();
            //the hashset do not maaintain insert order
            assertEquals(userPost.size(), 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void manyToManyTest(){
        Session session = sessionFactory.openSession();
        try {
            //test persistence
            User user = (User) session.createCriteria(User.class, "from User where id=1").list().get(0);
            Role adminRole = (Role) session.createCriteria(Role.class, "from Role where name like 'admin'").list().get(0);
            assertTrue(adminRole.getUsers().contains(user));
            Role userRole = (Role) session.createCriteria(Role.class, "from Role where name like 'user'").list().get(0);
            assertTrue(userRole.getUsers().contains(user));
            //the hashset do not maaintain insert order
            assertEquals(user.getRoles().size(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hqlTest(){
        Session session = sessionFactory.openSession();
        List<Post> adminPosts = (List<Post>) session.createCriteria(Post.class, "from Post p inner join p.users users join users.roles where roles.name = 'admin' ").list();
        assertEquals(adminPosts.size(), 3);
    }

    @Test
    public void test(){
        Session session = sessionFactory.openSession();
        List<User> users = session.createCriteria(User.class).list();
        User user = users.get(0);
        assertEquals(users.size(), 1);
    }

    private static Post createPost(User creator, String text, LocalDateTime creationDate){
        Post post = new Post();
        post.setCreator(creator);
        post.setText(text);
        post.setCreationDateTime(Date.from(creationDate.atZone(ZoneId.systemDefault()).toInstant()));
        return post;
    }


}
