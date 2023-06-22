import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit{

  requests: number = 0;

  constructor(private taskService: TaskService, private router: Router) {};

  ngOnInit(): void {
    this.GetRequests();
  }

  GetRequests(): void {
    this.taskService.GetRequestsNumber().subscribe(requests => {
      this.requests = requests;
      console.log(this.requests);
    });
  }

  GoBack(): void {
    this.router.navigate(['']);
  }

}
