public class MusicMain extends MainBack{
    public static void main(String[] args){        
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
                            System.out.print("\nDo you want to add another song?[Yes/No]: ");
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
                //end of AddSong
                case 2:
                    if(songLib.size()==0){
                        System.out.println("\nSong Library is Empty\n");
                        break;
                    }
                    do{
                        DisplaySongLib();
                        while(true){
                            System.out.print("\nInput song number of chosen song: ");
                            if(sc.hasNextInt()){
                                int num = sc.nextInt();
                                if(num>0&&num<=songLib.size()){
                                    PlaySong(num-1);
                                    break;
                                }
                            }
                            sc.nextLine();
                            EMssg();
                        }

                        String stop;
                        while(true){
                            System.out.print("\nDo you want to play another song?[Yes/No]: ");
                            sc.nextLine();
                            stop = sc.nextLine();
                            if(stop.equals("Yes")||stop.equals("yes")||stop.equals("No")||stop.equals("no")){
                                break;
                            }
                        }
                        if(stop.equals("No")||stop.equals("no")){
                            break;
                        }
                    }while(true);
                    break;
                //end of PlaySong
                case 3:
                    if(findBy.GetArtistsCount()==0){
                        System.out.println("\nSong Library is Empty\n");
                        break;
                    }
                    do{
                        PlayByArtist();
                        String stop;
                        while(true){
                            System.out.print("\nDo you want to play another song?[Yes/No]: ");
                            sc.nextLine();
                            stop = sc.nextLine();
                            if(stop.equals("Yes")||stop.equals("yes")||stop.equals("No")||stop.equals("no")){
                                break;
                            }
                        }
                        if(stop.equals("No")||stop.equals("no")){
                            break;
                        }
                    }while(true);
                    currentSongs.clear();
                    break;
                //end of PlayByArtist
                case 4:
                    if(findBy.GetCategsCount()==0){
                        System.out.println("\nSong Library is Empty\n");
                        break;
                    }
                    do{
                        PlayByCategory();
                        String stop;
                        while(true){
                            System.out.print("\nDo you want to play another song?[Yes/No]: ");
                            sc.nextLine();
                            stop = sc.nextLine();
                            if(stop.equals("Yes")||stop.equals("yes")||stop.equals("No")||stop.equals("no")){
                                break;
                            }
                        }
                        if(stop.equals("No")||stop.equals("no")){
                            break;
                        }
                    }while(true);
                    currentSongs.clear();
                    break;
                case 5:
                    if(findBy.GetAlbumsCount()==0){
                        System.out.println("\nSong Library is Empty\n");
                        break;
                    }
                    do{
                        PlayByAlbum();
                        String stop;
                        while(true){
                            System.out.print("\nDo you want to play another song?[Yes/No]: ");
                            sc.nextLine();
                            stop = sc.nextLine();
                            if(stop.equals("Yes")||stop.equals("yes")||stop.equals("No")||stop.equals("no")){
                                break;
                            }
                        }
                        if(stop.equals("No")||stop.equals("no")){
                            break;
                        }
                    }while(true);
                    currentSongs.clear();
                    break;
                //end of PlayByAlbum
                case 6:
                    mLoop = 0;
                    break;
                default: 
                    EMssg();
                    break;
            }
        }while(mLoop!=0);
    }

}