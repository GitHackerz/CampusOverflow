/* tslint:disable */
/* eslint-disable */
import { Tag } from '../models/tag';
import { User } from '../models/user';
export interface Question {
  content?: string;
  createdAt?: string;
  createdBy?: number;
  id?: number;
  tags?: Array<Tag>;
  title?: string;
  updatedAt?: string;
  updatedBy?: number;
  user?: User;
}
