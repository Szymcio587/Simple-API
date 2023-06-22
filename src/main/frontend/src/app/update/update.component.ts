import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  id: number = 0;
  name: String = "";
  deadline: Date = new Date();
  description: String = "";

  constructor(private httpClient: HttpClient, private router: Router) {}

  SubmitForm(): void {
    const newTask = {
      id: this.id,
      name: this.name,
      deadline: this.deadline,
      description: this.description
    };

    this.httpClient.post('http://localhost:8080/update', newTask)
      .subscribe(response => { });

    this.router.navigate(['']);
  }

  GoBack(): void {
    this.router.navigate(['']);
  }
}
