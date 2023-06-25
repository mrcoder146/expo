import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { Location } from '@angular/common';

interface Project {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-select-project',
  templateUrl: './select-project.component.html',
  styleUrls: ['./select-project.component.css']
})
export class SelectProjectComponent implements OnInit {
  selectProjectForm: FormGroup;

  projects: Project[] = [
    {value: '1', viewValue: 'Project 1'},
    {value: '2"', viewValue: 'Project 2'},
    {value: '3', viewValue: 'Project 3'}
  ];
  

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.selectProjectForm = new FormGroup(
      {
        firstName: new FormControl('',[Validators.required]),
      }
    )
  }

  onSelectProject() {
    this.router.navigate(['/epic']);
  }

}
