import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class DataManager {

    ArrayList<Data> data = new ArrayList<>();

    String fp="src\\assets\\data.txt";

    DataManager(){
        loadData();
    }

     void writeData(String name){
         data.add(new Data(name));
         if(checkName(data.getLast().name)){
            for(int i=0; i<data.size();i++){
                if(data.get(i).name.equals(name)){
                    //System.out.println(data.get(i).name+":"+name);
                    data.removeLast();
                    data.get(i).wins+=1;
                }
            }
         }else{
             data.getLast().wins+=1;
         }
         data.sort(Comparator.comparing(Data::getWins).reversed());
         try{
             BufferedWriter bw = new BufferedWriter(new FileWriter(fp));
             for(Data data : data){
                bw.write(data.dataString());
                bw.newLine();
             }
             bw.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }

     boolean checkName(String name){
         boolean exist=false;
         try {
             BufferedReader br = new BufferedReader(new FileReader(fp));
             String line;
             while((line=br.readLine())!=null){
                String[] dataSplit = line.split(":");
                String extName = dataSplit[0];
                if(extName.equals(name)){
                    exist=true;
                }
             }
             br.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return exist;
     }

     void loadData(){
         try {
             BufferedReader br = new BufferedReader(new FileReader(fp));
             String line;
             while((line=br.readLine())!=null){
                 String[] dataSplit = line.split(":");
                 int extWins = Integer.valueOf(dataSplit[1]);
                 data.add(new Data(dataSplit[0], extWins));
             }
             data.sort(Comparator.comparing(Data::getWins).reversed());
             br.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     String[] getDatas(){
         String extData[] = new String[10];
         try {
             BufferedReader br = new BufferedReader(new FileReader(fp));
             String line;
             int i=0;
             while(((line=br.readLine())!=null)&&(i<extData.length)){
                 //System.out.println(line);
                 extData[i] = line;
                 i++;
             }
             br.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return extData;
     }
}
