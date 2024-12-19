
import UDP.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//import vn.medianews.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class NewClass {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
//        ls.sort( new Comparator<Integer>() {
//            public int compare(Integer x, Integer y) {
//                return x - y;
//            }
//        });
        
        ls.add(1);
        ls.add(1);
        ls.add(3);
        ls.add(5);
        ls.sort( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        } );
        
        Student student = new Student();
        System.out.println(student);
        
//        System.out.println(ls);
    }
}
