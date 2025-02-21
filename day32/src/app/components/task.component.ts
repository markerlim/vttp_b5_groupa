import { Component, inject, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Task } from '../models';

@Component({
  selector: 'app-task',
  standalone: false,
  templateUrl: './task.component.html',
  styleUrl: './task.component.css'
})
export class TaskComponent implements OnInit {

  urgency = "2"

  // inject() -> @Autowire
  private fb = inject(FormBuilder)

  // form model
  protected form!: FormGroup
  protected collaborators!: FormArray

  taskNameCtrlName = 'taskName'

  ngOnInit(): void {
    this.form = this.createForm()
  }

  protected processForm(): void {

    const values: Task = this.form.value
    console.info('>>> form: ', values)

    // const formValue = this.form.value
    // const values: Task = {
    //   ...formValue,
    // }
    //@ts-ignore
    // const a: Task = {}

    // for (let k in formValue) {
    //   //@ts-ignore
    //   a[k] = formValue[k]
    // }

    // console.info('>>> form: ', a)
  }

  protected updateUrgency(event: any): void {
    this.urgency = event.target.value
  }

  protected isCtrlValid(ctrlName: string): boolean {
    return !!this.form.get(ctrlName)?.valid
  }
  protected isCtrlInvalid(ctrlName: string): boolean {
    return !!this.form.get(ctrlName)?.invalid
  }

  protected addCollaborator() {
    // Create the collaborator form group
    const col = this.createCollaborator()
    // Add to form array
    this.collaborators.push(col)
  }

  protected removeCollaborator(idx: number) {
    this.collaborators.removeAt(idx)
  }

  protected invalid(): boolean {
    return this.form.invalid || this.collaborators.controls.length <= 0
  }

  private createCollaborator(): FormGroup {
    return this.fb.group({
      name: this.fb.control<string>(''),
      email: this.fb.control<string>('', [ Validators.required, Validators.email ])
    })
  }

  private createForm(): FormGroup {
    this.collaborators = this.fb.array([], [ Validators.minLength(1) ])
    return this.fb.group({
      taskName: this.fb.control<string>('', [ Validators.required, Validators.minLength(3) ]),
      priority: this.fb.control<string>('1'),
      dueDate: this.fb.control<string>('', [ Validators.required ]),
      urgency: this.fb.control<number>(2),
      comments: this.fb.control<string>(''),
      procrastinate: this.fb.control<boolean>(false),
      collaborators: this.collaborators
    })
  }


}
