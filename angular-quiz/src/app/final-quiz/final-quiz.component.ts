import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-final-quiz',
  templateUrl: './final-quiz.component.html',
  styleUrls: ['./final-quiz.component.css'],
})
export class FinalQuizComponent implements OnInit {
  constructor() {}

  /*coutndown() {
    var timeleft = 10;
    var downloadTimer = setInterval(function () {
      if (timeleft <= 0) {
        clearInterval(downloadTimer);
        document.getElementById('countdown')!.innerHTML = 'Finished';
      } else {
        document.getElementById('countdown')!.innerHTML =
          timeleft + ' seconds remaining';
      }

      timeleft -= 1;
    }, 1000);
  }*/
  ngOnInit(): void {}
}
