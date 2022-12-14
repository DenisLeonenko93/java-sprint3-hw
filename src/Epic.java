import java.util.HashMap;

public class Epic extends Task{
    private HashMap<Integer, Subtask> listOfSubTask;

    public Epic(String title, String discription) {
        super(title, discription);
        listOfSubTask = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Epic{" +
                "title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", amountSubtask=" + listOfSubTask.size() +
                '}';
    }

    public HashMap<Integer, Subtask> getListOfSubTask() {
        return listOfSubTask;
    }

    public void createSubtask(Subtask subtask){
        listOfSubTask.put(subtask.getId(), subtask);
    }

    public void deleteSubTasks(){
        listOfSubTask.clear();
    }

    public void checkStatus(){
        int amountDone = 0;
        for (Subtask subtask : listOfSubTask.values()){
            if (subtask.getStatus().equals(Status.IN_PROGRESS)){
                status = Status.IN_PROGRESS;
                break;
            } else if (subtask.getStatus().equals(Status.DONE)) {
                amountDone++;
            }
        }
        if (amountDone == listOfSubTask.size()){
            status = Status.DONE;
        } else if (amountDone >= 1) {
            status = Status.IN_PROGRESS;
        }
    }
}
