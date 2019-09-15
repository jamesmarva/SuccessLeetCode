package leet801to1000.problem0929;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: SuccessLeetCode
 * @description:
 * @author: James
 * @create: 2019-09-15 14:10
 **/
public class UniqueEmailAddresses0929 {

    public int numUniqueEmails(String[] emails) {
        int lenth = emails.length;
        Set<String> tempResult = new HashSet<String>();
        for (String item : emails) {
            String beforeAt = "";
            int indexPlus = item.indexOf("+");
            if (indexPlus == -1) {
                beforeAt = item.substring(0, item.indexOf("@"));
            } else {
                beforeAt = item.substring(0, indexPlus);
            }
            String temp1 = beforeAt.replace(".", "");
            String afterAt = item.substring(item.indexOf("@"), item.length());
            String temp2 = temp1 + afterAt;
            tempResult.add(temp2);
        }
        return tempResult.size();
    }

}
