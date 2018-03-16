import { Component } from '@angular/core';
import {AppService} from "../app.service";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[AppService]

})
export class AppComponent {
  constructor(private appservice: AppService) {}
  title='starting value  ';
  numbers:any = 9;
  isAddButton:boolean;
  matrix:any;
  ngOnInit() {
    this.title = this.appservice.someMethod();
    console.log(this.title);
  }
  changeColour(x:any,y:any){
    console.log("x coordinate :" +x +" Y coordinate "+ y);
    if(this.isAddButton){
      this.isAddButton = false;
    } else
      this.isAddButton = true;
  }


}
