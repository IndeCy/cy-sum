package com.realtime.sum.cysum.dao;

import com.realtime.sum.cysum.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package: com.realtime.sum.cysum.dao
 * @Author: chenyang
 * @Date: 2020/11/1
 * @Version: 1.0
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface PersonDAO extends JpaRepository<Person, Integer> {

    @Query(value = "update Person set age = ?1 where age = ?2 and id = ?3")
    @Modifying
    int updateCAS(Integer now, Integer old, Integer id);
}
