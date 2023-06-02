import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { ElectionsComponent } from './components/pages/elections/elections.component';
import { CreateElectionComponent } from './components/pages/create-election/create-election.component';
import { AppRoles } from './app.roles';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'elections',
    component: ElectionsComponent,
  },
  {
    path: 'create-election',
    component: CreateElectionComponent,
    data: { roles: [AppRoles.Admin] },
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
