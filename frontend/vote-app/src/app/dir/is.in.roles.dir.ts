import {
  Directive,
  Input,
  OnDestroy,
  OnInit,
  TemplateRef,
  ViewContainerRef,
} from '@angular/core';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { AppAuthService } from '../services/app.auth.service';

@Directive({
  selector: '[appIsInRoles]',
})
export class IsInRolesDirective implements OnInit, OnDestroy {
  @Input() appIsInRoles?: string[];
  stop$ = new Subject();
  isVisible = false;

  constructor(
    private viewContainerRef: ViewContainerRef,
    private templateRef: TemplateRef<any>,
    private authService: AppAuthService
  ) {}

  ngOnInit() {
    this.authService
      .getRoles()
      .pipe(takeUntil(this.stop$))
      .subscribe((roles) => {
        if (!roles) {
          this.viewContainerRef.clear();
        }
        let found = true;
        this.appIsInRoles?.forEach((r) => {
          if (!roles.includes(r)) {
            found = false;
          }
        });
        if (found) {
          if (!this.isVisible) {
            this.isVisible = true;
            this.viewContainerRef.createEmbeddedView(this.templateRef);
          }
        } else {
          this.isVisible = false;
          this.viewContainerRef.clear();
        }
      });
  }

  ngOnDestroy() {
    this.stop$.next(null);
  }
}
