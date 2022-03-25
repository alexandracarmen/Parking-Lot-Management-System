package com.company;

public class Person {

    private String name ;

    private PersonType personType;


    public String getName(){
        return this.name;
    }

    public PersonType getPersonType(){
        return this.personType;
    }

    public Person(PersonType personType) {
        this.personType = personType;
    }
}
