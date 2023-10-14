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
                            System.out.print("Do you want to add another song?[Yes/No]: ");
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

}