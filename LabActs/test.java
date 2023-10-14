import java.util.*;

/*public class MusiicMain{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> discog = new ArrayList<>();
        int sYear = 0;
        String sName;
        String sCategory;
        char loop;

        do{
        while(true){
            System.out.print("Year song was released: ");
            if(sYear <= 2023 && sc.hasNextInt()){
                sYear = sc.nextInt();
                break;
            }else if(!sc.hasNextInt()){
                
            }
        }
        sc.nextLine();
        System.out.print("Song Name: ");
        sName = sc.nextLine();

        System.out.print("Song Category: ");
        sCategory = sc.nextLine();

        Song song = new Song(sYear, sName, sCategory);
        discog.add(song.ConcatData());

        System.out.print("Continue Loop?[y/n]: ");
        loop = sc.next().charAt(0);

        sYear = 0;
        sName = " ";
        sCategory = " ";

     }while(loop == 'y');
      
      System.out.println("Songs that have been added: ");
      for(int i = 0; i<discog.size(); i++){
         String getFromDiscog = discog.get(i);
         String[] splitDiscog = getFromDiscog.split("_", 3);
         for(int j = 0; j<3;j++){
            System.out.println(splitDiscog[j]);
         }
         System.out.println();
      }
      
      do{
         System.out.println("Choose a category: ");
         String findCateg = sc.next();
         System.out.println(findCateg);
         for(int i=0;i<discog.size();i++){
            String[] getCateg = discog.get(i).split("_", 3);
            System.out.println(getCateg[2]);
            if(findCateg == getCateg[2]){
                //Sysytem
               for(int j = 0; j<3;j++){
                  System.out.println(getCateg[j]);
               }
               break;
            }
         }
      }while(true);      
   }
}

/*class Guns{

    String name;
    int damage;
    int bullets;
    
    Guns(String name, int damage, int bullets){
        this.name = name;
        this.damage = damage;
        this.bullets = bullets;
    }

    void displayGun(){
        System.out.println("Gun: "+name+"\nDamage: "+damage+"\nAmmo Size: "+bullets);
    }

}

class test{

    public static void main(String[] args){
        //System.out.println("Hello Hello");
        Guns gun = new Guns("no name", 0, 0);
        Guns AK47 = new Guns("Kalashnikov", 40, 30);

        gun.displayGun();
        AK47.displayGun();
    }

}*/