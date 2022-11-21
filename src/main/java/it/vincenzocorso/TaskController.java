package it.vincenzocorso;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {
    @GET
    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    @GET
    @Path("/{taskId}")
    public Task getTask(@PathParam("taskId") Long taskId) {
        return Task.findById(taskId);
    }

    @POST
    @Transactional
    public Task createTask(Task task) {
        task.persist();
        return task;
    }

    @PUT
    @Path("/{taskId}")
    @Transactional
    public Task updateTask(@PathParam("taskId") Long taskId, Task updatedTask) {
        Task task = Task.findById(taskId);
        task.title = updatedTask.title;
        task.content = updatedTask.content;
        task.persist();
        return task;
    }

    @DELETE
    @Path("/{taskId}")
    @Transactional
    public void deleteTask(@PathParam("taskId") Long taskId) {
        Task.deleteById(taskId);
    }
}
