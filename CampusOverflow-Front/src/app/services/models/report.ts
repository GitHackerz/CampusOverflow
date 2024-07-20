/* tslint:disable */
/* eslint-disable */
import { Answer } from '../models/answer';
import { Question } from '../models/question';
import { User } from '../models/user';
export interface Report {
  createdAt?: string;
  createdBy?: number;
  description?: string;
  id?: number;
  reportedAnswer?: Answer;
  reportedQuestion?: Question;
  reportedUser?: User;
  resolved?: boolean;
  title?: string;
  type?: 'QUESTION_REPORT' | 'ANSWER_REPORT' | 'USER_REPORT';
  updatedAt?: string;
  updatedBy?: number;
  user?: User;
}
