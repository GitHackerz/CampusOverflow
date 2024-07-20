/* tslint:disable */
/* eslint-disable */
export interface VoteRequestNewDto {
  answerId: number;
  type: 'UPVOTE' | 'DOWNVOTE';
  userId: number;
}
