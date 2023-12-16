public class Data{
    int wins;
    String name;

    Data(String name){
        this.name=name;
    }

    Data(String name, int wins){
        this.name=name;
        this.wins=wins;
    }

    String dataString(){
        //System.out.println(name+":"+wins);
        return name+":"+wins;
    }
    
    int getWins(){
        return this.wins;
    }
}
