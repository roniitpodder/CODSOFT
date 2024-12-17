import java.util.*;
public class NumberGame{
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        boolean playAgain=true;
        int score=0;
        int round=1;
        System.out.println("Welcome To The NUMBER GAME\n");
        while(playAgain){
            int compno=(int)((Math.random()*100)+1);
            int attempts=5;
            boolean guessnoIs=false;
            System.out.println("A Number is generated between 1 and 100,\nYou have 5 attempts, Try to guess it correctly.\nALL THE BEST!\n");
            while(attempts>0){
                System.out.print("Enter Your Guess : ");
                int guessno=sc.nextInt();
                if (guessno==compno){
                    System.out.println("\nCONGRATS! Your Guess is correct");
                    guessnoIs=true;
                    System.out.println("You score 1 point\n");
                    score++;
                    break;
                }
                else if (guessno>compno){
                    System.out.println("\nYour Guess is too high");
                }
                else {
                    System.out.println("\nYour Guess is too low");
                }
                attempts--;
                System.out.println("Attempts Left : "+attempts+"\n");
            }
            if (!guessnoIs) {
                System.out.println("Sorry! No attempts left. The correct number was "+compno+"\n");
                System.out.println("Your Score for this round is "+score+"\n");
            }
            System.out.println("Do you want to play again? Yes or No");
            String res=sc.next().toLowerCase();
            playAgain=res.equals("yes");
            if (playAgain==true){
                round++;
            }
            System.out.println();
            }
        System.out.println("Your Final Score is "+score);
        System.out.println("Total Rounds Played : "+round);
        System.out.println("Thanks For Playing!");
        sc.close();
    }
}