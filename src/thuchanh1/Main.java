package thuchanh1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao duong dan");
        String patch = scanner.nextLine();
        readFileText(patch);





    }
    public static void readFileText(String filePatch){
        try {
            File file = new File(filePatch);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br= new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line=br.readLine()) !=null){
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("tong bang: " + sum);

        }catch (Exception e){
            System.err.println("file khong ton tai or noi dung co loi");
        }


    }
}