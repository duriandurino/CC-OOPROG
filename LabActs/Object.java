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
        System.out.println(name);
        System.out.println(section);
        System.out.println(year);
    }
}