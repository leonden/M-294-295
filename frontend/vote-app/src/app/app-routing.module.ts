import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { ElectionsComponent } from './components/pages/elections/elections.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'elections', component: ElectionsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
