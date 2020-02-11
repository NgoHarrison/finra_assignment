import { Injectable, OnInit } from "@angular/core";
import {
  HttpClient,
  HttpErrorResponse,
  HttpParams
} from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class NumberserviceService implements OnInit {
  server: string;
  data: string;
  numberlist: string[];
  show_error: boolean;
  display_flag: boolean;
  constructor(private httpClient: HttpClient) {
    this.server = "http://localhost:4567/getComb";
  }
  ngOnInit() {}
  getComb(data: string): Observable<string[]> {
    return this.httpClient.get<string[]>(this.server, {
      params: {
        number: data
      }
    });
  }
}
