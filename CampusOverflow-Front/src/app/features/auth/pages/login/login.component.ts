import { Component } from '@angular/core';
import {HeaderComponent} from "../../../../shared/components/layouts/header/header.component";
import {MatIcon} from "@angular/material/icon";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {RouterLink} from "@angular/router";
import {log} from "node:util";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    HeaderComponent,
    MatIcon,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginForm = new FormGroup({
    usernameOrEmail: new FormControl(''),
    password: new FormControl('')
  })

  onSubmit() {

  }
}
