public class Mainnn {
    public static void main(String[] args){

        //creating instances of children
        Child c= new Child();
        Child0 cc = new Child0();

        //using the inhereted functions from their parent
        c.run(); //this was overriden 
        cc.run();

        System.out.println("c gender "+ c.getGender());
        System.out.println("cc gender "+ cc.getGender());

        //testing getter setter of encapsulated var on children
        c.setGender("Lalaki");
        cc.setGender("Babae");

        System.out.println("c gender "+ c.getGender());
        System.out.println("cc gender "+ cc.getGender());

        //displaying each of their names and inherited family name
        c.name();
        cc.name();
    }
}