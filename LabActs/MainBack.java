import java.util.*;

public class MainBack {
    static Scanner sc = new Scanner(System.in);
    static FindSong findBy = new FindSong();
    ArrayList<String> currentSongs = new ArrayList<>();
    static ArrayList<String> songLib = new ArrayList<>();

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

        System.out.print("\n|v|-Add a Song-|v|\n");
        //if(z==0){
            sc.nextLine();
        //}
        System.out.print("Song name[!Case sensitive!]: ");
        name = sc.nextLine();
        System.out.print("Song artist[!Case sensitive!]: ");
        artist = sc.nextLine();
        System.out.print("Song album[If no album, input \"no album\"]: ");
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
        song.DisplayAdded();
        return song.AllToString();
    }

    static void StoreGroups(ArrayList<String> songLib){
        int i=0;
        boolean x = false;
        boolean y = false;
        boolean z = false;
        while(i<songLib.size()){
            x = false;
            y = false;
            z = false;
            //System.out.println(songLib.get(i));
            String getData = songLib.get(i);
            String[] splitData = getData.split("_",5);
            String[] getCateg = splitData[4].split(":", 2);
            String[] getAlbum = splitData[2].split(":", 2);
            String[] getArtist = splitData[1].split(":", 2);

            //Artist add
            if(findBy.GetArtistsCount()==0){
                findBy.AddArtist(getArtist[1]);
            }
            for(int j=0;j<findBy.GetArtistsCount();j++){
                if(getArtist[1].equals(findBy.GetFromArtists(j))){
                    x = true;
                }
            }
            if(x == false){
                findBy.AddArtist(getArtist[1]);
            }

            //Category add
            if(findBy.GetCategsCount()==0){
                findBy.AddCateg(getCateg[1]);
            }
            for(int j=0;j<findBy.GetCategsCount();j++){
                if(getCateg[1].equals(findBy.GetFromCategs(j))){
                    y = true;
                }
            }
            if(y == false){
                findBy.AddCateg(getCateg[1]);
            }

            //Album add
            if(findBy.GetAlbumsCount()==0){
                findBy.AddAlbum(getAlbum[1]);
            }
            for(int j=0;j<findBy.GetAlbumsCount();j++){
                if(getAlbum[1].equals(findBy.GetFromAlbums(j))){
                    z = true;
                }
            }
            if(z == false){
                findBy.AddAlbum(getAlbum[1]);
            }
            
            i++;
        }
        findBy.DisplayArtists();
        findBy.DisplayAlbums();
        findBy.DisplayCategs();
    }
}
