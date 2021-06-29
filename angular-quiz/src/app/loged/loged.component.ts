import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loged',
  templateUrl: './loged.component.html',
  styleUrls: ['./loged.component.css'],
})
export class LogedComponent implements OnInit {
  constructor(private router: Router) {}

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }

  ngOnInit(): void {}
}
