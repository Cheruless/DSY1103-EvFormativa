package cl.duoc.sistematareas.controller;

import cl.duoc.sistematareas.model.Task;
import cl.duoc.sistematareas.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/tareas")
public class TaskController {
    @GetMapping
    public ResponseEntity<List<Task>> obtenerTareas(){
        return ResponseEntity.status(HttpStatus.OK).body(TaskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<Boolean> crearTarea(@RequestBody Task tareaNueva){
        return (TaskService.saveTask(tareaNueva)) ? ResponseEntity.status(HttpStatus.CREATED).body(true)
                : ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(false);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarTarea(@PathVariable int id){
        return (TaskService.deleteTask(id)) ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(true)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> actualizarTarea(@PathVariable int id, @RequestParam("estado") boolean estado){
        return (TaskService.completeTask(estado, id)) ? ResponseEntity.status(HttpStatus.OK).body(true)
                : ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
    }
}
