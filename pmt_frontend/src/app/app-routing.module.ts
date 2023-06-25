import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SelectProjectComponent } from './select-project/select-project.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { NavigationComponent } from './navigation/navigation.component';
import { EpicComponent } from './epic/epic.component';
import { StoryComponent } from './story/story.component';
import { ImpedimentsComponent } from './impediments/impediments.component';
import { IssueComponent } from './issue/issue.component';
import { CreateImpedimentsComponent } from './create-impediments/create-impediments.component';
import { CreateIssueComponent } from './create-issue/create-issue.component';
import { UpdateImpedimentsComponent } from './update-impediments/update-impediments.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {
    path:"", component:SignInComponent
  },
  {
    path:"sign-up", component:SignUpComponent
  },
  {
    path:"select-project",component:SelectProjectComponent  , canActivate: [AuthGuard]
  },
  {
    path:"create-project",component:CreateProjectComponent  , canActivate: [AuthGuard]
  },
  {
    path:"navigation",component:NavigationComponent  , canActivate: [AuthGuard]
  },
  {
    path:"epic",component:EpicComponent  , canActivate: [AuthGuard]
  },
  {
    path:"story",component:StoryComponent  , canActivate: [AuthGuard]
  },
  {
    path:"impediments",component:ImpedimentsComponent  , canActivate: [AuthGuard]
  },
  {
    path:"issue",component:IssueComponent  , canActivate: [AuthGuard]
  },
  { 
    path: 'create-impediments', component: CreateImpedimentsComponent   , canActivate: [AuthGuard]
  },
  { 
    path: 'create-issue', component: CreateIssueComponent  , canActivate: [AuthGuard]
  },
  { 
    path: 'update-impediments', component: UpdateImpedimentsComponent  , canActivate: [AuthGuard]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
