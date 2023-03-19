package service.impl;

import enams.Gender;
import exseptions.MyException;
import lms.Group;
import lms.Lesson;
import lms.Person;
import service.GroupService;

import java.util.*;

public class GroupServiceImp implements GroupService {
    private List<Group>groups=new ArrayList<>();
    private List<Lesson> lessons=new ArrayList<>();
    private List<Person> people=new ArrayList<>();


    @Override
    public String addNewGroup() {
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
    public Group getGroupByName() {
        Group group1 = new Group();
        try{
        System.out.println("Write name: ");
        String name = new Scanner(System.in).nextLine();

        for (Group group : groups) {
            if (group.getGroupName().equals(name)) {
                group1 = group;
            } else {
                throw  new MyException("Myndai at jok");
            }
        }
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        return group1;}





    @Override
    public Group updateGroupName() {
        System.out.println("Write name: ");
        String name = new Scanner(System.in).nextLine();
        Group group1 = new Group();
        for (Group group : groups) {
            if (group.getGroupName().equals(name)) {
                group.setGroupName(name);
                group1 = group;
            } else {
                System.out.println("Myndai gruppa jok");
            }

        }
        return group1;
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public String addNewStudentToGroup() {
        try{
        System.out.println("ID номерин жазыныз: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Атын жазыныз: ");
        String studName = new Scanner(System.in).nextLine();
        System.out.println("Фамилиясын жазыныз: ");
        String fullName = new Scanner(System.in).nextLine();
        System.out.println("email почтасын жазыныз: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Студентке парол бериниз");
       String password=new Scanner(System.in).nextLine();
        System.out.println("Студенттин полун жазыныз");
        String gender=new Scanner(System.in).nextLine();
        Person person=new Person(id,studName,fullName,email,password,Gender.valueOf(gender));
        for (Group group1 : groups) {
            group1.setGroupName(Collections.singletonList(person).toString());
        }
        throw  new MyException("Туура эмес мааымат киргиздиниз");
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        return "Группага жаны студент кошулду";
    }

    @Override
    public Person updateStudent() {
        Person person=new Person();
        try{
        System.out.println("Write name: ");
        String studName = new Scanner(System.in).nextLine();


        for (Person student : people) {
            if(student.getName().equals(studName)){
                student.setName(studName);
            person=student;
        }
        else {
            throw  new MyException("Атыныз озгортулгон жок");
        }
        }
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }


        return  person;
        }




    @Override
    public void findStudentByFirstName() {
        System.out.println("Write name: ");
        String firstName = new Scanner(System.in).nextLine();
        for (Person student : people) {
            if (student.getName().equalsIgnoreCase(firstName)) {
                System.out.println(student);
            } else {
                System.out.println("Myndai student jok");
            }

        }
    }

    @Override
    public String getAllStudentsByGroupName() {

       try{ Group group=new Group();
        for (Group group1 : groups) {
            if (group.getGroupName().equals(group.getStudents())) {
                return group.getStudents().toString();
            }
            else {throw new MyException("Бул группада мындай студенттер жок");}
        }}
       catch (MyException e){
           System.out.println(e.getMessage());
       }

        return "Группада бул студенттер бар";
    }

    @Override
    public List<Lesson> getAllStudentsLesson() {
        for (Group group : groups) {
            if (group.getStudents().equals(group.getLessons())) {
                return group.getLessons();
            }
        }

        return null;
    }

    @Override
    public void deleteStudent() {
        System.out.println("Write ID");
        int student = new Scanner(System.in).nextInt();
        for (Person person : people) {
            if (person.getId() == (student)) {
                people.remove(person);
                System.out.println("Ochtu");
            }
        }


    }

    @Override
    public String addNewLessonToGroup() {
        System.out.println("Write id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Write name: ");
        String lesName = new Scanner(System.in).nextLine();
        System.out.println("Write description: ");
        String description = new Scanner(System.in).nextLine();
        Lesson lesson = new Lesson(id, lesName, description);

        for (Group group : groups) {
            group.setLessons(Collections.singletonList(lesson));
        }


        return "Gruppaga sabak koshuldu";
    }

    @Override
    public Lesson getLessonByName() {
        System.out.println("Write name: ");
        String lesName = new Scanner(System.in).nextLine();
        Lesson less = new Lesson();
        for (Lesson lesson : lessons) {
            if (lesson.getLessonName().equals(lesName)) {
                less = lesson;
            } else {
                System.out.println("Myndai sabak jok");
            }

        }

        return less;
    }

    @Override
    public List<Lesson> getAllLessonByGroupName() {

        List <Lesson>lessonList=new ArrayList<>();
        try{
            System.out.println("Write  name: ");
            String name=new Scanner(System.in).nextLine();
            for (Group group1 : groups) {
                if (group1.getGroupName().equals(name)) {
                    lessonList=group1.getLessons();

                }
                throw new MyException("Бул группада мындай студенттер жок");}
            }
        catch (MyException e){
            System.out.println(e.getMessage());
        }

        return lessonList;

    }


    @Override
    public void deleteLesson() {
        System.out.println("Write ID");
        int lesn = new Scanner(System.in).nextInt();
        for (Lesson lesson1 : lessons) {
            if (lesson1.getId() == (lesn)) {
                lessons.remove(lesson1);
                System.out.println("Ochtu");
            }
        }
    }

    @Override
    public void deleteGroup() {
        try{
        System.out.println("Write ID");
        int id = new Scanner(System.in).nextInt();
        for (Group group : groups) {
            if (group.getId() == (id)) {
                groups.remove(group);
                System.out.println("Ochtu");
            }
            else{
            throw new MyException("Mындай группа табылган жок");
            }
        }}
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        }
    }








