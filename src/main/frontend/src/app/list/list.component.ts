import { Component, OnInit, ChangeDetectorRef} from '@angular/core';
import { TaskService } from '../task.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit{

  sortType: String = 'id';
  tasks: any[] = [];

  constructor(private taskService: TaskService, private httpClient: HttpClient, private router: Router, private cdr: ChangeDetectorRef){}

  ngOnInit(): void {
    this.GetData();
    this.Sort('id');
  }

  GetData(): void {
    this.taskService.GetAllData().subscribe(tasks => {
      this.tasks = tasks;
      console.log(this.tasks);
    });
  }

  Redirect(): void {
    this.router.navigate(['']);
  }

  Sort(type: String): void {
    if(this.sortType == type)
      this.tasks.sort().reverse();
    else
      switch (type) {
        case 'id':
          this.tasks.sort((a, b) => b.id - a.id);
          break;
        case 'name':
          this.tasks.sort((a, b) => a.name.localeCompare(b.name));
          break;
        case 'date':
          this.tasks.sort((a, b) => a.deadline.localeCompare(b.deadline));
          break;
        case 'description':
          this.tasks.sort((a, b) => a.description.localeCompare(b.description));
          break;
      }

    console.log(this.tasks);
    this.sortType = type;
    this.cdr.markForCheck();
  }

}
