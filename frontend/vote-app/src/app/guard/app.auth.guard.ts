import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateChild,
  Router,
} from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import { AppAuthService } from '../services/app.auth.service';

@Injectable()
export class AppAuthGuard implements CanActivate, CanActivateChild {
  private userRoles?: string[];

  constructor(
    private authService: AppAuthService,
    private oauthService: OAuthService,
    private router: Router
  ) {}

  canActivate(route: ActivatedRouteSnapshot) {
    this.authService.getRoles().subscribe((roles) => {
      this.userRoles = roles;
    });

    if (this.oauthService.hasValidAccessToken()) {
      const hasRoles = this.checkRoles(route);
      if (!hasRoles) {
        return this.router.parseUrl('/noaccess');
      }
      return hasRoles;
    }
    return this.router.parseUrl('/noaccess');
  }

  checkRoles(route: ActivatedRouteSnapshot): boolean {
    const roles = route.data['roles'] as Array<string>;

    if (roles === undefined || roles === null || roles.length === 0) {
      return true;
    }

    if (this.userRoles === undefined) {
      return false;
    }

    for (const role of roles) {
      if (this.userRoles.indexOf(role) > -1) {
        return true;
      }
    }

    return false;
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot) {
    return this.canActivate(childRoute);
  }
}
