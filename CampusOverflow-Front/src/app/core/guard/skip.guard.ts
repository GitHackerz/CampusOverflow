import {CanActivateChildFn, Router} from '@angular/router';
import {inject, PLATFORM_ID} from "@angular/core";
import {TokenService} from "../../services/token/token.service";
import {isPlatformBrowser} from "@angular/common";

export const skipGuard: CanActivateChildFn = () => {
  const router = inject(Router);
  const tokenService = inject(TokenService);
  const platformId = inject(PLATFORM_ID);
  const isBrowser = isPlatformBrowser(platformId);

  if (isBrowser) {
    if (tokenService.isTokenValid()) {
      router.navigate(['/question'])
      return false;
    }
    return true;
  }
  return false;
};
