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

    public static void main(String[]args){
        Object obj = new Object("DADA", "F", 2);
        obj.display();
    }
}