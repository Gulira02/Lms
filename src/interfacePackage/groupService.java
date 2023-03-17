package interfacePackage;

import lms.Group;
import lms.Lesson;
import lms.Person;

import java.util.ArrayList;
import java.util.List;

public class groupService  implements groupAble{
    private List<Group>groups=new ArrayList<>();

    public groupService(List<Group>groups){
        this.groups=groups;
    }
    @Override
    public String addNewGroup() {
        return null;
    }

    @Override
    public Group getGroupByName() {
        return null;
    }

    @Override
    public Group updateGroupName() {
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return null;
    }

    @Override
    public String addNewStudentToGroup() {
        return null;
    }

    @Override
    public Person updateStudent() {
        return null;
    }

    @Override
    public void findStudentByFirstName() {

    }

    @Override
    public String getAllStudentsByGroupName() {
        return null;
    }

    @Override
    public List<Lesson> getAllStudentsLesson() {
        return null;
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public String addNewLessonToGroup() {
        return null;
    }

    @Override
    public Lesson getLessonByName() {
        return null;
    }

    @Override
    public List<Lesson> getAllLessonByGroupName() {
        return null;
    }

    @Override
    public void deleteLesson() {

    }

    @Override
    public void deleteGroup() {

    }
}
