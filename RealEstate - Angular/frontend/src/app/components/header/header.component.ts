import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';
import { EventBusService } from 'src/app/_shared/event-bus.service';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showCourtierBoard = false;
  showClientBoard = false;
  username?: string;

  eventBusSub?: Subscription;

  constructor(
    private storageService: StorageService,
    private authService: AuthService,
    private eventBusService: EventBusService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showCourtierBoard = this.roles.includes('ROLE_COURTIER');
      this.showClientBoard = this.roles.includes('ROLE_CLIENT');

      this.username = user.username;
    }

    this.eventBusSub = this.eventBusService.on('logout', () => {
      this.logout();
    });
  }

  logout(): void {
    this.storageService.clean();
    window.location.reload();
    // this.authService.logout().subscribe({
    //   next: res => {
    //     console.log("loggggggg",res);
    //     this.storageService.clean();

    //     // window.location.reload();
    //   },
    //   error: err => {
    //     console.log("7amirr",err);
    //   }
    // });
  }

}
