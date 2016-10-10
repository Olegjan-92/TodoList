package ru.javastudy.springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javastudy.springMVC.dao.UserDao;
import ru.javastudy.springMVC.model.Person;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by oleg on 04.09.16.
 */
@Service
public class UserActionViewServiceImpl implements UserActionService{
    @Autowired
    UserDao userDao;

    @Transactional
    public void saveUser(Person person) {
        userDao.saveUser(person);
    }

    public List<Person> getPersons() {
        return userDao.getPersons();
    }

    public Person getPerson(Integer id) {
        return userDao.getPerson(id);
    }

    public String delete(Integer id) {
        return userDao.delete(id);
    }


}
