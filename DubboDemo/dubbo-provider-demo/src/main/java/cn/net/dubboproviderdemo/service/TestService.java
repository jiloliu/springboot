package cn.net.dubboproviderdemo.service;

import cn.net.dubboproviderdemo.dao.PersonDao;
import cn.net.dubboproviderdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    PersonDao personDao;

    public Person getPerson(int id){

        return personDao.findPersonById(id);
    }

    public void addPerson(Person person){

        personDao.addPerson(person);
    }

    public void updatePerson(Person person){
        personDao.updatePersonById(person);
    }

    public void deletePerson(int id){
        personDao.deletePersonById(id);
    }
}
