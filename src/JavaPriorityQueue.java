import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public Double getCgpa() { return cgpa; }
    public int getId() { return id; }
    public String getName() { return name; }
    @Override
    public int compareTo(Student s)
    {
        if(cgpa == s.cgpa)
        {
            if(name.compareTo(s.name) == 0)
            {
                if(id == s.id)
                    return 0;
                else if (id > s.id)
                    return 1;
                else
                    return -1;
            }
            else
                return name.compareTo(s.name);
        }
        else if(cgpa > s.cgpa)
            return -1;
        else
            return 1;
    }
}
class Priorities {

    PriorityQueue<Student> pq = new PriorityQueue<>();

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            //System.out.println(event);
            if (event.startsWith("SERVED")) {
                pq.poll();
            } else if (event.startsWith("ENTER")) {
                String[] s = event.split(" ");
                Student student = new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]));
                pq.add(student);
            }
        }
        List<Student> students = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            students.add(pq.poll());
        }
        return students;
    }
}


public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}