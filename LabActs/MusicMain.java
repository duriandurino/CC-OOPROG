import java.util.*;

public class MusicMain{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<Song> songLib = new ArrayList<>();
        int year;
        String name;
        String artist;
        String category;

        ArrayList<String> albums = new ArrayList<>();
        ArrayList<String> categs = new ArrayList<>();
        
        int act = Menu();
        switch (act){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    static int Menu(){
        String[] actions = {"Add a Song", "Pick Songs by Artist", "Pick Songs by Category"};
        int act = 0;
        do{
            System.out.println("Choose and action:");
            for(int i=0;i<actions.length;i++){
                System.out.println("["+(i+1)+"] "+actions[i]);
            }
            System.out.println();
            System.out.print("Enter num of chosen action: ");
            act = sc.nextInt();
            if(act>0&&act<4){
                break;
            }
            System.out.println("Error, please input again...");
        }while(true);
        return act;
    }
}