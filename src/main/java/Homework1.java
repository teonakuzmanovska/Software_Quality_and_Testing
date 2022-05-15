import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Homework1 {
    /**
     * if list1 or list2 is null throw NullPointerException
     * else, return a (non-null) list of elements that are present in both lists
     * else, if there are no such elements return null
     */
    public static List<String> commonElements(List<String> list1, List<String> list2) {
        List<String> resultList = new ArrayList<>();

        if(list1 == null || list2 == null)
            throw new NullPointerException("At least one of the lists is null!");

        else {
            for (String s1 : list1) {
                for (String s2 : list2) {
                    if (s1.equals(s2)){
                        resultList.add(s1);
                    }
                }
            }
            if(!resultList.isEmpty())
                resultList = resultList.stream().distinct().collect(Collectors.toList());
            else
                resultList = null;
        }

        return resultList;
    }
    public static int min(int[] arr){
        int min = arr[0];
        int min_i = 0;
        for (int i=1; i<arr.length-1 ; i++){
            if (arr[i] <= min)
            {
                min = arr[i];
                min_i = i;
            }
        }
        return min_i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,4,2,2,4,5,6,1};
        System.out.println(min(arr));
    }

}
