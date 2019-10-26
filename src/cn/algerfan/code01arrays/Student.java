package cn.algerfan.code01arrays;

/**
 * @author algerfan
 * @time 2019/8/28 09:32
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("zhang", 77));
        studentArray.addLast(new Student("li", 85));
        studentArray.addLast(new Student("zhao", 94));
        System.out.println(studentArray);
    }

}
