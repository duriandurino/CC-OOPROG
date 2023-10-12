import java.util.*;

public class MusicMain{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        ArrayList<Object> songLib = new ArrayList<>();

        ArrayList<String> albums = new ArrayList<>();
        ArrayList<String> categs = new ArrayList<>();
        
        int act = Menu();
        switch (act){
            case 1:
                AddSong();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    static void EMssg(){
        System.out.println("Error, please input again...");
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
            EMssg();
        }while(true);
        return act;
    }

    static void AddSong(){
        int year;
        String name;
        String artist;
        String[] categLib = {
            "Hip-Hop", "Rock", "Pop", "Reggae", "Popular Music",
            "Funk", "Folk Music", "Country", "Rhythm and Blues"
        };
        String categ;
        String yrToString;

        do{
            System.out.println("Add a Song:\n");
            System.out.print("Song name: ");
            name = sc.nextLine();
            System.out.print("Song artist: ");
            artist = sc.nextLine();
            while(true){
                System.out.print("Year released: ");
                if(sc.hasNextInt()){
                    year = sc.nextInt();
                    if(year<2024){
                        yrToString = String.valueOf(year);
                        break;
                    }
                }
                EMssg();
            }
            System.out.println("Song Categories:");
            for(int i=0;i<categLib.length;i++){
                System.out.println("["+(i+1)+"] "+categLib[i]);
            }
            while(true){
                System.out.print("Enter num of song category: ");
                if(sc.hasNextInt()){
                    int num = sc.nextInt();
                    if(num>9){
                        categ = categLib[num-1];
                        break;
                    }
                }
                EMssg();
            }
            
            break;
        }while(true);
    }
}