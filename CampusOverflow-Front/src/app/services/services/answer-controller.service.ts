/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { Answer } from '../models/answer';
import { deleteAnswerById } from '../fn/answer-controller/delete-answer-by-id';
import { DeleteAnswerById$Params } from '../fn/answer-controller/delete-answer-by-id';
import { findAllAnswersByQuestionId } from '../fn/answer-controller/find-all-answers-by-question-id';
import { FindAllAnswersByQuestionId$Params } from '../fn/answer-controller/find-all-answers-by-question-id';
import { findAllAnswersByUserId } from '../fn/answer-controller/find-all-answers-by-user-id';
import { FindAllAnswersByUserId$Params } from '../fn/answer-controller/find-all-answers-by-user-id';
import { findAnswerById } from '../fn/answer-controller/find-answer-by-id';
import { FindAnswerById$Params } from '../fn/answer-controller/find-answer-by-id';
import { saveAnswer } from '../fn/answer-controller/save-answer';
import { SaveAnswer$Params } from '../fn/answer-controller/save-answer';
import { updateAnswer } from '../fn/answer-controller/update-answer';
import { UpdateAnswer$Params } from '../fn/answer-controller/update-answer';

@Injectable({ providedIn: 'root' })
export class AnswerControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `saveAnswer()` */
  static readonly SaveAnswerPath = '/answer';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveAnswer()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveAnswer$Response(params: SaveAnswer$Params, context?: HttpContext): Observable<StrictHttpResponse<Answer>> {
    return saveAnswer(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveAnswer$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveAnswer(params: SaveAnswer$Params, context?: HttpContext): Observable<Answer> {
    return this.saveAnswer$Response(params, context).pipe(
      map((r: StrictHttpResponse<Answer>): Answer => r.body)
    );
  }

  /** Path part for operation `updateAnswer()` */
  static readonly UpdateAnswerPath = '/answer';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateAnswer()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateAnswer$Response(params: UpdateAnswer$Params, context?: HttpContext): Observable<StrictHttpResponse<Answer>> {
    return updateAnswer(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateAnswer$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateAnswer(params: UpdateAnswer$Params, context?: HttpContext): Observable<Answer> {
    return this.updateAnswer$Response(params, context).pipe(
      map((r: StrictHttpResponse<Answer>): Answer => r.body)
    );
  }

  /** Path part for operation `findAnswerById()` */
  static readonly FindAnswerByIdPath = '/answer/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAnswerById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAnswerById$Response(params: FindAnswerById$Params, context?: HttpContext): Observable<StrictHttpResponse<Answer>> {
    return findAnswerById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAnswerById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAnswerById(params: FindAnswerById$Params, context?: HttpContext): Observable<Answer> {
    return this.findAnswerById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Answer>): Answer => r.body)
    );
  }

  /** Path part for operation `deleteAnswerById()` */
  static readonly DeleteAnswerByIdPath = '/answer/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteAnswerById()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteAnswerById$Response(params: DeleteAnswerById$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteAnswerById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteAnswerById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteAnswerById(params: DeleteAnswerById$Params, context?: HttpContext): Observable<void> {
    return this.deleteAnswerById$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `findAllAnswersByUserId()` */
  static readonly FindAllAnswersByUserIdPath = '/answer/user/{userId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllAnswersByUserId()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllAnswersByUserId$Response(params: FindAllAnswersByUserId$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return findAllAnswersByUserId(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllAnswersByUserId$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllAnswersByUserId(params: FindAllAnswersByUserId$Params, context?: HttpContext): Observable<{
}> {
    return this.findAllAnswersByUserId$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

  /** Path part for operation `findAllAnswersByQuestionId()` */
  static readonly FindAllAnswersByQuestionIdPath = '/answer/question/{questionId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllAnswersByQuestionId()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllAnswersByQuestionId$Response(params: FindAllAnswersByQuestionId$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return findAllAnswersByQuestionId(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllAnswersByQuestionId$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllAnswersByQuestionId(params: FindAllAnswersByQuestionId$Params, context?: HttpContext): Observable<{
}> {
    return this.findAllAnswersByQuestionId$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

}
