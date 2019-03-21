import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PageNotFoundComponent } from "./components/page-not-found/page-not-found.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { TaskComponent } from "./components/task/task.component";
import { UserComponent } from "./components/user/user.component";

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'activemq', component: TaskComponent },
  { path: 'websocket', component: UserComponent },
   { path: '' ,redirectTo: '/dashboard',pathMatch: 'full'},
  { path: 'not-found',component: PageNotFoundComponent},
  { path: '**',redirectTo:'not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
