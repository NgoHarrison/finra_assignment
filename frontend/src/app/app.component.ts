import { Component, OnInit } from "@angular/core";
import { NumberserviceService } from "./numberservice.service";
import {
  FormBuilder,
  FormControl,
  FormGroup
} from "@angular/forms";
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  p: number;
  formData: FormGroup;
  title = "frontend";
  data: string;
  show_error: boolean;
  display_table: boolean;
  numberlist: string[];
  constructor(
    private numberservice: NumberserviceService,
    private fb: FormBuilder
  ) {
    this.data = "";
  }
  ngOnInit() {
    this.formData = new FormGroup({
      data: new FormControl("")
    });
  }

  getComb(data: string) {
    this.p = 1;
    var num = this.formData.value["data"];
    this.numberservice.getComb(num).subscribe(res => {
      this.numberlist = res;
      if (this.numberlist[0] == "E") {
        this.show_error = true;
        this.display_table = false;
      } else {
        console.log(this.numberlist);
        this.show_error = false;
        this.display_table = true;
      }
    }, console.log);
  }
}
