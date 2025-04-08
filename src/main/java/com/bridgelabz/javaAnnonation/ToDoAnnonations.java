package com.bridgelabz.javaAnnonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class TaskClass{

    @Todo(task = "Buying Vegetables", assignedTo="Mother")
    public void firstTask(){
        System.out.println("Assigning first task");
    }

    @Todo(task = "Complete Classwordk", assignedTo = "Me", priority = "HIGH")
    public void secondTask(){
        System.out.println("Assigning second task");
    }

    @Todo(task = "Cook food", assignedTo = "Me", priority = "HIGH")
    public void thirdTask(){
        System.out.println("Assigning third task");
    }
}

public class ToDoAnnonations {
    public static void main(String[] args) throws  Exception{
        Class<TaskClass> clazz = TaskClass.class;

        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Todo.class)){
              Todo taskClass = method.getAnnotation(Todo.class);

              System.out.println(method.getName());
            //  System.out.println(method.invoke(taskClass));
                System.out.println(taskClass.task());
                System.out.println(taskClass.assignedTo());
                System.out.println(taskClass.priority());
            }
        }
    }
}
