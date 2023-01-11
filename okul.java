
import java.util.Random;
import java.util.Scanner;

// yazdımız metod bir okul oluştulacak ogr numaraları ve ve notları ve not ortamaları oluşacal
//en yuksek not alan orencı numarsı ve en düşuk not yazdıran metod

public class okul {

    //ilk one ogr numaralrı 10000 ile 20000 arasında random sayı atarak uygulanmalıdır
    
     public static int [] ogrno(int ogrsay){
         Random  ra=new Random();
         int[] ogr=new int[ogrsay];
         for(int i=0;i<ogrsay;i++){
             ogr[i]=(int)(10000+(20000-10000)*ra.nextDouble());
         }
         return ogr;
      
     }
     
     public static int [][] ogrnot(int ders,int ogrsay){
         Random rastgele =new Random();
         int[][] ogr_not=new int[ders][ogrsay];
         for(int i=0;i<ders;i++){
             for(int k=0;k<ogrsay;k++){
                 ogr_not[i][k]=rastgele.nextInt(100);
             } 
         }
         return ogr_not;
         
         
     }
     
     public static double [] not_ort(int [][] aryy){
         int row=aryy.length;
         int col=aryy[0].length;
         double[] not_ort=new double[row];
         for(int i=0;i<row;i++){
             double toplam=0;
             for(int k=0;k<col;k++){
                 toplam+=aryy[i][k];
             }
             not_ort[i]=toplam/row;
          }
         return not_ort;
     }
     // yazdırma metotlar 
     public static void  arr_print(int [] aryy){
         for(int i=0;i<aryy.length;i++){
             System.out.print(aryy[i]+" ");
         }
     }
     
      public static void  arr_print(double [] aryy){
         for(int i=0;i<aryy.length;i++){
             System.out.print(aryy[i]+" ");
         }
     }
      
      public static void arr_print(int [][] aryy){
          int satir=aryy.length;
          int sutun=aryy[0].length;
          for(int i=0;i<satir;i++){
              for(int k=0;k<sutun;k++){
                  System.out.print(aryy[i][k]+" ");
              }
              System.out.println("  ");
          }
          
      }
      
      public static int [][] rapor (int [][] aryy,int[] ogreno){
          int satır=aryy.length;
          int sutun=aryy[0].length;
          int[][] rapor =new int[satır][4];
          for(int i=0;i<satır;i++){
              int max_not=aryy[i][0],min_not=aryy[i][0];
               int maxid=0;int minid=0;
              for(int k=0;k<sutun;k++){
                  if(aryy[i][k]>max_not){
                      max_not=aryy[i][k];
                      maxid=ogreno[k];
                  }
                  if(aryy[i][k]<min_not){
                     min_not=aryy[i][k];
                    minid=ogreno[k];
                  }
                  
              }
              rapor[i][0]=max_not;rapor[i][1]=maxid;rapor[i][2]=min_not;rapor[i][3]=minid;
          }
          return rapor;
      }
      
      public static void atla(){
          System.out.println("  ");
      }
      
     
     
            
   
    

    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        System.out.println("lütfen oğrenci sayısı giriniz");
        int ogr_sayısı=scanner.nextInt();
        System.out.println("lütfen  istediniz ders sayısı giriniz");
        int ders_say=scanner.nextInt();
        int[] ogr_num=ogrno(ogr_sayısı);
        int[][] ogr_not=ogrnot(ders_say, ogr_sayısı);
        double[] not_ortlama =not_ort(ogr_not);
        int [][] rapor=rapor(ogr_not, ogr_num);
        System.out.println("ogr numaraları");
        arr_print(ogr_num);
        atla();atla();      
        System.out.println("ogr notlar");
        arr_print(ogr_not);
        atla();atla();   
        System.out.println("ogr ortamakarı");
        arr_print(not_ortlama);
        atla();atla();
        System.out.println("raporunuz: ");
        arr_print(rapor);
        System.out.println("-------------------------");
        atla();atla();
        
    }
    
}
