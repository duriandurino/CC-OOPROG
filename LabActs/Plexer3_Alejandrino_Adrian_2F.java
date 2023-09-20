import java.util.*;

public class Plexer3_Alejandrino_Adrian_2F{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int size = 0;
        
        while(true){
    
          System.out.println("Enter array size: ");
          
          if(sc.hasNextInt()){
            size = sc.nextInt();
            break;
          }
          
          System.out.println("Pls input again…");
          sc.nextLine();
          
        }
        
        int[] arr = new int[size];
        
         for(int i=0; i<size;i++){
              System.out.println("Input to array: ");
              
              if(sc.hasNextInt()){
                arr[i]= sc.nextInt();
              }else{
                System.out.println("Pls input again…");
                i-=1;
                sc.nextLine();
              }
          
        }
        
        System.out.println("Array before sorting:");
        System.out.print("| ");
        for(int i = 0; i<size; i++){
            System.out.print(arr[i]+" | ");
        }
        System.out.println();
        
        for(int i = 0; i<size; i++){
            for(int j = 1; j <size-i;j++){
                if(arr[j-1]>arr[j]){
                    int tmp = arr[j-1];
                    
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        
        
        
        System.out.println("Array after sorting:");
        System.out.print("| ");
        for(int i = 0; i<size; i++){
            System.out.print(arr[i]+" | ");
        }
        
        System.out.println("\nDuplicated values:");
        System.out.print("| ");
        int dup = 0;
        
        for(int i = 0; i<size;i++){
            
            for(int j = 0; j<size;j++){
                //System.out.println(arr[i]+"-"+arr[j]);
                if(arr[i] == arr[j] && j!=i && dup!=arr[i]){
                    
                    dup = arr[i];
                    System.out.print(dup+" | ");
                    break;
                    //System.out.println(dup[i]);
                }
            }

        }
    
    }

}