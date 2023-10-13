import java.util.ArrayList;

class FindSong {
    ArrayList<String> albums = new ArrayList<>();
    ArrayList<String> categs = new ArrayList<>();
    ArrayList<String> artists = new ArrayList<>();

    void AddAlbum(){

    }
    String GetFromAlbum(){
        String extractAlbum = "";

        return extractAlbum;
    }

    void AddArtist(String artist){
        artists.add(artist);
    }
    String GetFromArtists(int i){
        String getArtist = artists.get(i);
        return getArtist;
    }
    int GetArtistsCount(){
        //System.out.println(artists.size());
        return artists.size();
    }
    void DisplayArtists(){
        System.out.println("Artists in Library:");
        for(int i=0;i<GetArtistsCount();i++){
            System.out.println((i+1)+"-"+artists.get(i));
        }
    }
}
