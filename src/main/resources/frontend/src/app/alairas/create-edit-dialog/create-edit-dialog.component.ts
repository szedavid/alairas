
import { BsModalRef } from 'ngx-bootstrap/modal';
import { Component, Input } from '@angular/core';
import { Subject } from 'rxjs';
import { Alairas } from '../alairas.model';

@Component({
  selector: 'app-create-edit-dialog',
  templateUrl: './create-edit-dialog.component.html'
})
export class CreateEditDialogComponent {

  @Input()
  alairas: Alairas;

  public onClose: Subject<boolean>;

  constructor(private _bsModalRef: BsModalRef) {

  }

  public ngOnInit(): void {
    this.onClose = new Subject();
  }

  public onConfirm(): void {
    this.onClose.next(true);
    this._bsModalRef.hide();
  }

  public onCancel(): void {
    this.onClose.next(false);
    this._bsModalRef.hide();
  }
}
