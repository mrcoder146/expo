import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit{
  createProjectForm: FormGroup;

  constructor() {}

  ngOnInit(): void {
      this.createProjectForm = new FormGroup(
        {
          projectName: new FormControl('',[Validators.required]),
          companyName: new FormControl('',[Validators.required])
        }
      )
  }

  onCreateProject() {

  }

}
