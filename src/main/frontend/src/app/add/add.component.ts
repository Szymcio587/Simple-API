import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent {
  name: String = "";
  deadline: Date = new Date();
  description: String = "";

  constructor(private httpClient: HttpClient, private router: Router) {}

  SubmitForm(): void {
    const newTask = {
      name: this.name,
      deadline: this.deadline,
      description: this.description
    };

    this.httpClient.post('http://localhost:8080/add', newTask)
      .subscribe(response => { });

    this.router.navigate(['']);
  }

  GoBack(): void {
    this.router.navigate(['']);
  }
}
