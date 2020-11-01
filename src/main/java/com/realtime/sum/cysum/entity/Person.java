package com.realtime.sum.cysum.entity;

import javax.persistence.*;

/**
 * @Package: com.realtime.sum.cysum.entity
 * @Author: chenyang
 * @Date: 2020/11/1
 * @Version: 1.0
 */
@Entity
@Table(name = "table_person")
public class Person {

    @Column(name = "id_")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name_")
    String name;

    @Column(name = "age_")
    Integer age;
    @Column(name = "chinese_")
    Integer chinese;
    @Column(name = "english_")
    Integer english;
    @Column(name = "math_")
    Integer math;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", chinese=" + chinese +
                ", english=" + english +
                ", math=" + math +
                '}';
    }
}
