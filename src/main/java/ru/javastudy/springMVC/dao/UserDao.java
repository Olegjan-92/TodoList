package ru.javastudy.springMVC.dao;

import ru.javastudy.springMVC.model.Person;

import java.util.List;

/**
 * Created by oleg on 04.09.16.
 */
public interface UserDao {
    void saveUser(Person person);
    List<Person> getPersons();
    Person getPerson(Integer id);
    String delete(Integer id);
    //Integer edit(Person person);

}
