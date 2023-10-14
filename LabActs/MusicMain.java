import java.util.*;

public class MusicMain{
    static Scanner sc = new Scanner(System.in);
    static FindSong findBy = new FindSong();
    ArrayList<String> currentSongs = new ArrayList<>();

    public static void main(String[] args){
        ArrayList<String> songLib = new ArrayList<>();
        
        int mLoop=1;
        do{
        int act = Menu();
        switch (act){
            case 1:
                int z=0;
                do{
                    songLib.add(AddSong(z));

                    String stop;
                    while(true){
                        System.out.print("Do you want to add another song?[Yes/No]: ");
                        sc.nextLine();
                        stop = sc.nextLine();
                        if(stop.equals("Yes")||stop.equals("yes")||stop.equals("No")||stop.equals("no")){
                            break;
                        }
                    }
                    if(stop.equals("No")||stop.equals("no")){
                        break;
                    }
                    z++;
                }while(true);
                StoreGroups(songLib);
                break;
            case 2:
                
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                mLoop = 0;
                break;
            default: 
                break;
        }
        }while(mLoop!=0);
    }

    static void EMssg(){
        System.out.println("Error, please input again...");
    }

    static int Menu(){
        String[] actions = {"Add a Song", "Play Songs by Artist", "Play Songs by Category", "Play Songs by Album", "Exit Program"};
        int act = 0;
        do{
            System.out.println("Choose and action:");
            for(int i=0;i<actions.length;i++){
                System.out.println("["+(i+1)+"] "+actions[i]);
            }
            System.out.println();
            System.out.print("Enter num of chosen action: ");
            while(true){
                if(sc.hasNextInt()){
                    act = sc.nextInt();
                    if(act>0&&act<5){
                        break;
                    }
                }
                sc.nextLine();
                EMssg();
            }
            break;
        }while(true);
        return act;
    }

    static String AddSong(int z){
        int year;
        String name;
        String artist;
        String album;
        String[] categLib = {
            "Hip-Hop", "Rock", "Pop", "Reggae", "Popular Music",
            "Funk", "Folk Music", "Country", "Rhythm and Blues", "Blues"
        };
        String categ;
        String yrToString;

        //do{
            System.out.print("\nAdd a Song:\n");
            if(z==0){
                sc.nextLine();
            }
            System.out.print("Song name: ");
            name = sc.nextLine();
            System.out.print("Song artist: ");
            artist = sc.nextLine();
            System.out.print("Song album[If no album input \"No Album\"]: ");
            album = sc.nextLine();
            while(true){
                System.out.print("Year released: ");
                if(sc.hasNextInt()){
                    year = sc.nextInt();
                    if(year<2024){
                        yrToString = String.valueOf(year);
                        break;
                    }
                }
                sc.nextLine();
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
                    if(num<11){
                        categ = categLib[num-1];
                        break;
                    }
                }
                sc.nextLine();
                EMssg();
            }
            Song song = new Song(name, yrToString, artist, album, categ);
            /**/
        //}while(true);
            song.DisplayAdded();
        return song.AllToString();
    }

    static void StoreGroups(ArrayList<String> songLib){
        int i=0;
        while(i<songLib.size()){
            boolean dupe = false;
            System.out.println(songLib.get(i));
            String getData = songLib.get(i);
            String[] splitData = getData.split("_",5);
            String[] getArtist = splitData[1].split(":", 2);
            System.out.println(getArtist[1]);
            if(findBy.GetArtistsCount()==0){
                findBy.AddArtist(getArtist[1]);
            }else{
                for(int j=0;j<findBy.GetArtistsCount();j++){
                    if(getArtist[1].equals(findBy.GetFromArtists(j))){
                        dupe = true;
                    }
                }
            }
            if(dupe == false){
                findBy.AddArtist(getArtist[1]);
            }
            i++;
        }
        findBy.DisplayArtists();
    }
}