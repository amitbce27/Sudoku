import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {AppService} from "../app.service";
import HttpClient = http.HttpClient;

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClient
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
