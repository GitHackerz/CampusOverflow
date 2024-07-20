import {Component, Inject, OnInit, PLATFORM_ID} from '@angular/core';
import {HeaderComponent} from "../../../../shared/components/layouts/header/header.component";
import {MatIcon} from "@angular/material/icon";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Router, RouterLink} from "@angular/router";
import {AuthenticationService} from "../../../../services/services/authentication.service";
import {LoginRequest} from "../../../../services/models/login-request";
import {TokenService} from "../../../../services/token/token.service";
import {isPlatformBrowser, NgIf} from "@angular/common";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    HeaderComponent,
    MatIcon,
    ReactiveFormsModule,
    RouterLink,
    NgIf
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  isBrowser: boolean = false;

  loginForm = new FormGroup({
    usernameOrEmail: new FormControl('', [
      Validators.required
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8)
    ])
  })

  ngOnInit() {
    if (this.tokenService.isTokenValid()) {
      this.router.navigate(['/question'])
    }
  }

  constructor(
    private authService: AuthenticationService,
    private tokenService: TokenService,
    private router: Router,
    @Inject(PLATFORM_ID) platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(platformId);
  }


  onSubmit() {
    if (this.loginForm.invalid) {
      return
    }
    this.authService.login({
      body: this.loginForm.value as LoginRequest
    }).subscribe({
        next: (response) => {
          this.tokenService.token = response.token as string
          this.router.navigate(['/question'])
        },
        error: (error) => {
          console.error(error.error)
        }
      }
    )
  }
}
