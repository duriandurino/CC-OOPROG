class Song{
    private String sYear;
    private String sName;
    private String sArtist;
    private String sCateg;

    Song(String sName, String sYear, String sArtist, String sCateg){
        this.sName = sName;
        this.sArtist = sArtist;
        this.sYear = sYear;
        this.sCateg = sCateg;
    }

    String AllToString(){
        String concatData = "Song name: "+this.sName+"Song artist: "+this.sArtist+"Year released: "+this.sYear+"Song category: "+this.sCateg;
        return concatData;
    }
}