package FileHandling;
import java.io.File;
import java.io.FileInputStream;
import  java.io.FileOutputStream;
import java.util.Arrays;

public class Main {

    private  static int skipSpaces(byte[] buffer, int index){
           while (index<buffer.length && buffer[index]==32){
               index++;
           }
           return  index;
    }

    private  static  int skipInitailSpaces(byte [] buffer){

            int i = 0;
            while (i< buffer.length && buffer[i]==32){
                i++;
            }
            return i;

    }

    public static void main(String[] args) {
        File num_fp = new File("./FileHandling/Data/nums.txt");
        File alpha_fp = new File("./FileHandling/Data/alpha.txt");
        File result_fp = new File("./FileHandling/Data/result.txt");
//        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        System.out.println(num_fp.exists());

        try{
            FileInputStream num_fs = new FileInputStream(num_fp);
            FileInputStream alpha_fs = new FileInputStream(alpha_fp);
            FileOutputStream result_fs = new FileOutputStream(result_fp);



            int n = num_fs.available();
            int m = alpha_fs.available();

            byte [] num_buffer = new byte[n];
            num_fs.read(num_buffer);

            byte [] alpha_buffer = new byte[m];
            alpha_fs.read(alpha_buffer);

            byte [] result_buffer = new byte[m+n];

            int i =skipInitailSpaces(num_buffer) , j=skipInitailSpaces(alpha_buffer), k=0;

            while (i<n || j<m ){

                while (i<n &&num_buffer[i]!=32 ){
                    result_buffer[k++] = num_buffer[i++];
                }
                i= skipSpaces(num_buffer,i);

                while (j<m &&alpha_buffer[j] !=32){
                    result_buffer[k++] = alpha_buffer[j++];
                    result_buffer[k++] = 32;
                }
                j= skipSpaces(alpha_buffer,j);
            }

            result_fs.write(result_buffer,0,k);
            System.out.println("All Done");

        }
        catch (Exception e){
            System.out.println("Error" + e);
        }
    }

}
