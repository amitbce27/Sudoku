import { Injectable } from '@angular/core';
import {HttpModule} from "@angular/http";

@Injectable()

export class AppService {

  constructor(private http: HttpModule) { }

  someMethod() {
    return 'Hey!';
  }

  configUrl = 'Sudoku-1.0/Sudoku-1.0';

  getConfig() {
    return this.http.get(this.configUrl);
  }
}
