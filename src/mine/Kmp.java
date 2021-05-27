package mine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 王涵威
 * @date 21.5.26 20:22
 */
public class Kmp {


    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        char[] tChars = haystack.toCharArray();
        int tLen = haystack.length();
        int pLen = needle.length();
        int[][] dp = getDP(needle.toCharArray(), pLen);
        int j = 0;
        for (int i = 0; i < tLen; i++) {
            j = dp[j][tChars[i]];
            if (j == pLen) {
                return i - j + 1;
            }
        }
        return -1;
    }

// private int[][] getDP(char[] pattern, int pLen) {
//     int[][] dp = new int[pLen][128];
//     int similarState = 0;
//     dp[0][pattern[0]] = 1;
//     for (int i = 1; i < pLen; i++) {
//         for (int j = 0; j < 128; j++) {
//             if (pattern[i] == j) {
//                 dp[i][j] = i + 1;
//             } else {
//                 dp[i][j] = dp[similarState][j];
//             }
//         }
//         similarState = dp[similarState][pattern[i]];
//     }
//     return dp;
// }

    private int[][] getDP(char[] pattern, int pLen) {
        int[][] dp = new int[pLen][128];
        int similarState = 0;
        dp[0][pattern[0]] = 1;
        for (int i = 1; i < pLen; i++) {
            for (int j = 0; j < 128; j++) {
                dp[i][j] = dp[similarState][j];
            }
            dp[i][pattern[i]] = i + 1;
            similarState = dp[similarState][pattern[i]];
        }
        return dp;
    }



    public static void main(String[] args) throws Exception {
//        String t = "sit by ";
        String t = "Im going to the sun on my holiday I will go there by a spaceship I will take a big blue spaceship" +
                " then Ill pilot the spaceship to the sun the sun is very hot So I put on the super-shirt In the morning " +
                "I will have some sun burger for my breakfast " +
                " At eight oclock I will play with my friends there they are super dog and super girl Super dog is white and black Super girl is very clever Super girl and super dog like to play with me So " +
                "I play with them for forty minutes then I do my homework in my little red room on a small blue table After my home work " +
                "I will have my lunch I will eat sun salad I will make some red toy bear to the sun babies I will have red juice red fish and red rice All the things are red then " +
                "I need a lot of water on the sun because the sun is too hot So I will walk to the spaceship Ill pilot the spaceship to the earth " +
                " This is a good holiday on the sun";
        StringBuilder t1 = new StringBuilder("If we have a book ,we will not be felling of being longly " +
                "When I'm free or in trouble, I always take out a book and read quietly. In no time, " +
                "I've put my heart into it so that I'll forget all the troubles. It's in this way that I've formed the habit of reading in any time. " +
                "Little boys as I was, I was interest in picture books and storybooks. I was struck by them. No sooner had I entered the middle " +
                "school than I began to read novel, plays, essays and so on. I found I could get much from them. Little by little I took great " +
                "interest in literature and last term I won the first prize in the composition contest among middle-school students in Zhe Jiang. " +
                "Reading \"The Emperor's New Clothes\", I had to let out a burst of laughter over his fool. \"The Little Match Girl\" couldn't keep " +
                "me from crying for her misery. \"Robinson Crusoe\" took me into a strange world full of danger. And I was also deeply impressed " +
                "by Helen Keller's patience and perseverance... Besides these, books also tell me other thing -how to be a man and how to tell the " +
                "difference between right and wrong. In a word, good books can make me know what I didn't before. " +
                "So I think of a good book as my best friend." +
                "");
        
//        try (FileReader fr = new FileReader("words/words.txt");
//             BufferedReader br = new BufferedReader(fr);) {
//            for (int i = 0; i < 100; i++) {
//                long start = System.currentTimeMillis();
////                t1.append(" ");
////                List<String> rstList = br.lines()
////                        .filter(t1.toString()::contains)
////                        .collect(Collectors.toList());
//                List<String> rstList = br.lines()
//                        .filter(o -> k.strStr(t1, o) > -1)
//                        .collect(Collectors.toList());
//                System.out.println((System.currentTimeMillis() - start) + "ms");
//            }
////            rstList.forEach(System.out::println);
//        }
        for (int i = 0; i < 100; i++) {
            t1.append(" ");
            long startTime = System.currentTimeMillis();
//            getRst(t1.toString());
            getRstWith(t1.toString());
            System.out.println((System.currentTimeMillis() - startTime) + "ms");
        }

    }


    private static List<String> wordsList;

    private static Kmp k = new Kmp();

    static {
        wordsList = new ArrayList<>();
        try (FileReader fr = new FileReader("words/words.txt");
             BufferedReader br = new BufferedReader(fr);) {
            wordsList = br.lines().collect(Collectors.toList());
        } catch (Exception e) {

        }
    }

    public static List<String> getRst(String s ) {
        return wordsList.stream().filter(o -> k.strStr(s, o) > -1).collect(Collectors.toList());
    }

    public static List<String> getRstWith(String s ) {
        return wordsList.stream().filter(s::contains).collect(Collectors.toList());
    }


}
