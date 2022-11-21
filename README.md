# Cloud Computing Lab Exercise

## Explanation
This project contains a Quarkus crud app with only one entity called `Task`.
This entity contains two field named `title` and `content`.
The webapp exposes five different endpoints on port `8080`:
- `GET /tasks` returns all tasks
- `GET /tasks/{taskId}` returns the task with the given id
- `POST /tasks` creates a new task and returns it. The request must have a json body:
  - E.x. `{"title": "MyTaskTitle", "content": "MyContent"}`
- `PUT /tasks/{taskId}` updates the task with the given id and returns it. The request must have a json body similar to that used for the POST request
- `DELETE /tasks/{taskId}` deletes the task with the given id

This app uses hibernate to persist all the instances into a postgres database.
Other comments are written inside `Dockerfile` and `docker-compose.yml`

## Try it
From the root folder:
```shell
docker-compose up -d
curl -X GET http://localhost:8080/tasks # Returns an empty array
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title": "MyTaskTitle", "content": "MyContent"}' # Creates a new task
curl -X GET http://localhost:8080/tasks # Returns an array with one task
curl -X PUT http://localhost:8080/tasks/1 -H "Content-Type: application/json" -d '{"title": "MyTaskTitle", "content": "MyUpdatedContent"}' # Updates the task
curl -X GET http://localhost:8080/tasks/1 # Returns the updated task
docker-compose down

docker-compose up -d # Restart the services (the data is still persisted)
curl -X GET http://localhost:8080/tasks # Returns an array with the updated task
curl -X DELETE http://localhost:8080/tasks/1 # Deletes the task
curl -X GET http://localhost:8080/tasks # Returns an empty array
docker-compose down
```