package com.franklin.assignment12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    public int id;
    public String name;
    public int age;
    public String gender;
    public String engDepartment;
    public int yearOfEnrollment;
    public double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;

    }

    public String getName() {
        return name;
    }
    public int getAge(){
            return age;
    }
    public String getEngDepartment() {
        return engDepartment;
    }

    public String getGender() {
        return gender;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        students.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        students.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        students.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        students.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        students.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        students.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        students.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        students.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        students.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        students.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        students.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        students.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        students.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        students.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        students.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        students.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        //task-1
        System.out.println("\n---Print the name of all departments in the college");
        Map<String, List<Student>> data = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        data.forEach((key,value) ->System.out.println(key));
        //task-2
        System.out.println("\n---Get the names of all students who have enrolled after 2018");
        Stream<Student> data2 = students.stream();
        data2.filter((i)->i.yearOfEnrollment>2018).forEach(i->System.out.println(i.name));
        //task-3
        System.out.println("\n---Get the details of all male student in the computer sci department");
        Stream<Student> data3 = students.stream();
        data3.filter((i)->i.gender=="Male" && i.engDepartment=="Computer Science").forEach(i->System.out.println(i.name));
        //task-4
        System.out.println("\n---How many male and female student are there");
        Map<String, List<Student>> data4 = students.stream().collect(Collectors.groupingBy(Student::getGender));
        data4.forEach((key,value) ->System.out.println(key+":"+value.size()));
        //task-5
        System.out.println("\n---What is the average age of male and female students");
        Map<String, List<Student>> data6 = students.stream().collect(Collectors.groupingBy(Student::getGender));
        IntSummaryStatistics iss1 = data6.get("Male").stream().mapToInt(a->a.age).summaryStatistics();
        IntSummaryStatistics iss2 = data6.get("Female").stream().mapToInt(a->a.age).summaryStatistics();
        System.out.println("Male Avg:"+iss1.getAverage());
        System.out.println("Female Avg:"+iss2.getAverage());
        //task-6
        System.out.println("\n---Get the details of highest student having highest percentage");
        Optional<Student> max = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getPerTillDate)));
        System.out.println("Name: "+max.get().name);
        System.out.println("Age: "+max.get().age);
        System.out.println("Gender: "+max.get().gender);
        System.out.println("Id: "+max.get().id);
        System.out.println("Percentage: "+max.get().perTillDate);
        System.out.println("Department: "+max.get().engDepartment);
        System.out.println("yearOfEnrollment: "+max.get().yearOfEnrollment);
        //task-7
        System.out.println("\n---Count the number of students in each department");
        Map<String, List<Student>> data5 = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        data5.forEach((key,value) ->System.out.println(key+":"+value.size()));
        //task-8
        System.out.println("\n---What is the average age of male and female students");
        Map<String, List<Student>> data7 = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        data7.forEach((key,value)->System.out.println(key+" : "+value.stream().mapToDouble(a->a.perTillDate).summaryStatistics().getAverage()+"%"));
        //task-9
        System.out.println("\n---Get the details of youngest male student in the Electronic department");
        Map<String, List<Student>> data8 = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        Map<String,List<Student>> filteredData = data8.get("Electronic").stream().collect(Collectors.groupingBy(Student::getGender));
        Optional<Student> min = filteredData.get("Male").stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println("Name: "+min.get().name);
        System.out.println("Age: "+min.get().age);
        System.out.println("Gender: "+min.get().gender);
        System.out.println("Id: "+min.get().id);
        System.out.println("Percentage: "+min.get().perTillDate);
        System.out.println("Department: "+min.get().engDepartment);
        System.out.println("yearOfEnrollment: "+min.get().yearOfEnrollment);
        //task-10
        System.out.println("\n---How many male and female students are there in the computer science department");
        Map<String, List<Student>> data9 = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        Map<String,List<Student>> data10 = data8.get("Computer Science").stream().collect(Collectors.groupingBy(Student::getGender));
        data10.forEach((key,value)->System.out.println(key+" : "+value.size()));
    }
}