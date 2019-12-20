import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AlairasComponent } from './alairas/list/alairas.component';
import { AlairasService } from './alairas/alairas.service';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap';
import { ConfirmDialogComponent } from './alairas/confirm-dialog/confirm-dialog.component';
import { CreateEditDialogComponent } from './alairas/create-edit-dialog/create-edit-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    AlairasComponent,
    ConfirmDialogComponent,
    CreateEditDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ModalModule.forRoot()
  ],
  providers: [AlairasService],
  bootstrap: [AppComponent],
  exports: [ModalModule],
  entryComponents: [ConfirmDialogComponent, CreateEditDialogComponent]
})
export class AppModule { }
