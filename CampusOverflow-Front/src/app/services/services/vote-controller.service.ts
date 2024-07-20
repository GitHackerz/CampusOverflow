/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { deleteVoteById } from '../fn/vote-controller/delete-vote-by-id';
import { DeleteVoteById$Params } from '../fn/vote-controller/delete-vote-by-id';
import { findAllVotesByAnswerId } from '../fn/vote-controller/find-all-votes-by-answer-id';
import { FindAllVotesByAnswerId$Params } from '../fn/vote-controller/find-all-votes-by-answer-id';
import { findAllVotesByUserId } from '../fn/vote-controller/find-all-votes-by-user-id';
import { FindAllVotesByUserId$Params } from '../fn/vote-controller/find-all-votes-by-user-id';
import { findVoteById } from '../fn/vote-controller/find-vote-by-id';
import { FindVoteById$Params } from '../fn/vote-controller/find-vote-by-id';
import { saveVote } from '../fn/vote-controller/save-vote';
import { SaveVote$Params } from '../fn/vote-controller/save-vote';
import { Vote } from '../models/vote';

@Injectable({ providedIn: 'root' })
export class VoteControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `saveVote()` */
  static readonly SaveVotePath = '/vote';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveVote()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveVote$Response(params: SaveVote$Params, context?: HttpContext): Observable<StrictHttpResponse<Vote>> {
    return saveVote(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveVote$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveVote(params: SaveVote$Params, context?: HttpContext): Observable<Vote> {
    return this.saveVote$Response(params, context).pipe(
      map((r: StrictHttpResponse<Vote>): Vote => r.body)
    );
  }

  /** Path part for operation `findVoteById()` */
  static readonly FindVoteByIdPath = '/vote/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findVoteById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findVoteById$Response(params: FindVoteById$Params, context?: HttpContext): Observable<StrictHttpResponse<Vote>> {
    return findVoteById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findVoteById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findVoteById(params: FindVoteById$Params, context?: HttpContext): Observable<Vote> {
    return this.findVoteById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Vote>): Vote => r.body)
    );
  }

  /** Path part for operation `deleteVoteById()` */
  static readonly DeleteVoteByIdPath = '/vote/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteVoteById()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteVoteById$Response(params: DeleteVoteById$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteVoteById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteVoteById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteVoteById(params: DeleteVoteById$Params, context?: HttpContext): Observable<void> {
    return this.deleteVoteById$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `findAllVotesByUserId()` */
  static readonly FindAllVotesByUserIdPath = '/vote/user/{userId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllVotesByUserId()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllVotesByUserId$Response(params: FindAllVotesByUserId$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return findAllVotesByUserId(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllVotesByUserId$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllVotesByUserId(params: FindAllVotesByUserId$Params, context?: HttpContext): Observable<{
}> {
    return this.findAllVotesByUserId$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

  /** Path part for operation `findAllVotesByAnswerId()` */
  static readonly FindAllVotesByAnswerIdPath = '/vote/answer/{answerId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllVotesByAnswerId()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllVotesByAnswerId$Response(params: FindAllVotesByAnswerId$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return findAllVotesByAnswerId(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllVotesByAnswerId$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllVotesByAnswerId(params: FindAllVotesByAnswerId$Params, context?: HttpContext): Observable<{
}> {
    return this.findAllVotesByAnswerId$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

}
