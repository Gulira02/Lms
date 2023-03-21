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
    public Group updateGroupName(Group group) {
        System.out.println("Write name: ");
        String name = new Scanner(System.in).nextLine();
        for (Group group1 : groups) {
            if (group1.getGroupName().equals(name)){
                group1.setId(group.getId());
                group1.setGroupName(group.getGroupName());
                group1.setDescription(group.getDescription());
            }
        }
        return group;

    }


/*    public Group updateGroupName(Group group) {
        System.out.println("Write name: ");
        String name = new Scanner(System.in).nextLine();
        for (Group group1 : groups) {
            if (group1.getGroupName().equals(name)){
                group1.setId(group.getId());
                group1.setGroupName(group.getGroupName());
                group1.setDescription(group.getDescription());
            }
        }
        return group;
    }*/

/*    @Override
    public Group updateGroupName() {
        System.out.println("Write name: ");
        String name = new Scanner(System.in).nextLine();
        Group group =new Group();

        for (Group g : groups) {
            if (g.getGroupName().toUpperCase().equals(name.toUpperCase())) {
                group.setGroupName(name);
                group=g;
             //  return  group.getGroupName();
            } else {
                System.out.println("Myndai gruppa jok");
            }

        }
        return null;
    }*/

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public String addNewStudentToGroup() {
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
            Person person = new Person(id, studName, fullName, email, password, Gender.valueOf(gender.toUpperCase()));
            people.add(person);
            System.out.println("Grupanyn atyn jaz");
            String grupName = new Scanner(System.in).nextLine();
            for (Group group1 : groups) {
                if (group1.getGroupName().equals(grupName)) {
                    group1.setStudents((people));
                } else {
                    System.out.println("Myndai gr jok");
                }
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
        //gruppanyn aty menen studentterdin spisogun al
     /*public List<Student> getAllStudentsByGroupName(String groupName) {
    List<Student> students = new ArrayList<>();
    for (Group group : groups) { // assuming 'groups' is a list of Group objects
        if (group.getName().equals(groupName)) {
            students.addAll(group.getStudents());
        }
    }
    return students;*/
        List <Person>students=new ArrayList<>();
       try{ Group group=new Group();

           System.out.println("Gruppanyn atyn jaz ");
           String groupName=new Scanner(System.in).nextLine();
        for (Group group1 : groups) {
            if (group.getGroupName().equals(groupName)){
                students.addAll(group1.getStudents());
            }
            else {throw new MyException("Бул группада мындай студенттер жок");}
        }}
       catch (MyException e){
           System.out.println(e.getMessage());
       }

        return students.toString();
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
            System.out.println("Gruppanyn atyn jazynyz");
            String groupName = new Scanner(System.in).nextLine();
           System.out.println("Write ID");
           int id = new Scanner(System.in).nextInt();
        for (Group group : groups) {
            if (group.getId() == (id)) {
               // groups.remove(groupName);
                groups.remove(group);
                System.out.println(group +" Ochtu");
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








