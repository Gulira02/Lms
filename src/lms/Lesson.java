package lms;

public class Lesson {
    private  int id;
    private String lessonName;
    private String descriptions;

    public Lesson(int id, String lessonName, String descriptions) {
        this.id = id;
        this.lessonName = lessonName;
        this.descriptions = descriptions;
    }

    public Lesson (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
