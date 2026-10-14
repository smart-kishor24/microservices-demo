package com.example.spring_core_di;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);L

        Student Student = context.getBean(Student.class);

        Student.displayDetails();

        context.close();
    }
}
