package crud.crud.service;

import crud.crud.dto.TaskDTO;
import crud.crud.entity.Todos;
import crud.crud.repository.TodosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodosRepository tasksRepository;

    public TodoService() { }

    public List<Todos> getTasks() {
        return tasksRepository.findAll();
    }

    public Todos getTask(String taskId) {
        Optional<Todos> task = tasksRepository.findById(taskId);
        return task.get();
    }

    public Todos saveTask(TaskDTO taskDTO) {
        System.out.println(taskDTO.toString());
        ModelMapper modelMapper = new ModelMapper();
        System.out.println("En el servicio");
        System.out.println(modelMapper);
        Todos task = modelMapper.map(taskDTO, Todos.class);
        System.out.println(task.toString());
        return tasksRepository.save(task);
    }

    public Todos updateTask(TaskDTO taskDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Todos task = modelMapper.map(taskDTO, Todos.class);
        return tasksRepository.save(task);
    }

    public String deleteTask(String taskId) {
        tasksRepository.deleteById(taskId);
        return taskId;
    }
}