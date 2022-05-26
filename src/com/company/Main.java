package com.company;
import java.io.*;
import java.io.IOException;

public class Main {
/*
    BufferedReader - считывает символы из потока
    FileReader - для чтения текстовых файлов
 */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Artem\\IdeaProjects\\laba13//file.txt"))) {
            int n = 0;
            String text = "";
            while ((n = br.read()) != -1) {
                text += (char) n;
            }
            int value = text.indexOf("//");
            int value2 = text.indexOf("\n",value);
            //StringBuffer - делает изменения в строке символов
            StringBuffer sb = new StringBuffer(text);
            sb.delete(value, value2);
            int value3 = sb.indexOf("/*");
            int value4 = sb.lastIndexOf("*/");
            StringBuffer sb2 = new StringBuffer(sb);
            sb2.delete(value3, value4 + 2);
            System.out.println(sb2);
            try (FileWriter fw = new FileWriter("C:\\Users\\Artem\\IdeaProjects\\laba13//file2.txt");
                 BufferedWriter bw = new BufferedWriter(fw)){
                bw.write(sb2.toString());
            } catch (IOException ex){
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}