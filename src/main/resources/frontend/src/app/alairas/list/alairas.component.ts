import { Component, OnInit, TemplateRef } from '@angular/core';
import { Alairas } from '../alairas.model';
import { AlairasService } from '../alairas.service';
import { HttpErrorResponse } from '@angular/common/http';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { CreateEditDialogComponent } from '../create-edit-dialog/create-edit-dialog.component';

@Component({
  selector: 'app-alairas',
  templateUrl: './alairas.component.html'
})
export class AlairasComponent implements OnInit {

  private page = 0;
  private pages: Array<number>;

  private alairasok: Alairas[];

  private modalRef: BsModalRef;
  private modalData: Alairas;

  constructor(private service: AlairasService,
              private modalService: BsModalService) {
  }

  // ngOnInit() {
  //   this.service.getAll().subscribe(
  //       (resp: HttpResponse<Alairas[]>) => {
  //         this.alairasok = resp.body;
  //       }, (error: HttpErrorResponse) => {
  //
  //         console.log('Lekérdezés sikertelen! ' + error.message);
  //
  //         // this.toastr.error('Lekérdezés sikertelen! ' + error.message);
  //       });
  // }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.service.getAll(this.page).subscribe(
        data => {
          console.log(data);
          this.alairasok = data['_embedded'].alairasok;
          this.pages = new Array(data['page'].totalPages);
        }, (error: HttpErrorResponse) => {

          console.log('Lekérdezés sikertelen! ' + error.message);

          // this.toastr.error('Lekérdezés sikertelen! ' + error.message);
        });
  }

  setPage(i: number, event: MouseEvent) {
    event.preventDefault();
    this.page = i;
    this.getAll();
  }

  public openModal(template: TemplateRef<any>, alairas: Alairas) {
    this.modalRef = this.modalService.show(template);
    this.modalData = alairas;
  }

  openConfirmDialog(id: number) {
    this.modalRef = this.modalService.show(ConfirmDialogComponent);
    this.modalRef.content.onClose.subscribe(result => {
      if (result) {
        this.service.deleteById(id).subscribe(
            data => {
              this.getAll();
            }, (error: HttpErrorResponse) => {

              console.log('Törlés sikertelen! ' + error.message);

              // this.toastr.error('Törlés sikertelen! ' + error.message);
            });
      }
    });
  }

  openCreateEditDialog(alairas: Alairas) {
    const initialState = {alairas: alairas};
    this.modalRef = this.modalService.show(CreateEditDialogComponent, Object.assign({}, {}, { class: 'modal-sm', initialState }));
    this.modalRef.content.onClose.subscribe(result => {
      if (result) {
        this.getAll();
      }
    });
  }
}
