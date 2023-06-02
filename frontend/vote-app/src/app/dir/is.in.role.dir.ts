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
  selector: '[appIsInRole]',
})
export class IsInRoleDirective implements OnInit, OnDestroy {
  @Input() appIsInRole = '';
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
        if (roles.includes(this.appIsInRole)) {
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
