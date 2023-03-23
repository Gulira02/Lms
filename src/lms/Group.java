package lms;

import enams.Gender;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String groupName;
    private String description;
    private List<Lesson> lessons;
    private List<Person>students;

    public Group(int id, String groupName, String description, List<Lesson> lessons, List<Person> students) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }

    public Group(int id, String groupName, String description, String email, String password, Gender[] values) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
    }

    public Group(){}

    public Group(int id, String groupName, String description) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addStudents(Person people){
        students=new ArrayList<>();
        students.add(people);
    }







    public void deleteGroup(ArrayList<Group> group){
        group=new ArrayList<Group>();
       group.remove(group);
    }

    public void deleteStudents(String student){
        students=new ArrayList<>();
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", lessons=" + lessons +
                ", students=" + students +
                '}';
    }


    public void add(Lesson lesson) {
             lessons.add(lesson);
    }
}
