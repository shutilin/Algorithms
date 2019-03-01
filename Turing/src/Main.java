public class Main {

    public static void main(String[] args) {

//        String word1 = "__|||__________";
        String word1 = "_____abcbcb_______";
        char[] word = word1.toCharArray();

        System.out.println(word);

//        String[][][] conditions = {
//                {{"|R_1"}, {"aR_6"}, {"_R_0"}},
//                {{"|R|1"}, {"_Ra2"}, {"aRa2"}},
//                {{"|R|2"}, {"_R|3"}},
//                {{"_L|4"}},
//                {{"|L|4"}, {"aLa4"}, {"_R_0"}}
//        };

        String[][][] conditions = {
                {{"_R_0"}, {"aRa1"}, {"bRb1"}, {"cRc1"}},
                {{"_R_E"}, {"aRa2"}, {"bRb2"}, {"cRc2"}},
                {{"_L_3"}, {"aRa1"}, {"bRb1"}, {"cRc1"}},
                {{"aLA4"}, {"bLB4"}, {"cLC4"}, {"ALa7"}, {"BLb7"}, {"CLc7"}}, //4
                {{"_R_5"}, {"aLa4"}, {"bLb4"}, {"cLc4"}, {"ARA5"}, {"BRB5"}, {"CRC5"}}, //5
                {{"aRA6"}, {"bRB6"}, {"cRC6"}},
                {{"aRa6"}, {"bRb6"}, {"cRc6"}, {"ALA3"}, {"BLB3"}, {"CLC3"}},
                {{"ALa7"}, {"BLb7"}, {"CLc7"}, {"_R_8"}},
                {{"aRa8"}, {"bRb8"}, {"cRc8"}, {"AR_8"}, {"BR_8"}, {"CR_8"}, {"_R_9"}}
        };

        System.out.println(conditions.length);

        int step = 0;
        int i = 0;
        while(step != 9) {
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
