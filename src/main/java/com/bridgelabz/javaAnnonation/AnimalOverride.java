package com.bridgelabz.javaAnnonation;

class Animal{

    public void makeSound(){
        System.out.println("Make noise");
    }
}

class Dog extends Animal{

    @Override
    public void makeSound(){
        System.out.println("Bark");
    }
}
public class AnimalOverride {
    public static void main(String[] args){
        Animal dog = new Dog();
        dog.makeSound();

    }
}
