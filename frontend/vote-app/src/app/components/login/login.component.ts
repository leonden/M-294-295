import { Component } from '@angular/core';
import { AppAuthService } from 'src/app/services/app.auth.service';
import { OAuthService } from 'angular-oauth2-oidc';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  constructor(
    private authService: AppAuthService,
    public oauthService: OAuthService
  ) {}

  public login() {
    this.authService.login();
  }

  public logout() {
    this.authService.logout();
  }
}
