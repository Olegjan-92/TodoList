package ru.javastudy.springMVC.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ru.javastudy.springMVC.model.Person;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oleg on 04.09.16.
 */
@org.springframework.stereotype.Service("userService")
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    HibernateTemplate template;

    public void saveUser(Person person) {
        template.saveOrUpdate(person);
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Person> getPersons() {
        return template.loadAll(Person.class);
    }

    public Person getPerson(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM  todolist where id =" + id);
        return (Person) query.uniqueResult();
    }

    public String delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, id);
        session.delete(person);
        return ("deleteTask");
    }

//    public Integer edit(Person person)  {
//        return (Integer) template.(person);
//    }
}
