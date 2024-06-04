import {Routes} from '@angular/router';
import {authGuard} from "./core/auth.guard";

export const routes: Routes = [

  {
    path: '',
    loadChildren: () => import('./features/landing/landing.module').then(m => m.LandingModule),
  },
  {
    path: '',
    loadChildren: () => import('./features/auth/auth.module').then(m => m.AuthModule),
  },
  {
    path: 'question',
    loadChildren: () => import('./features/question/question.module').then(m => m.QuestionModule),
    canActivateChild: [authGuard]
  },
  {
    path: 'dashboard',
    loadChildren: () => import('./features/dashboard/dashboard.module').then(m => m.DashboardModule),
  },
  {
    path: '**',
    redirectTo: '',
  },
];
