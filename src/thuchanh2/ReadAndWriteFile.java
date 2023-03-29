package thuchanh2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public static int findMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max<numbers.get(i)){
                max = numbers.get(i);
            }
        }
        return max;


    }
    public static void main(String[] args) {
       ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
       String PATCH_NUMBER = "src//number.txt";
       String PATCH_RESULT = "src//result.txt";
       List<Integer> numbers = readAndWriteFile.readFile(PATCH_NUMBER);
        System.out.println(numbers);
       int maxValue = findMax(numbers);
       readAndWriteFile.writeFile(PATCH_RESULT,maxValue);
    }

    public List<Integer> readFile(String filePatch){
        List<Integer> numbers=new ArrayList<>();
        try {
            File file = new File(filePatch);
           if (!file.exists()){
        throw new FileNotFoundException();
           }
            BufferedReader br = new BufferedReader(new FileReader(file));
           String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();

        }catch (Exception e){
            System.out.println("File khong ton tai or noi dung co loi");
        }

        return numbers;
    }
    public void writeFile(String filePatch, int max){
        try {
            FileWriter writer = new FileWriter(filePatch,true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write("gia tri lon nhat la: "+ max);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
