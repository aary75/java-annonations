package com.bridgelabz.javaAnnonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface maxLength{
    int length();
}

class strlength{

    @maxLength(length = 6)
    public void display(){
        System.out.print("String length");
    }
}

public class MaximumLength {
    public static void main(String[] args) throws  Exception{
        try{
            String str = "Aarya";
            strlength len = new strlength();

            Method method = len.getClass().getDeclaredMethod("display");
            if(method.isAnnotationPresent(maxLength.class)){
                maxLength annonation = method.getAnnotation(maxLength.class);
                if(str.length() < annonation.length()) throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Length of given string is less than our requirement");
        }
    }
}
