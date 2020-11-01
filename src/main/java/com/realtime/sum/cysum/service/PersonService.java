package com.realtime.sum.cysum.service;

import com.realtime.sum.cysum.dao.PersonDAO;
import com.realtime.sum.cysum.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.realtime.sum.cysum.service
 * @Author: chenyang
 * @Date: 2020/11/1
 * @Version: 1.0
 */
@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    private CountDownLatch countDownLatch = new CountDownLatch(1);


    public String saveone(Person person){
        Person save = personDAO.save(person);
        return save.toString();
    }

    public void concurrentWrite(Person person){
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Worker(personDAO, person,countDownLatch));
            thread.start();
        }
        countDownLatch.countDown();
    }


}
