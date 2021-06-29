import { DemoService } from '../services/demo.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [{ provide: DemoService, useClass: DemoService }],
})
export class HomeComponent implements OnInit {
  message: string = 'Wow ça marche c est ouf';

  constructor(private router: Router) {}

  ngOnInit(): void {}

  go() {
    this.router.navigate(['/param', this.message], {
      queryParams: { prenom: this.message },
    });
  }
}
