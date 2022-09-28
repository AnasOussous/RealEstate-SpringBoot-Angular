import { Component, OnInit } from '@angular/core';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-courtierdashboard',
  templateUrl: './courtierdashboard.component.html',
  styleUrls: ['./courtierdashboard.component.css']
})
export class CourtierdashboardComponent implements OnInit {

  currentUser: any;

  constructor(private storageService: StorageService) { }

  ngOnInit(): void {
    this.currentUser = this.storageService.getUser();
  }

}
