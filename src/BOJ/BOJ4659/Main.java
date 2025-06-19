package BOJ.BOJ4659;

import java.util.Scanner;

public class Main {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }

            boolean flag = false;
            for (int i = 0; i < vowels.length; i++) {
                if (input.contains(String.valueOf(vowels[i]))) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);

                    if (i != input.length() - 1 && c == input.charAt(i + 1)) {
                        if (!(c == 'e' || c == 'o')) {
                            flag = false;
                            break;
                        }
                    }

                    if (i < input.length() - 2) {
                        if (isVowel(c) && isVowel(input.charAt(i + 1)) && isVowel(input.charAt(i + 2))
                                || !isVowel(c) && !isVowel(input.charAt(i + 1)) && !isVowel(input.charAt(i + 2))) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag) {
                System.out.printf("<%s> is acceptable.\n", input);
                continue;
            }

            System.out.printf("<%s> is not acceptable.\n", input);
        }
    }

    private static boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();
            if (input.equals("end")) break;

            if (isAcceptable(input)) {
                System.out.printf("<%s> is acceptable.\n", input);
            } else {
                System.out.printf("<%s> is not acceptable.\n", input);
            }
        }
    }

    private static boolean isAcceptable(String input) {
        return containsVowel(input)
            && noThreeConsecutive(input)
            && noDoubleExceptEorO(input);
    }

    // 1. 모음 포함 확인
    private static boolean containsVowel(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) return true;
        }
        return false;
    }

    // 2. 모음/자음 3개 연속 X
    private static boolean noThreeConsecutive(String input) {
        int vowelCnt = 0, consonantCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) {
                vowelCnt++;
                consonantCnt = 0;
            } else {
                consonantCnt++;
                vowelCnt = 0;
            }
            if (vowelCnt == 3 || consonantCnt == 3) return false;
        }
        return true;
    }

    // 3. 같은 글자 연속 2번 금지(ee, oo만 예외)
    private static boolean noDoubleExceptEorO(String input) {
        for (int i = 1; i < input.length(); i++) {
            char prev = input.charAt(i - 1);
            char curr = input.charAt(i);
            if (prev == curr && !(prev == 'e' || prev == 'o')) return false;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        for (char v : VOWELS) {
            if (c == v) return true;
        }
        return false;
    }
     */
}
