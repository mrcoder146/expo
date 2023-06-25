import { Component, OnInit } from '@angular/core';
import { IssueService } from '../issue.service';
import { Router } from '@angular/router';
import { CreateIssueComponent } from '../create-issue/create-issue.component';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css'],
  providers: [IssueService] // Register the service provider
})
export class IssueComponent implements OnInit {
updateIssue(arg0: any) {
throw new Error('Method not implemented.');
}
  createIssue: any;
  dialog: any;
  deleteIssue(arg0: any) {
    throw new Error('Method not implemented.');
  }
  issue: any[] = [];
  displayedColumns: string[] = ['issueId', 'title', 'description', 'priority', 'status', 'date', 'raisedBy', 'assignedTo', 'sprint'];

  constructor(private issueService: IssueService, private router: Router) { }

  ngOnInit() {
    this.fetchIssues();
  }

  fetchIssues() {
    this.issueService.getIssue().subscribe((data: any[]) => {
      this.issue = data;
      console.log(this.issue);
    });
  }
}