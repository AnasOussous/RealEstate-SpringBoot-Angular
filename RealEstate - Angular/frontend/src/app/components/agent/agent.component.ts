import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {
  cheminImage:string = "/src/assets/images/icon-3.png"
  constructor() { }

  ngOnInit(): void {
  }

}
