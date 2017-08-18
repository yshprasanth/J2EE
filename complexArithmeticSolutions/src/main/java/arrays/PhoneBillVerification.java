package arrays;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneBillVerification {

    public static void main(String[] args) {
        String s = "00:01:07,400-234-090\n" +
                    "00:05:01,701-080-080\n" +
                    "00:05:00,400-234-090";
        int value = solution(s);
    }

    private static int solution(String s) {
        String[] str = s.split("\n");
        int size = str.length;

        HashMap<String, Long> timeMap = new HashMap<>();
        HashMap<String, Long> priceMap = new HashMap<>();

        long maxCallTime = 0;
        String maxCallphoneNumber = null;

        for(int index = 0; index<size; index++) {
            String[] arr = str[index].split(",");
            String phoneNumber = arr[1];
            Long[] timeAndPrice = parseTime(arr[0]);

            Long totalCallTime = 0L;
            if(timeMap.containsKey(phoneNumber)) {
                Long currentValue = timeMap.get(phoneNumber);
                totalCallTime = currentValue + timeAndPrice[0];
            } else {
                totalCallTime = timeAndPrice[0];
            }

            if(totalCallTime>maxCallTime) {
                maxCallTime=totalCallTime;
                maxCallphoneNumber = phoneNumber;
            }
            timeMap.put(phoneNumber, totalCallTime);

            if(priceMap.containsKey(phoneNumber)) {
                Long currentValue = priceMap.get(phoneNumber);
                priceMap.put(phoneNumber, currentValue + timeAndPrice[1]);
            } else {
                priceMap.put(phoneNumber, timeAndPrice[1]);
            }



        }
        int totalTime = 0;
        for(String phoneNumber: priceMap.keySet() ) {
            if(!phoneNumber.equals(maxCallphoneNumber)) {
                totalTime += priceMap.get(phoneNumber);
            }
        }

        return totalTime;
    }

    private static Long[] parseTime(String str) {
        String[] time = str.split(":");
        long totalTime = 0;
        long price;
        totalTime += (Integer.parseInt(time[0])*60);
        totalTime += (Integer.parseInt(time[1]));
        int seconds = Integer.parseInt(time[2]);
        if(totalTime>=5) {
            if (seconds>0) {
                price = (totalTime+1) * 150;
                totalTime = (totalTime * 60) + seconds; // convert to seconds for the sake of identifying the larger call
            } else {
                totalTime = totalTime * 60;
                price = totalTime * 3;
            }

        } else {
            totalTime *= 60; // convert to seconds
            totalTime += seconds;
            price = totalTime * 3;

        }
        totalTime += (Integer.parseInt(time[0])*60);

        Long[] result = new Long[2];
        result[0] = totalTime; //in seconds
        result[1] = price;

        return result;
    }


}
