import { Component, OnInit } from '@angular/core';
import { Task } from '../../classes/task';
import { TaskService } from '../../services/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent{

  task = new Task();
  tasks: Task[];
  submitted = false;
  processing = false;

  constructor(private taskService: TaskService) { }

  newTask(): void {
    this.submitted = false;
    this.processing = false;
    this.task = new Task();
  }
 
  addTask() {
    this.submitted = true;
    this.taskService.addTask(this.task)
    .subscribe();
  }
 
  processTasks(){
    this.processing = true;
    return this.taskService.getTasks()
                .subscribe(
                  tasks => {
                    console.log(tasks);
                    this.tasks = tasks;
                  }
                );
  }

}
