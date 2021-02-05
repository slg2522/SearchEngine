import java.util.Set;

public class Main {

    public static void main(String[] args) {

        SearchDemo obj = new SearchDemo();
        Set<String> result = obj.getDataFromGoogle("soccer");
        for(String temp : result){
            System.out.println(temp);
        }
        System.out.println(result.size());
    }
}
