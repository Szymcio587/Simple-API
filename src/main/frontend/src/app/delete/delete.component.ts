import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent {
  id: number = 0;

  constructor(private router: Router, private taskService: TaskService) {}

  DeleteTask(id: number): void {
    this.taskService.DeleteEntity(id).subscribe(() => {
        console.log('Entity deleted successfully.');
      });

    this.router.navigate(['']);
  }

  GoBack(): void {
    this.router.navigate(['']);
  }
}
