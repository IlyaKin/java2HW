package ru.geekbrains.java2.online.lessonC;

public class Person {
    protected  String Surname;
    protected  String email;
    protected  String phone;
    Person( String Surname,String phone,String email){
        this.Surname = Surname;
        this.phone = phone;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }


}


