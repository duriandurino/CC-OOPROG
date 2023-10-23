package LabActs;
class hour{
    public static void main(String[] args){
        int rows = 3;
        for(int i=0; i<rows;i++){
            for(int j=0; j<i;j++){
                System.out.print(" ");
            }
            for(int k=0; k<((rows-i)*2)-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
            
        for(int i=1;i<rows;i++){
            for(int j=0;j<rows-i-1;j++){
                System.out.print(" ");
            }
            for(int k=0;k<((i+1)*2)-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}