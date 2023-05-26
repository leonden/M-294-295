import { Component } from '@angular/core';
import { AppAuthService } from 'src/app/services/app.auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  constructor(private authService: AppAuthService) {}

  public login() {
    this.authService.login();
    console.log('login');
  }

  public logout() {
    this.authService.logout();
    console.log('logout');
  }
}
