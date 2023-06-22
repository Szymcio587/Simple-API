import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  public constructor(private router: Router, private httpClient: HttpClient){};

  Redirect(url : String): void {
    this.router.navigate([`${url}`]);
  }
}

