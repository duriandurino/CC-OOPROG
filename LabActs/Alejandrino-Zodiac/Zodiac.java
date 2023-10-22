import java.util.*;

class Zodiac{
   static String[] months = {"January", "February", "March", "April", "May", "June", 
                     "July", "August", "September", "October", "November", "December"};
                     
   static Scanner sc = new Scanner(System.in);
   
   static int month=0;
   static int day=0;
   static int year=0;
      
                     
   static void DisplayMonths(){
      System.out.println("Months:");
      for(int i=0;i<months.length;i++){
         System.out.println((i+1)+" = "+months[i]);
      }
   }
   
   static void EMssg(){
      System.out.println("Error! Please input again...");
   }
   
   static int TrapInt(String print){
      int pass=0;
      while(true){
         System.out.print(print);
         if(sc.hasNextInt()){
            pass = sc.nextInt();
            break;
         }
         sc.nextLine();
         EMssg();
      }
      return pass;
   }
   
   static boolean Checker(){
      boolean pass = false;
      boolean dayP = false;
      boolean monthP = false;
      boolean checkTO = false;
      int monthTO[] = {1,3,5,7,8,10,12};
      
      if(month<=12&&month>0){
         monthP = true;
      }
      
      for(int i : monthTO){
         if((month)==i){
            checkTO = true;
         }
      }
      
      if(month==2){
         if((year%4==0)&&(day<=29&&day>0)){
            dayP = true;
         }else if(day<=28&&day>0){
            dayP = true;
         }
      }
      
      if((checkTO==true)&&(day<=31&&day>0)){
         dayP = true;
      }
      
      if((checkTO==false&&month!=2)&&(day<=30&&day>0)){
         dayP = true;
      }
      
      if((year<=2024)&&dayP==true&&monthP==true){
         pass = true;
      }
      
      return pass;
   }
   
   static void UserInput(){
      while(true){
         month = TrapInt("Input Birth Month[1-12]: ");
         System.out.println();
         day = TrapInt("Input Birth Day: ");
         System.out.println();
         year = TrapInt("Input Birth Year[Max is 2024]: ");
         System.out.println();
         
         if(Checker()==true){
            break;
         }
         EMssg();
      }
   }
   
   static void GiveZodiac(){
       int r = year%12;
       String[] zodiacs = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox",
                            "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"
                            };
       int[] luckyNum = {10, 16, 29, 43, 3, 9, 20, 6, 36, 69, 50, 15};
       String[] luckyColor = {
           "Brown", "Purple", "Silver", "Pink", "Gray", "Yellow",
           "Orange", "Sky-Blue", "Gold", "Green", "Peach", "White"
        };
       String[] soulMate = {"Dragon", "Snake", "Sheep", "Tiger", "Rabbit", "Horse",
                            "Pig", "Rat", "Monkey", "Rooster", "Ox", "Dog"
                            };
       System.out.println("You are:");
       System.out.println("Year of the "+zodiacs[r]+". Lucky number is "+luckyNum[r]+".\nLucky color is "+luckyColor[r]+". Your soulmate's zodiac is "+soulMate[r]+".");
       
   }
}