/* tslint:disable */
/* eslint-disable */
import { GrantedAuthority } from '../models/granted-authority';
export interface User {
  accountLocked?: boolean;
  accountNonExpired?: boolean;
  accountNonLocked?: boolean;
  authorities?: Array<GrantedAuthority>;
  birthdate?: string;
  createdAt?: string;
  credentialsNonExpired?: boolean;
  email?: string;
  enabled?: boolean;
  id?: number;
  name?: string;
  password?: string;
  role?: 'USER' | 'ADMIN';
  updatedAt?: string;
  username?: string;
}
