import java.util.Scanner;

public class Hari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Enter the first number:");
            int a = scanner.nextInt();
            System.out.println("Enter the second number:");
            int b = scanner.nextInt();

            int c = a/b;

            System.out.println("The result:"+c);

        } catch(Exception e){
            //System.out.println(e); - reference
            //System.out.println(e.getMessage());  -- builtIn method
            e.printStackTrace();
        }




    }
}
