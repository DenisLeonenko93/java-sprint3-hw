import java.util.Objects;

public class Task {

    protected String title;
    protected String discription;
    protected int id;
    protected Status status;

    public Task(String title, String discription) {
        this.title = title;
        this.discription = discription;
        id = Objects.hash(title, discription);
        status = Status.NEW;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
