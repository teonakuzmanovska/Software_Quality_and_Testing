package hw1;

import hw1.Homework1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Homework1Test {

    @Test
    public void list1IsNull(){
        Homework1 homework1 = new Homework1();

        String[] str2 = {"1","2","3","4","5","2"};
        List<String> list2 = Arrays.asList(str2);

        assertThrows(NullPointerException.class,
                ()->{
                    homework1.commonElements(null, list2);
                });
    }

    @Test
    public void list2IsNull(){
        Homework1 homework1 = new Homework1();

        String[] str1 = {"1","2","3","4","5","2"};
        List<String> list1 = Arrays.asList(str1);

        assertThrows(NullPointerException.class,
                ()->{
                    homework1.commonElements(list1, null);
                });
    }

    @Test
    public void bothListsAreNull(){
        Homework1 homework1 = new Homework1();

        assertThrows(NullPointerException.class,
                ()->{
                    homework1.commonElements(null, null);
                });
    }

    @Test
    public void commonElementsExist(){
        Homework1 homework1 = new Homework1();

        String[] str1 = {"1","2","3","4","5","2"};
        List<String> list1 = Arrays.asList(str1);

        String[] str2 = {"2","4","3","8","9","7"};
        List<String> list2 = Arrays.asList(str2);

        String[] str = {"2","3","4"};
        List<String> list = Arrays.asList(str);


        assertEquals(list, homework1.commonElements(list1, list2));
    }

    @Test
    public void noCommonElementsExist(){
        Homework1 homework1 = new Homework1();

        String[] str1 = {"1","2","3","4","5","2"};
        List<String> list1 = Arrays.asList(str1);

        String[] str2 = {"7","10","11","8","9","20"};
        List<String> list2 = Arrays.asList(str2);

        assertEquals(null, homework1.commonElements(list1, list2));
    }
}