class Child0 extends Parent{

    //private var of this child
    private String gender = "F";

    //to set and get encapsulated var of this child
    String getGender(){
        return this.gender;
    }
    void setGender(String gender){
        this.gender = gender;
    }

    //display name of child and last name inherited from parent
    void name(){
        System.out.println("Budrenks "+familyName);
    }

}
