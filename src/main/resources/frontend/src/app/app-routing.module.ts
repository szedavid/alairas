import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlairasComponent } from './alairas/list/alairas.component';

const routes: Routes = [
  {path: '', component: AlairasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
