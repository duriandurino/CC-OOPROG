class Song{
    private String sYear;
    private String sName;
    private String sArtist;
    private String sCateg;
    private String sAlbum;

    Song(String sName, String sYear, String sArtist, String sAlbum, String sCateg){
        this.sName = sName;
        this.sArtist = sArtist;
        this.sAlbum = sAlbum;
        this.sYear = sYear;
        this.sCateg = sCateg;
    }

    String AllToString(){
        String concatData = "Song name: "+this.sName+".mp3_Song artist: "+this.sArtist+"_From album: "+this.sAlbum+"_Year released: "+this.sYear+"_Song category: "+this.sCateg;
        return concatData;
    }

    void DisplayAdded(){
        System.out.println("New song added:");
        System.out.println("Song name: "+this.sName+".mp3\nSong artist: "+this.sArtist+"\nFrom album: "+this.sAlbum+"\nYear released: "+this.sYear+"\nSong category: "+this.sCateg);
    }
}