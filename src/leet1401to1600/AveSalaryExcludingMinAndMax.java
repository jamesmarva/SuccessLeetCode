package leet1401to1600.problem1491;



public class AveSalaryExcludingMinAndMax {

    public double average(int[] salary) {
        int min = 0;
        int max = 0;
        int count = 0;
        double ans = 0.0;
        for (int i = 0, len = salary.length; i < len; i++) {
            if ( i == 0) {
                min = salary[i];
                continue;
            } 
            if (i == 1) {
                if (min < salary[i])  {
                    max = salary[i];
                } else {
                    max = min;
                    min = salary[i];
                }
                continue;
            }
            
            if (salary[i] < min) {
                ans = ans + (min - ans) * 1.0 / (++count);
                min = salary[i];
            } else if (salary[i] > max) {
                ans = ans + (max - ans) * 1.0 / (++count);
                max = salary[i];
            } else {
                ans = ans + (salary[i] - ans) * 1.0 / (++count);
            }
        }
        return ans;
    }
}


