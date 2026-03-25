package cl.duoc.sistematareas.repository;

import cl.duoc.sistematareas.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private static TaskRepository instance;
    private final List<Task> taskList;
    private int idGiver;

    private TaskRepository(){
        taskList = new ArrayList<>();
        idGiver = 0;
    }

    public static TaskRepository getInstance(){
        if (instance == null)
            instance = new TaskRepository();
        return instance;
    }

    // Métodos

    public boolean save(Task t){
        t.setId(idGiver);
        idGiver++;
        return taskList.add(t);
    }

    public List<Task> read(){
        return taskList;
    }

    //No puedo usar search porque necesito la posición del objeto en la lista.
    public boolean update(Task t){
        for (int i = 0; i < taskList.size(); i++)
            if (t.getId() == taskList.get(i).getId()) {
                taskList.set(i, t);
                return true;
            }
        return false;
    }

    public boolean delete(int id){
        return taskList.remove(search(id));
    }

    public Task search(int id){
        for (Task t : taskList)
            if (t.getId() == id)
                return t;
        return null;
    }
}
