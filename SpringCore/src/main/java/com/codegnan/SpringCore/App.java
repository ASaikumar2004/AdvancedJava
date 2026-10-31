package com.codegnan.SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
       ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
       
//       HelloSpring hs=context.getBean("hello",HelloSpring.class);
//       hs.display();
       
       Student std=context.getBean("student",Student.class);
       std.writeExam();
    }
}
