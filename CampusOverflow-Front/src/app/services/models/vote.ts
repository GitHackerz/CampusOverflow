/* tslint:disable */
/* eslint-disable */
import { Answer } from '../models/answer';
import { User } from '../models/user';
export interface Vote {
  answer?: Answer;
  createdAt?: string;
  createdBy?: number;
  id?: number;
  type?: 'UPVOTE' | 'DOWNVOTE';
  updatedAt?: string;
  updatedBy?: number;
  user?: User;
}
