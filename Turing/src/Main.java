public class Main {

    public static void main(String[] args) {

        String word1 = "__|||__________";
        char[] word = word1.toCharArray();

        System.out.println(word);

        String[][][] conditions = {
                {{"|R_1"}, {"aR_6"}, {"_R_0"}},
                {{"|R|1"}, {"_Ra2"}, {"aRa2"}},
                {{"|R|2"}, {"_R|3"}},
                {{"_L|4"}},
                {{"|L|4"}, {"aLa4"}, {"_R_0"}}
        };

        System.out.println(conditions.length);

        int step = 0;
        int i = 0;
        while(step != 6) {
            for (int j = 0; j < conditions[step].length; j++) {
                char[] act = conditions[step][j][0].toCharArray();

                if (word[i] == act[0]) {
                    word[i] = act[2];
                    if (act[1] == 'R') {
                        i++;
                    }
                    if (act[1] == 'L') {
                        i--;
                    }
                    step = Character.getNumericValue(act[3]);
                    System.out.println(step);
                    System.out.println(word);
                    break;
                }
            }
        }


    }
}
