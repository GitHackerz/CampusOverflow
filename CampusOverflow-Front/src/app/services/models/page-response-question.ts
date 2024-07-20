/* tslint:disable */
/* eslint-disable */
import { Question } from '../models/question';
export interface PageResponseQuestion {
  content?: Array<Question>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
