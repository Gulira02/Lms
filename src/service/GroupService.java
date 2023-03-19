package service;

import lms.Group;
import lms.Lesson;
import lms.Person;

import java.util.List;

public interface GroupService {
    String addNewGroup();    // 1 Добавить новую группу

    Group getGroupByName();   // 2 Получить группу по названию

    Group updateGroupName(); //3 Обновить название группы

    List<Group> getAllGroups();      //4 Получить все группы

    String addNewStudentToGroup();   //5 Добавить нового ученика в группу

    Person updateStudent();    //6 Обновить студента

    void findStudentByFirstName();    //7 Найти студента по имени

    String getAllStudentsByGroupName();    //8 Получить всех студентов по названию группы

    List<Lesson> getAllStudentsLesson();    // 9 Получите весь урок ученика

    void  deleteStudent();      // 10 Удалить ученика

     String addNewLessonToGroup(); // 11 Добавить новый урок в группу

   Lesson getLessonByName(); // 12 Получить урок по названию

    List<Lesson> getAllLessonByGroupName(); //13 Получить весь урок по названию группы

     void deleteLesson(); // 14 Удалить урок

    void deleteGroup();// 15 Удалить группу

}
