package hackerRankExercises;

import java.util.*;


class Student1{}
class Rockstar{   }
class Hacker{}


public class JavaInstanceOf{

    static String count(ArrayList mylist){
        int a = 0,b = 0,c = 0;
        for(int i = 0; i < mylist.size(); i++){
            Object element=mylist.get(i);
            if(element instanceof Student1)
                a++;
            if(element instanceof Rockstar)
                b++;
            if(element instanceof Hacker)
                c++;
        }
        String ret = Integer.toString(a)+" "+ Integer.toString(b)+" "+ Integer.toString(c);
        return ret;
    }

    public static void main(String []args){
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            String s=sc.next();
            if(s.equals("hackerRankExercises.Student"))mylist.add(new Student1());
            if(s.equals("hackerRankExercises.Rockstar"))mylist.add(new Rockstar());
            if(s.equals("hackerRankExercises.Hacker"))mylist.add(new Hacker());
        }
        System.out.println(count(mylist));
    }
}