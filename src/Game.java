import java.util.Random;
import java.util.Scanner;

public class Game {
    String[] words = {
            "apple", "orange", "lemon",
            "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};

    public void start() {
        guessTheWord(words);
    }

    public void guessTheWord(String[] words) {
        Random random = new Random();
        String computerWord = words[random.nextInt(words.length)];
        //String computerWord = words[4];

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userWord = scanner.nextLine();
            if (userWord.equals(computerWord)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                String result = compareWords(userWord, computerWord);
                System.out.println("Вы не угадали. Слово: " + result);
            }
        }
    }

    public String compareWords(String word1, String word2) {
        String grid = "###############";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                builder.append(word1.charAt(i));
            } else {
                builder.append(grid);
                builder.setLength(15);
                break;
            }

        }
        return builder.toString();
    }
}
