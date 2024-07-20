/* tslint:disable */
/* eslint-disable */
export interface ReportRequestUpdateDto {
  description: string;
  id: number;
  reportedAnswerId?: number;
  reportedQuestionId?: number;
  reportedUserId?: number;
  resolved?: boolean;
  title: string;
  type: 'QUESTION_REPORT' | 'ANSWER_REPORT' | 'USER_REPORT';
  userId: number;
}
