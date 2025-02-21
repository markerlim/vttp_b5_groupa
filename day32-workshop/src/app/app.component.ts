import { Component, inject, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {PurchaseOrder} from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  private fb = inject(FormBuilder)

  protected showDeliveryTime = true
  protected form!: FormGroup
  protected lineItems!: FormArray

  ngOnInit(): void {
    this.form = this.createForm()
  }

  protected process() {
    const order: PurchaseOrder = this.form.value
    console.info('>> order = ', order)
    this.form = this.createForm()
  }

  protected update(event: any) {
    this.showDeliveryTime = !event.target.checked
  }
  protected hasError(ctrlName: string): boolean {
    const ctrl = this.form.get(ctrlName) as FormControl
    //return !ctrl.pristine && ctrl.invalid
    return ctrl.dirty && ctrl.invalid
  }
  protected invalid() {
    return this.form.invalid || (this.lineItems.controls.length <= 0)
  }
  protected addLineItem() {
    this.lineItems.push(this.createLineItem())
  }
  protected removeLineItem(idx: number) {
    console.info('> ', idx)
    this.lineItems.removeAt(idx)
  }

  private createLineItem(): FormGroup {
    return this.fb.group({
      item: this.fb.control<string>('', [ Validators.required ]),
      quantity: this.fb.control<number>(1, [ Validators.required, Validators.min(1) ]),
      unitPrice: this.fb.control<number>(.1, [ Validators.required, Validators.min(.1) ]),
    })
  }

  private createForm(): FormGroup {
    this.lineItems = this.fb.array([])
    return this.fb.group({
      name: this.fb.control<string>('', [Validators.required, Validators.minLength(3)]),
      address: this.fb.control<string>('', [Validators.required, Validators.minLength(3)]),
      email: this.fb.control<string>('', [Validators.required, Validators.email]),
      deliveryDate: this.fb.control<string>('', [Validators.required]),
      urgent: this.fb.control<boolean>(false),
      am: this.fb.control<boolean>(false),
      pm: this.fb.control<boolean>(false),
      tw: this.fb.control<boolean>(false),
      lineItems: this.lineItems
    })
  }
}
