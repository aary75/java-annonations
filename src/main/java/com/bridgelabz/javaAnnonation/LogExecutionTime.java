package com.bridgelabz.javaAnnonation;

import javax.sound.midi.SysexMessage;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTiming{
    String displayMessage() default "Execution time is: ";
}

class task {
    @LogExecutionTiming(displayMessage = "Time: ")
    public void slowertask(){
        System.out.println("Printing the slower Task");
    }

    @LogExecutionTiming(displayMessage = "Time: ")
    public void longerTask() throws Exception{
//Thread.sleep(3000);
        System.out.println("Printing the longer task");
    }
}
public class LogExecutionTime {
    public static void main(String[] args) throws Exception{
        Class<task> clazz = task.class;
        task taskMessage = new task();

        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(LogExecutionTiming.class));
              LogExecutionTiming taskClass = method.getAnnotation(LogExecutionTiming.class);

              long startTime = System.currentTimeMillis();
              method.invoke(taskMessage);
              long endTime = System.currentTimeMillis();
              System.out.println(taskClass.displayMessage() + (endTime - startTime));
        }
    }
}
