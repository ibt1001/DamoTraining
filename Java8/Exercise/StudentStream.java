package Java8.Exercise;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStream {
    private static List<Student> register(){
        Student s1 = new Student(1L,"zhanghanwen",Student.Gender.FEMALE,100, LocalDate.of(2018, Month.SEPTEMBER,1),Student.Department.AM);
        Student s2 = new Student(2L,"fanghanwen",Student.Gender.FEMALE,80, LocalDate.of(2018, Month.SEPTEMBER,1),Student.Department.CL);
        Student s3 = new Student(3L,"gonghanwen",Student.Gender.FEMALE,10, LocalDate.of(2018, Month.SEPTEMBER,1),Student.Department.CN);
        Student s4 = new Student(4L,"liuhanwen",Student.Gender.FEMALE,90, LocalDate.of(2018, Month.SEPTEMBER,1),Student.Department.EE);
        return Arrays.asList(s1,s2,s3,s4);
    }
    private static void o(Object o){
        System.out.println(o);
    }
    private static void oo(String prex,Object o){
        System.out.println(prex+o);
    }
    public static void main(String[] args) {
        List<Student> students = register();
        Stream<Student> studentStream = students.stream();//流不能反复使用
        o(students);
        //total number of students
        long studentCount = students.stream().count();
        long studentCount1 = students.stream().mapToInt(s->1).sum();
        oo("Total number of students is : ",studentCount);
        oo("Total number of students is : ",studentCount1);
        //total credits
        int totalCredits = studentStream.mapToInt(s->s.getCredit()).sum();
        oo("Total credits of students is : ",totalCredits);
        //tatal gender of students
        Map<Student.Gender,Long> group = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
        oo("Student group by gender is : ",group);
        //Student with Best credits
        Optional<Student> studentmax = students.stream()
                .max((s1,s2)->s1.getCredit()-s2.getCredit());//升序排列，max取队列最后端的值，min取队列最前端的值
        if(studentmax.isPresent()){
            oo("Student with max credit is : ",studentmax.get().getName());
        }else {
            o("Error");
        }
        //Sum of credits
        Integer sumCredits = students.stream()
                .reduce(0,(Integer partialSum,Student student)->{
                    Integer middlesum = partialSum+student.getCredit();
                    return middlesum;
                },(a,b)->{return null;});//因为Integer Student类不兼容，故得采取BinaryOperator来解决
        oo("The sum credits is : ",sumCredits);
        boolean allMale = students.stream().allMatch(Student::isFemale);
        oo("Is all studens male : ",allMale);
        boolean anyFemale = students.stream().anyMatch(Student::isFemale);
        oo("Is any students female : ",anyFemale);
        LongSummaryStatistics creditStats = students.stream().map(Student::getCredit)//LongSummaryStatistics是一个包含了得到平均值、最大值、最小值等的组合运算类
                .collect(LongSummaryStatistics::new,
                        LongSummaryStatistics::accept,
                        LongSummaryStatistics::combine);
        oo("Credit Stats : ",creditStats);
        LongSummaryStatistics creditStats2 = students.stream().collect(Collectors.summarizingLong(Student::getCredit));//collect 与Collects联系
        oo("Credit Stats: ",creditStats2);
        Double creditAvg = students.stream().collect(Collectors.averagingDouble(Student::getCredit));
        oo("Credit Average: ",creditAvg);
        Map<Long,String> idNameMap = students.stream().collect(Collectors.toMap(Student::getId,Student::getName));
        oo("<Id,Name>: ",idNameMap);
        Map<Student.Department,String> departmentNameMap = students.stream().collect(Collectors.toMap(Student::getDepartment,Student::getName));
        oo("<department,Name>: ",departmentNameMap);

        String names = students.stream().map(Student::getName).collect(Collectors.joining(",","XUPT-NetWork[","]"));
        o(names);
        Optional<Student> hasFemale = students.stream().filter(Student::isFemale).findAny();
        if(hasFemale.isPresent()){
            oo("Yes, we have female students: ",hasFemale.get().getName());
        }else{
            o("Sorry, we have no female students");
        }

















    }
}
