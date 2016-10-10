package ru.javastudy.springMVC.service;

import ru.javastudy.springMVC.model.Person;

import java.util.List;

/**
 * Created by oleg on 04.09.16.
 */
public interface UserActionService {
    void saveUser(Person person);
    List<Person> getPersons();
    Person getPerson(Integer id);
    String delete(Integer id);
}
