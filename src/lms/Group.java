import java.util.List;

public class Group {
    private int id;
    private String groupName;
    private List<Lesson> lessons;
    private List<Person> students;

    public Group(int id, String groupName, List<Lesson> lessons, List<Person> students) {
        this.id = id;
        this.groupName = groupName;
        this.lessons = lessons;
        this.students = students;
    }
    public Group(){}

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

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", lessons=" + lessons +
                ", students=" + students +
                '}';
    }
}
