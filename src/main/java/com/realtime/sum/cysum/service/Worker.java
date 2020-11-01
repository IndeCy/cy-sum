package com.realtime.sum.cysum.service;

import com.realtime.sum.cysum.dao.PersonDAO;
import com.realtime.sum.cysum.entity.Person;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.realtime.sum.cysum.service
 * @Author: chenyang
 * @Date: 2020/11/1
 * @Version: 1.0
 */
public class Worker implements Runnable {

    private PersonDAO personDAO;

    private Person person;

    private CountDownLatch countDownLatch;

    public Worker(PersonDAO personDAO, Person person, CountDownLatch countDownLatch) {
        this.personDAO = personDAO;
        this.person = person;
        this.countDownLatch = countDownLatch;
    }


    public Worker() {
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = 0;
        int count = 1;
        int sheld = 0;
        while (result == 0) {
            Example<Person> of = Example.of(person);
            Person one = personDAO.findOne(of).orElse(null);
            try {
                if(one == null){
                    personDAO.save(this.person);
                    result = 1;
                }else {
                    Integer old = one.getAge();
                    result = personDAO.updateCAS(old + 1, old, one.getId());
                    if (result == 1) {
                        System.out.println("thread: " + Thread.currentThread().getName() + " count: " + count + " result:" + result);
                    }
                    count++;
                }
            }catch (Exception e){
                System.out.println("unexpected exception, retry"+ e.getClass());
                if(sheld ++ > 5) break;
            }


        }

    }

}
