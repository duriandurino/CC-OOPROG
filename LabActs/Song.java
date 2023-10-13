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
        String concatData = "Song name: "+this.sName+".mp3_Song artist: "+this.sArtist+"_Year released: "+this.sYear+"_Song category: "+this.sCateg;
        return concatData;
    }
}