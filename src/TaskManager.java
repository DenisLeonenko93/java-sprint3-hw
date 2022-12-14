import java.util.HashMap;

public class TaskManager {
    private HashMap<Integer, Task> listOfTasks = new HashMap<>();
    private HashMap<Integer, Epic> listOfEpic = new HashMap<>();

    //2.1 Получение списка всех задач.
    public void printTasks(){
        System.out.println(listOfTasks);
    }

    public void printEpics(){
        System.out.println(listOfEpic);
    }

    public void printAllSubtasks(){
        for (Epic epic: getListOfEpic().values()){
            System.out.println(epic.getListOfSubTask());
        }
    }

    public void printSubtasksOfEpic (Epic epic){
        if (epic.getListOfSubTask() == null){
            System.out.println("У данного эпика нет подзадач");
        } else {
            System.out.println(epic.getListOfSubTask());
        }
    }

    public HashMap<Integer, Subtask> getListOfSubtasks (Epic epic){
        return epic.getListOfSubTask();
    }

    public HashMap<Integer, Task> getListOfTasks() {
        return listOfTasks;
    }

    public HashMap<Integer, Epic> getListOfEpic() {
        return listOfEpic;
    }

    // 2.2 Удаление всех задач.
    public void deleteAllTasks(){
        listOfTasks.clear();
        listOfEpic.clear();
    }

    // 2.2 Удаление всех задач. Для задач
    public void deleteTasks(){
        listOfTasks.clear();
    }

    // 2.2 Удаление всех задач. Для эпиков
    public void deleteEpics(){
        listOfEpic.clear();
    }

    // 2.2 Удаление всех задач. Для подзадач
    public void deleteSubtasksOfEpic(Epic epic){
        epic.deleteSubTasks();
    }

    //2.3 Получение по идентификатору. Для задач
    public Task getTask(int id){
        if (listOfTasks.containsKey(id)) {
            return listOfTasks.get(id);
        } else {
            System.out.println("Задачи по указанному id не существует");
            return null;
        }
    }

    //2.3 Получение по идентификатору. Для эпиков
    public Epic getEpic(int id){
        if (listOfEpic.containsKey(id)) {
            return listOfEpic.get(id);
        } else {
            System.out.println("Задачи по указанному id не существует");
            return null;
        }
    }

    //2.3 Получение по идентификатору. Для подзадач
    public Subtask getSubtask(int id){
        for (Epic epic : listOfEpic.values()){
            if (listOfTasks.containsKey(id)) {
                return epic.getListOfSubTask().remove(id);
            } else {
                System.out.println("Задачи по указанному id не существует");
                return null;
            }
        }
        System.out.println("Задачи по указанному id не существует");
        return null;
    }

    //2.4 Создание. Сам объект должен передаваться в качестве параметра. Для задач
    public void createNewTask(Task task){
        listOfTasks.put(task.getId(), task);
    }

    //2.4 Создание. Сам объект должен передаваться в качестве параметра. Для эпиков
    public void createNewEpic(Epic epic){
        listOfEpic.put(epic.getId(), epic);
    }

    //2.4 Создание. Сам объект должен передаваться в качестве параметра. Для подзадач
    public void createNewSubtask(Subtask subtask){
        subtask.getEpic().getListOfSubTask().put(subtask.getId(), subtask);
    }

    //2.5 Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    public void updateTask(Object object){
        if (object instanceof Epic){
            Epic epic = (Epic) object;
            listOfEpic.put(epic.getId(), epic);
        } else if (object instanceof Subtask){
            Subtask subtask = (Subtask) object;
            subtask.getEpic().getListOfSubTask().put(subtask.getId(), subtask);
            subtask.getEpic().checkStatus();
        }else if (object instanceof Task){
            Task task = (Task) object;
            listOfTasks.put(task.getId(), task);
        }
    }

    //2.6 Удаление по идентификатору.Для задач
    public void deleteTask(int id){
        listOfTasks.remove(id);
    }

    //2.6 Удаление по идентификатору.Для эпиков
    public void deleteEpic(int id){
        listOfEpic.remove(id);
    }

    //2.6 Удаление по идентификатору подзадачи. Для подзадач
    public void deleteSubtask(int id){
        for (Epic epic : listOfEpic.values()){
            epic.getListOfSubTask().remove(id);
        }
    }


    @Override
    public String toString() {
        return "TaskManager{" +
                "listOfTasks=" + listOfTasks +
                '}';
    }
}
