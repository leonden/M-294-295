import { AfterViewInit, Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements AfterViewInit {
  @ViewChild('toolbar') toolbar!: any;
  @ViewChild('drawer') drawer!: any;

  ngAfterViewInit() {
    this.handleDrawerHeight();
  }

  handleDrawerHeight() {
    const toolbarHeight = this.toolbar._elementRef.nativeElement.offsetHeight;
    const drawer = this.drawer._elementRef.nativeElement;
    drawer.style.height = `calc(100vh - ${toolbarHeight}px)`;
  }
}
