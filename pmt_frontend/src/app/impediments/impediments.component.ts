import { Component, OnInit } from '@angular/core';
import { ImpedimentsService } from '../impediments.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-impediments',
  templateUrl: './impediments.component.html',
  styleUrls: ['./impediments.component.css'],
  providers: [ImpedimentsService] // Register the service provider
})
export class ImpedimentsComponent implements OnInit {
  createImpediments: any;
  deleteImpediments(arg0: any) {
    throw new Error('Method not implemented.');
  }
  impediments: any[] = [];
  displayedColumns: string[] = ['impedimentId', 'title', 'description', 'priority', 'status', 'date', 'raisedBy', 'assignedTo', 'sprint'];

  constructor(private impedimentsService: ImpedimentsService, private router: Router) { }

  ngOnInit() {
    this.fetchImpediments();
  }

  fetchImpediments() {
    this.impedimentsService.getImpediments().subscribe((data: any[]) => {
      this.impediments = data;
      console.log(this.impediments);
    });
  }
}
