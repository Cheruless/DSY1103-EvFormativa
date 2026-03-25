package cl.duoc.sistematareas.service;

import cl.duoc.sistematareas.model.Task;
import cl.duoc.sistematareas.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    public static boolean saveTask(Task t){
        return TaskRepository.getInstance().save(t);
    }

    public static List<Task> getTasks(){
        return TaskRepository.getInstance().read();
    }

    public static boolean completeTask(boolean status, int id){
        Task t = TaskRepository.getInstance().search(id);
        t.setCompleted(status);
        return TaskRepository.getInstance().update(t);
    }

    public static boolean deleteTask(int id){
        return TaskRepository.getInstance().delete(id);
    }
}
