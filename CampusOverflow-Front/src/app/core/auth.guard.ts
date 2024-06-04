import {CanActivateChildFn, Router} from '@angular/router';
import {inject} from "@angular/core";

export const authGuard: CanActivateChildFn = (childRoute, state) => {
  const router = inject(Router);

  router.navigate(['/login']);
  return false;
};
