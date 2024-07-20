import {CanActivateChildFn, Router} from '@angular/router';
import {inject, PLATFORM_ID} from "@angular/core";
import {TokenService} from "../../services/token/token.service";
import {isPlatformBrowser} from "@angular/common";

export const authGuard: CanActivateChildFn = () => {
  const tokenService = inject(TokenService);
  const router = inject(Router);
  const platformId = inject(PLATFORM_ID);
  const isBrowser = isPlatformBrowser(platformId);

  if (isBrowser) {
    if (tokenService.isTokenNotValid()) {
      router.navigate(['/login']);
      return false;
    }
    return true;
  }

  return false;
}
