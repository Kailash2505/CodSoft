import java.util.*;

public class WordCounter
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        String[] words = text.split("\\s+");
        System.out.println("Total number of words: "+words.length);
        sc.close();
    }

} 