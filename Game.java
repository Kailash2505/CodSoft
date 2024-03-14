import java.util.*;
class Game
{
    public static void main(String[] args)
    {
        int max = 10, min = 0;
        int score = 0;
        int system_number = (int)(Math.random()*(max-min+1)+min);
        System.out.println(system_number);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Enter the Guessed number: ");
            int number = sc.nextInt();
            if(system_number == number)
            {
                System.out.println("Congrats");
                score+=5;
                break;
            }
            else if(number > system_number)
            {
                System.out.println("Too HIGH");
                score--;
            }
            else if(number < system_number)
            {
                System.out.println("Too LOW");
                score--;
            }
        }
        System.out.println("Your Total Score is: "+score);
        System.out.println("Thank you for playing");
        sc.close();
    }
}