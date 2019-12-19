import { Component, OnInit } from '@angular/core';
import { Alairas } from './alairas.model';
import { AlairasService } from './alairas.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-alairas',
  templateUrl: './alairas.component.html',
  styleUrls: ['./alairas.component.scss']
})
export class AlairasComponent implements OnInit {

  alairasok: Alairas[];
  
  constructor(private service: AlairasService) { }

  ngOnInit() {
    this.service.getAll().subscribe(
        (resp: HttpResponse<Alairas[]>) => {
          this.alairasok = resp.body;
        }, (error: HttpErrorResponse) => {

          console.log('Lekérdezés sikertelen! ' + error.message);

          // this.toastr.error('Lekérdezés sikertelen! ' + error.message);
        });
  }

}
