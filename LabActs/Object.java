package LabActs;
public class Object{
    String name;
    String section;
    int year;

    Object(String name, String section, int year){
        this.name=name;
        this.section=section;
        this.year=year;
    }

    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Section: "+section);
        System.out.println("Year"+year);
    }
}