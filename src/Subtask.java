import java.util.Objects;

public class Subtask extends Task{
    private Epic epic;

    public Subtask(String title, String discription, Epic epic) {
        super(title, discription);
        this.epic = epic;
        id = Objects.hash(title, discription, epic);
        epic.createSubtask(this);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicID=" + epic.getId() +
                ", epicTitle=" + epic.getTitle() +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        epic.checkStatus();
    }
}
