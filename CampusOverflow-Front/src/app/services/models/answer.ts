/* tslint:disable */
/* eslint-disable */
import { Question } from '../models/question';
import { User } from '../models/user';
export interface Answer {
  content?: string;
  createdAt?: string;
  createdBy?: number;
  id?: number;
  question?: Question;
  updatedAt?: string;
  updatedBy?: number;
  user?: User;
}
