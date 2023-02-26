import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class spammer {
    public static ArrayList<String> spamOrNotSpam(ArrayList<String> sentences, ArrayList<String> spamwords) {
        ArrayList<String> list = new ArrayList<String>();

        if (sentences == null || sentences.size() == 0 || spamwords.size() == 0 || spamwords == null) {
            list.add("not_spam");
            return list;
        }

        Map<String, Integer> map = new HashMap<>();
        int flag = 0;
        for (String i : sentences) {
            String[] strArray = i.split(" ");
            for (String j : strArray) {
                for (String k : spamwords) {
                    if (j.toLowerCase().equals(k.toLowerCase()))
                        map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                // count how many words in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                list.add("spam");
            } else
                list.add("not_spam");
            flag = 0;
            map.clear();
        }
        return list;
    }

    public static void main(String args[]) {
        ArrayList<String> sen = new ArrayList<String>();
        sen.add("summertime is coming to do to");
        sen.add("Pay him the money");
        ArrayList<String> spam = new ArrayList<String>();
        spam.add("to");
        spam.add("the");
        spam.add("him");
        System.out.println(spamOrNotSpam(sen, spam));
    }
}
