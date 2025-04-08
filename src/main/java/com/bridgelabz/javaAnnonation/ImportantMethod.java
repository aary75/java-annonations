package com.bridgelabz.javaAnnonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImpMethod{
    int parameter();
    String importance() default "HIGH";
}

class imMethod{

    @ImpMethod(parameter = 1)
    public void firstMethod(){
        System.out.println("Method is important");
    }

   @ImpMethod(parameter = 2)
    public void secondMethod(){
        System.out.println("Method is not much important");
   }
}

public class ImportantMethod {
    public static void main(String[] args) throws Exception{
        imMethod imp = new imMethod();

        Method[] methods = imp.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(ImpMethod.class)){
                ImpMethod annonation = method.getAnnotation(ImpMethod.class);
                System.out.println(annonation.parameter());
                System.out.println(annonation.importance());
            }
        }
    }
}
