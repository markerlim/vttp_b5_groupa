import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

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

  ngOnInit(): void {
    this.form = this.createForm()
  }

  private createForm(): FormGroup {
    return this.fb.group({
      taskName: this.fb.control<string>(''),
      priority: this.fb.control<string>('1'),
      dueDate: this.fb.control<string>(''),
      urgency: this.fb.control<number>(2),
      comments: this.fb.control<string>(''),
      procrestinate: this.fb.control<boolean>(false),
    })
  }

  protected updateUrgency(event: any): void {
    this.urgency = event.target.value
  }

}
