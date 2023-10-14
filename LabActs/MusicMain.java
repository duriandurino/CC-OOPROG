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
                case 2:
                    if(songLib.size()==0){
                        break;
                    }
                    DisplaySongLib();
                    do{
                        while(true){
                            System.out.print("\nInput song number of chosen song: ");
                            if(sc.hasNextInt()){
                                int num = sc.nextInt();
                                if(num<songLib.size()){
                                    PlaySong(num);
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
                case 3:
                    
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    mLoop = 0;
                    break;
                default: 
                    break;
            }
        }while(mLoop!=0);
    }

}