import java.util.ArrayList;

class FindSong {
    ArrayList<String> albums = new ArrayList<>();
    ArrayList<String> categs = new ArrayList<>();
    ArrayList<String> artists = new ArrayList<>();

    void AddAlbum(String album){
        albums.add(album);
    }
    String GetFromAlbums(int i){
        String extract = albums.get(i);
        return extract;
    }
    int GetAlbumsCount(){
        return albums.size();
    }
    void DisplayAlbums(){
        System.out.println("Albums in Library:");
        for(int i=0;i<GetAlbumsCount();i++){
            System.out.println((i+1)+"-"+albums.get(i));
        }
    }

    void AddArtist(String artist){
        artists.add(artist);
    }
    String GetFromArtists(int i){
        String getArtist = artists.get(i);
        return getArtist;
    }
    int GetArtistsCount(){
        return artists.size();
    }
    void DisplayArtists(){
        System.out.println("Artists in Library:");
        for(int i=0;i<GetArtistsCount();i++){
            System.out.println((i+1)+"-"+artists.get(i));
        }
    }

    void AddCateg(String categ){
        categs.add(categ);
    }
    String GetFromCategs(int i){
        String extract = categs.get(i);
        return extract;
    }
    int GetCategsCount(){
        return categs.size();
    }
    void DisplayCategs(){
        System.out.println("Category Group in Library:");
        for(int i=0;i<GetCategsCount();i++){
            System.out.println((i+1)+"-"+categs.get(i));
        }
    }
}
