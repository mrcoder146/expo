import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({ 
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css'] 
})
export class SignInComponent implements OnInit {
  signInForm: FormGroup;
  hide: boolean = false;
  user = {
    email: "", 
    password: ""
  }

  constructor( 
    private router: Router,
    private _snackBar: MatSnackBar,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.signInForm = new FormGroup({
      email: new FormControl(''),
      password: new FormControl('')
    });
  }


 onSignIn() {
  const loginData = {
    emailId: this.user.email,
    password: this.user.password
  };

  this.http.post<any>('http://localhost:8080/api/v1/login', loginData).subscribe(
    (response: any) => {
      console.log(response);
      if (response.success) {
        const token = response.token;
        // Store token in local storage
        localStorage.setItem('token', token);

        // Navigate to '/select-project'
        this.router.navigate(['/select-project']);
      } else {
        // Handle unsuccessful login
        this._snackBar.open("Invalid credentials", 'Close', {
          duration: 3000 // Set the duration to 3000 milliseconds (3 seconds)
        });
      }
    },
    (error) => {
      console.error(error);
      this._snackBar.open("An error occurred", 'Close');
    }
  );
}

  
}
