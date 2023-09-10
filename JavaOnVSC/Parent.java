class Parent{

    //family name of parent to be inherited by children
    String familyName = "Alejandrino";

    //parent functions that can be inherited by children
    void run(){
        System.out.println("nidagan"); //was overriden by Droi
    }

    void walk(){
        System.out.println("nilakaw");
    }

}