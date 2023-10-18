public class MainZodiac extends Zodiac{
    public static void main(String[] args){
        while(true){
            char loop;
            DisplayMonths();
            UserInput();
            GiveZodiac();
            while(true){
                System.out.print("Do you want to input another Birthdate?[y/n]: ");
                loop = sc.next().charAt(0);
                if(loop=='y'||loop=='n'){
                    break;
                }
                EMssg();
            }
            if(loop=='n'){
                break;
            }
        }
    }
}