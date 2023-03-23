package service.impl;

import enams.Gender;
import exseptions.MyException;
import lms.Group;
import lms.Lesson;
import lms.Person;
import service.GroupService;

import java.util.*;

public class GroupServiceImp implements GroupService {
    private List<Group> groups = new ArrayList<>();


    @Override
    public String addNewGroup() {//1
        System.out.println("Jany gruppaga at jazynyz: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Gruppaga opisanie jazynyz: ");
        String description = new Scanner(System.in).nextLine();
        Group group = new Group(groups.size() + 1, name, description, new LinkedList<Lesson>(),
                new LinkedList<Person>());
        groups.add(group);
        System.out.println(group.toString());
        return name + "атту группа ийгиликтуу сакталды!.";
    }

    @Override
    public Group getGroupByName() {//2
        Group group1 = new Group();
        try {
            System.out.println("Write name group: ");
            String name = new Scanner(System.in).nextLine();

            for (Group group : groups) {
                if (group.getGroupName().equals(name)) {
                    group1 = group;
                } else {
                    throw new MyException("Myndai at jok");
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return group1;
    }


    @Override
    public Group updateGroupName() {//3
        System.out.println("Gruppanyn atyn Jazynyz: ");
        String groupName = new Scanner(System.in).nextLine();
        for (Group group1 : groups) {
            for (Group group : groups) {
                if (group1.equals(group)) {
                    group1.setGroupName(groupName);
                }
            }
            return group1;
        }
        return null;
    }


    @Override
    public List<Group> getAllGroups() {//4
        return groups;
    }

    @Override
    public String addNewStudentToGroup() {//5
        System.out.println("ID номерин жазыныз: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Атын жазыныз: ");
        String studName = new Scanner(System.in).nextLine();
        System.out.println("Фамилиясын жазыныз: ");
        String fullName = new Scanner(System.in).nextLine();
        System.out.println("email почтасын жазыныз: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Студентке парол бериниз");
        String password = new Scanner(System.in).nextLine();
        System.out.println("Студенттин полун жазыныз");
        String gender = new Scanner(System.in).nextLine();
        Person person = new Person(id, studName, fullName, email, password, Gender.valueOf(gender));

        System.out.println("Grupanyn atyn jaz");
        String grupName = new Scanner(System.in).nextLine();
        for (Group group1 : groups) {
            if (group1.getGroupName().equals(grupName)) {
                group1.addStudents(person);
            } else {
                System.out.println("Myndai gr jok");
            }
        }
        return "Группага жаны студент кошулду";
    }


    @Override
    public Person updateStudent() {//6
        try {
            System.out.println("Studenttin murunku atyn jazynyz: ");
            String firstName = new Scanner(System.in).nextLine();
            System.out.println("Studenttin jany atyn jazynyz: ");
            String studName = new Scanner(System.in).nextLine();
            for (Group group : groups) {
                for (Person person : group.getStudents()) {
                    if (person.getName().equals(firstName)) {
                        person.setName(studName);
                        return person;
                    } else {
                        throw new MyException("Атыныз озгортулгон жок");
                    }
                }


            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Person findStudentByFirstName() {//7
        System.out.println("Write name students: ");
        String firstName = new Scanner(System.in).nextLine();
        Person person = new Person();
        for (Group group : groups) {
            for (Person student : group.getStudents()) {
                if (student.getName().equals(firstName)) {
                    person = student;
                } else {
                    System.out.println("Myndai student jok");
                }
            }
        }
        return person;
    }


    @Override
    public List<Person> getAllStudentsByGroupName() {//8
        System.out.println("Write group name ");
        String groupName = new Scanner(System.in).nextLine();
        List<Person> students = new ArrayList<>();
        for (Group group : groups) {
            if (group.getGroupName().equals(groupName)) {
                students.addAll(group.getStudents());
            }
        }
        return students;
    }


    @Override
    public List<Lesson> getAllStudentsLesson() {//9
        //Studenttin atyn jazganda sabaktary chygat
        System.out.println("Gruppanyn atyn jazynyz");
        String groupName = new Scanner(System.in).nextLine();
        System.out.println("Write student name ");
        String studentName = new Scanner(System.in).nextLine();

        List<Lesson> lessonList = new ArrayList<>();
        for (Group group:groups) {
        if (group.getGroupName().equals(groupName)) {
            for (Lesson lesson:group.getLessons()) {
                if (group.getStudents().equals(studentName)) {
                   return Collections.singletonList(lesson);
            }

        }}}



        return lessonList;
    }


    @Override
    public void deleteStudent() {//10
        System.out.println("Write student name");
        String studentName = new Scanner(System.in).nextLine();
        for (Group group : groups) {
            for (Person person : group.getStudents()) {
                if (person.getName().equals(studentName)) {
                    group.getStudents().remove(person);
                    System.out.println(studentName + "Ochtu");
                } else {
                    System.out.println("Ochkon jok");
                }
            }
        }
    }


    @Override
    public String addNewLessonToGroup() {//11
        System.out.println("Write id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Write name: ");
        String lesName = new Scanner(System.in).nextLine();
        System.out.println("Write description: ");
        String description = new Scanner(System.in).nextLine();
        Lesson lesson = new Lesson(id, lesName, description);
        System.out.println("Write name group:");
        String groupName = new Scanner(System.in).nextLine();
        for (Group group : groups) {
            if (group.getGroupName().equals(groupName)) {
                group.add(lesson);
            } else {
                System.out.println("Sabak koshulgan jok");
            }
        }


        return "Gruppaga sabak koshuldu";
    }

    @Override
    public List<Lesson> getLessonByName() {//12
        System.out.println("Write name lesson: ");
        String lesName = new Scanner(System.in).nextLine();
        List<Lesson> lessonName = new ArrayList<>();
        for (Group group:groups) {
            for (Lesson lesson :group.getLessons()) {
                if(lesson.getLessonName().equals(lesName)){
                     lessonName= Collections.singletonList(lesson);
                     return lessonName;
                }
            }

        }
        return lessonName;
        }





        @Override
        public List<Lesson> getAllLessonByGroupName () {//13
            List<Lesson> lessonList = new ArrayList<>();
            try {
                System.out.println("Write  name: ");
                String name = new Scanner(System.in).nextLine();
                for (Group group1 : groups) {
                    if (group1.getGroupName().equals(name)) {
                        lessonList = group1.getLessons();
                    }
                    throw new MyException("Бул группада мындай студенттер жок");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

            return lessonList;

        }


        @Override
        public void deleteLesson () {//14
            System.out.println("Write name");
            String lesn = new Scanner(System.in).nextLine();
            for (Group group:groups) {
                for (Lesson les : group.getLessons()) {
                   if(les.getLessonName().equals(lesn)){
                       group.getLessons().remove(les);
                       System.out.println(les+" Ochtu");
                   }
                   else{
                       System.out.println("Ochkon jok");
                   }
                }

            }
        }

        @Override
        public void deleteGroup () {//15
            try {
                System.out.println("Gruppanyn atyn jazynyz");
                String groupName = new Scanner(System.in).nextLine();
                for (Group group : groups) {
                    if (group.getGroupName().equals (groupName)) {
                         groups.remove(group);
                        System.out.println(group + " Ochtu");
                    } else {
                        throw new MyException("Mындай группа табылган жок");
                    }
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }}











