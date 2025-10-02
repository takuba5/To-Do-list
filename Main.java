import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println("1-Add a to-do item 2-Remove item 3-Show the list");
        int choise = scanner.nextInt();
        scanner.nextLine();

        if(choise==1 || choise==2 || choise==3 || choise==4 ){
            switch (choise){
                case(1):
                    System.out.println("Add text:");
                    String tekst = scanner.nextLine();
                    Add(tekst);
                    break;
                case(2):
                    Delete();
                    break;


                case(3):
                    System.out.println("Show list: ");
                    Show();
                    break;
            }
        }else{
            System.out.println("Bad choise");
        }

    }

    private static void Add(String tekst){

        try{
            FileWriter writer = new FileWriter("in.txt", true);
            writer.write(tekst + "\n");
            writer.close();
            System.out.println("Safe to file");
        }catch (IOException e ){
            System.out.println("Error safe file: " + e);
        }
    }
    private static void Show(){
        String filename = "in.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            File file = new File(filename);
            if(file.length()==0){
                System.out.println("File is empty");

            }else {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Error read file");
        }
    }
    private static void Delete(){
        String filename = "in.txt";

         ArrayList<String> list = new ArrayList<String>();

        try{

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while((line = reader.readLine()) != null){
                list.add(line);

            }
           System.out.println(list);
            System.out.println("Which item do you want to remove, starting from 0?");
            int wybor = scanner.nextInt();

            list.remove(wybor);

            FileWriter file = new FileWriter("in.txt", false);
             for(int i = 0; i<list.size();i++) {

                     file.append(list.get(i) + "\n");

             }
            file.close();
             reader.close();

            BufferedReader cos = new BufferedReader(new FileReader(filename));
            String linia;
            System.out.println("Items after removal: ");
            while ((linia = cos.readLine()) != null) {
                System.out.println(linia);
            }

            cos.close();

        }catch (IOException e){
            System.out.println("Error: " + e);
        }

    }
}




