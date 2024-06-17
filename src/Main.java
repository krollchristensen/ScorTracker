import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfPlayers = 0;
        int highestScore = 0;
        int totalScore = 0;
        String topPlayer = "";

        System.out.print("Enter the number of players: ");
        numberOfPlayers = input.nextInt();

        int currentPlayer = 1;
        while (currentPlayer <= numberOfPlayers) {
            System.out.print("Enter name for player " + currentPlayer + ": ");
            String playerName = input.next();

            System.out.print("Enter score for " + playerName + ": ");
            int score = input.nextInt();

            // Score validation
            if (score < 0 || score > 100) {
                System.out.println("Invalid score, must be between 0 and 100. Try again.");
                continue; // Skip to the next iteration of the loop
            }

            // Update total score and highest score
            totalScore += score;
            if (score > highestScore) {
                highestScore = score;
                topPlayer = playerName;
            }

            // Categorize score
            String category;
            if (score >= 90) {
                category = "High";
            } else if (score >= 50) {
                category = "Medium";
            } else {
                category = "Low";
            }

            // Feedback based on score
            if (category.equals("High")) {
                System.out.println(playerName + " has a high score!");
            } else if (category.equals("Medium")) {
                System.out.println(playerName + " has a medium score.");
            } else {
                System.out.println(playerName + " has a low score. Try to improve!");
            }

            // Bonus points feedback
            boolean bonus = (score >= 70 && score % 2 == 0);
            String bonusFeedback = bonus ? "You get bonus points!" : "No bonus points.";
            System.out.println(bonusFeedback);

            currentPlayer++;
        }

        // Calculate average score
        double averageScore = (double) totalScore / numberOfPlayers;

        // Print overall report
        System.out.println("\n--- Overall Report ---");
        System.out.println("Number of players: " + numberOfPlayers);
        System.out.println("Highest score: " + highestScore + " (by " + topPlayer + ")");
        System.out.println("Average score: " + averageScore);
    }
}
