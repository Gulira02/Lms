import enams.Gender;
import exseptions.MyException;
import lms.Group;
import lms.Person;
import service.impl.GroupServiceImp;
import service.impl.PersonServiceImp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalTime localTime= LocalTime.now();
        if(localTime.isAfter(LocalTime.of(6,0,0))&& localTime.isBefore(LocalTime.of(12,0,0))) {
       String []now=localTime.toString().split(":");
            System.out.println("  Kutman tan!  Saat-->"+now[0]+":"+now[1]);
        } else if (localTime.isAfter(LocalTime.of(12,0,0))&& localTime.isBefore(localTime.of(18,0,0))) {
            String []now=localTime.toString().split(":");
            System.out.println("  Kutman kun!  Saat-->"+now[0]+":"+now[1]);
        }
        else {
            String []now=localTime.toString().split(":");
            System.out.println("  Kutman kech!  Saat-->"+now[0]+":"+now[1]);
        }


        myMethod();}
        public static void myMethod() {
        Person person=new Person(1,"Gul","Murzakulova","g@gmail.com","12345678", Gender.FEMALE);
            GroupServiceImp groupService=new GroupServiceImp();

            PersonServiceImp personService=new PersonServiceImp(List.of(person));

            while (true){
                try{
                    System.out.println("Kattalgan bolsonuz 1 basynyz, parol unutup kalyp , " +
                            "ozgortuu uchun 2 basynyz!");
                    int log=new Scanner(System.in).nextInt();
                    switch (log){
                        case 1:
                            if(personService.login().equals("Kosh keldiniz")){
                                System.out.println("Kosh keldiniz");
                                while (true){
                                    System.out.println(
                                                         "Бир команда танданыз! \n"+
                                            "             1  -> Add new group\n" +
                                            "             2  -> GetGroupByName\n" +
                                            "             3  -> Update group name\n" +
                                            "             4  -> Get all groups\n" +
                                            "             5  -> Add new student to group\n" +
                                            "             6  -> Update student\n" +
                                            "             7  -> Find student by first name\n" +
                                            "             8  -> Get all students by group name\n" +
                                            "             9  -> Get all student's lesson\n" +
                                            "             10 -> Delete student\n" +
                                            "             11 -> Add new lesson to group\n" +
                                            "             12 -> Get lesson by name\n" +
                                            "             13 -> Get all lesson by group name\n" +
                                            "             14 -> Delete lesson\n" +
                                            "             15 -> Delete group");
                                    int com=new Scanner(System.in).nextInt();
                                    Group group=new Group();
                                    switch (com){
                                        case 1:
                                            System.out.println(groupService.addNewGroup());
                                            break;
                                        case 2:
                                            System.out.println(groupService.getGroupByName());
                                            break;
                                        case 3:

                                            System.out.println(groupService.updateGroupName());
                                            break;
                                        case 4:
                                            System.out.println(groupService.getAllGroups());
                                            break;
                                        case 5:
                                            System.out.println(groupService.addNewStudentToGroup());
                                            break;
                                        case 6:
                                            System.out.println(groupService.updateStudent());
                                            break;
                                        case 7:
                                            System.out.println(groupService.findStudentByFirstName());
                                            break;
                                        case 8:
                                            System.out.println(groupService.getAllStudentsByGroupName());
                                            break;
                                        case 9:
                                            System.out.println(groupService.getAllStudentsLesson());
                                            break;
                                        case 10:
                                            groupService.deleteStudent();
                                            break;
                                        case 11:
                                            System.out.println(groupService.addNewLessonToGroup());
                                            break;
                                        case 12:
                                            System.out.println(groupService.getLessonByName());
                                            break;
                                        case 13:
                                            System.out.println(groupService.getAllLessonByGroupName());
                                            break;
                                        case 14:
                                            groupService.deleteLesson();
                                            break;
                                        case 15:
                                            groupService.deleteGroup();
                                            break;
                                        default:
                                            System.out.println("Мындай метод жок");

                                    }
                                }
                            }
                            else{
                                throw new MyException("Pochta je parol tuura emes");
                            }
                        case 2: if(personService.resetPassword().equals("Parol saktaldy")){
                            System.out.println("Parol saktaldy");
                            while (true){
                                System.out.println(
                                        "Бир команда танданыз! \n"+
                                                "             1  -> Add new group\n" +
                                                "             2  -> GetGroupByName\n" +
                                                "             3  -> Update group name\n" +
                                                "             4  -> Get all groups\n" +
                                                "             5  -> Add new student to group\n" +
                                                "             6  -> Update student\n" +
                                                "             7  -> Find student by first name\n" +
                                                "             8  -> Get all students by group name\n" +
                                                "             9  -> Get all student's lesson\n" +
                                                "             10 -> Delete student\n" +
                                                "             11 -> Add new lesson to group\n" +
                                                "             12 -> Get lesson by name\n" +
                                                "             13 -> Get all lesson by group name\n" +
                                                "             14 -> Delete lesson\n" +
                                                "             15 -> Delete group");
                                Group group=new Group();
                                int com=new Scanner(System.in).nextInt();
                                switch (com){
                                    case 1:
                                        System.out.println(groupService.addNewGroup());
                                        break;
                                    case 2:
                                        System.out.println(groupService.getGroupByName());
                                        break;
                                    case 3:

                                        System.out.println(groupService.updateGroupName());
                                        break;
                                    case 4:
                                        System.out.println(groupService.getAllGroups());
                                        break;
                                    case 5:
                                        System.out.println(groupService.addNewStudentToGroup());
                                        break;
                                    case 6:
                                        System.out.println(groupService.updateStudent());
                                        break;
                                    case 7:
                                        System.out.println(groupService.findStudentByFirstName());
                                        break;
                                    case 8:
                                        System.out.println(groupService.getAllStudentsByGroupName());
                                        break;
                                    case 9:
                                        System.out.println(groupService.getAllStudentsLesson());
                                        break;
                                    case 10:
                                        groupService.deleteStudent();
                                        break;
                                    case 11:
                                        System.out.println(groupService.addNewLessonToGroup());
                                        break;
                                    case 12:
                                        System.out.println(groupService.getLessonByName());
                                        break;
                                    case 13:
                                        System.out.println(groupService.getAllLessonByGroupName());
                                        break;
                                    case 14:
                                        groupService.deleteLesson();
                                        break;
                                    case 15:
                                        groupService.deleteGroup();
                                        break;

                                }
                            }
                        }
                            else {
                                throw  new MyException("Parol tuura emes");
                        }
                            }

                    }
                catch (MyException e){
                    System.out.println(e.getMessage());
                }
                }
            }


    }
