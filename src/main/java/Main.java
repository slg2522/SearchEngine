import java.util.Set;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        SearchDemo obj = new SearchDemo();
        Set<String> result = obj.getDataFromGoogle(query);
        for(String temp : result){
            System.out.println(temp);
        }
        System.out.println(result.size());
    }
}
