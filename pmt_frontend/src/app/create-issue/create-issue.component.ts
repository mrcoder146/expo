import { Component } from '@angular/core';

@Component({
  selector: 'app-create-issue',
  templateUrl: './create-issue.component.html',
  styleUrls: ['./create-issue.component.css']
})
export class CreateIssueComponent {
  issue: any = {}; // Create an object to hold the form data

  submitIssue() {
    // You can perform any actions with the form data here, such as submitting it to a server or processing it further
    console.log(this.issue);
  }
}


