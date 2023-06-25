import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { v4 as uuidv4 } from 'uuid';
import { FormGroup, FormControl, Validators } from '@angular/forms';

interface CountryCode {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit{
  signUpForm: FormGroup;
  hide: boolean = true;

  countryCode: CountryCode[] = [
    {value: '+91', viewValue: 'India (+91)'},
    {value: '+1"', viewValue: 'USA (+1)   '},
    {value: '+44', viewValue: 'UK (+44)   '},
    {value: '+81', viewValue: 'Japan (+81)'},
    {value: '+86', viewValue: 'China (+86)'},
  ];
  
  constructor(private http: HttpClient) {}
  sendAuthenticationEmail() {
    const confirmationToken: string = uuidv4();
    const confirmationLink = `https://sarvashikshan.com/confirm-email?token=${encodeURIComponent(confirmationToken)}`;
    const htmlContent = `<p>Please click the link below to confirm your email address:</p><p>${confirmationLink}</p>`;
    const email = this.signUpForm.value.email;
    const url = 'https://api.sendinblue.com/v3/smtp/email';
    const headers = {
      'Content-Type': 'application/json',
      'api-key': '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'
    };
    const body = {
      sender: { name: 'SarvaShikshan E-learning', email: 'sarvashikshan@example.com' },
      to: [{ email }],
      subject: 'Please confirm your email address',
      htmlContent
    };
  
    return this.http.post(url, body, { headers });
  }

  ngOnInit(): void {
      this.signUpForm = new FormGroup(
        {
          email: new FormControl('',[Validators.required,Validators.email]),
          password: new FormControl('',[Validators.required,Validators.minLength(6)]),
          lastName: new FormControl('',[Validators.required]),
          firstName: new FormControl('',[Validators.required]),
          phoneNumber: new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10)])
        }
      )

      
}

onSignUp() {
  window.alert("Verification link sent to your email"),
  this.sendAuthenticationEmail().subscribe(
    response => console.log('Authentication email sent successfully!'),
    error => console.log('Error sending authentication email:', error)
  );
}
    
}
