/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { deleteQuestionById } from '../fn/question/delete-question-by-id';
import { DeleteQuestionById$Params } from '../fn/question/delete-question-by-id';
import { findAllQuestions } from '../fn/question/find-all-questions';
import { FindAllQuestions$Params } from '../fn/question/find-all-questions';
import { findAllQuestionsByUser } from '../fn/question/find-all-questions-by-user';
import { FindAllQuestionsByUser$Params } from '../fn/question/find-all-questions-by-user';
import { findQuestionById } from '../fn/question/find-question-by-id';
import { FindQuestionById$Params } from '../fn/question/find-question-by-id';
import { PageResponseQuestion } from '../models/page-response-question';
import { Question } from '../models/question';
import { saveQuestion } from '../fn/question/save-question';
import { SaveQuestion$Params } from '../fn/question/save-question';
import { searchQuestions } from '../fn/question/search-questions';
import { SearchQuestions$Params } from '../fn/question/search-questions';
import { updateQuestion } from '../fn/question/update-question';
import { UpdateQuestion$Params } from '../fn/question/update-question';


/**
 * Question API
 */
@Injectable({ providedIn: 'root' })
export class QuestionService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `findAllQuestions()` */
  static readonly FindAllQuestionsPath = '/question';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllQuestions()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllQuestions$Response(params?: FindAllQuestions$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseQuestion>> {
    return findAllQuestions(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllQuestions$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllQuestions(params?: FindAllQuestions$Params, context?: HttpContext): Observable<PageResponseQuestion> {
    return this.findAllQuestions$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseQuestion>): PageResponseQuestion => r.body)
    );
  }

  /** Path part for operation `updateQuestion()` */
  static readonly UpdateQuestionPath = '/question';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateQuestion()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateQuestion$Response(params: UpdateQuestion$Params, context?: HttpContext): Observable<StrictHttpResponse<Question>> {
    return updateQuestion(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateQuestion$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateQuestion(params: UpdateQuestion$Params, context?: HttpContext): Observable<Question> {
    return this.updateQuestion$Response(params, context).pipe(
      map((r: StrictHttpResponse<Question>): Question => r.body)
    );
  }

  /** Path part for operation `saveQuestion()` */
  static readonly SaveQuestionPath = '/question';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveQuestion()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveQuestion$Response(params: SaveQuestion$Params, context?: HttpContext): Observable<StrictHttpResponse<Question>> {
    return saveQuestion(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveQuestion$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveQuestion(params: SaveQuestion$Params, context?: HttpContext): Observable<Question> {
    return this.saveQuestion$Response(params, context).pipe(
      map((r: StrictHttpResponse<Question>): Question => r.body)
    );
  }

  /** Path part for operation `findQuestionById()` */
  static readonly FindQuestionByIdPath = '/question/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findQuestionById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findQuestionById$Response(params: FindQuestionById$Params, context?: HttpContext): Observable<StrictHttpResponse<Question>> {
    return findQuestionById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findQuestionById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findQuestionById(params: FindQuestionById$Params, context?: HttpContext): Observable<Question> {
    return this.findQuestionById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Question>): Question => r.body)
    );
  }

  /** Path part for operation `deleteQuestionById()` */
  static readonly DeleteQuestionByIdPath = '/question/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteQuestionById()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteQuestionById$Response(params: DeleteQuestionById$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteQuestionById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteQuestionById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteQuestionById(params: DeleteQuestionById$Params, context?: HttpContext): Observable<void> {
    return this.deleteQuestionById$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `findAllQuestionsByUser()` */
  static readonly FindAllQuestionsByUserPath = '/question/user';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllQuestionsByUser()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllQuestionsByUser$Response(params?: FindAllQuestionsByUser$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseQuestion>> {
    return findAllQuestionsByUser(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllQuestionsByUser$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllQuestionsByUser(params?: FindAllQuestionsByUser$Params, context?: HttpContext): Observable<PageResponseQuestion> {
    return this.findAllQuestionsByUser$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseQuestion>): PageResponseQuestion => r.body)
    );
  }

  /** Path part for operation `searchQuestions()` */
  static readonly SearchQuestionsPath = '/question/search';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `searchQuestions()` instead.
   *
   * This method doesn't expect any request body.
   */
  searchQuestions$Response(params: SearchQuestions$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseQuestion>> {
    return searchQuestions(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `searchQuestions$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  searchQuestions(params: SearchQuestions$Params, context?: HttpContext): Observable<PageResponseQuestion> {
    return this.searchQuestions$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseQuestion>): PageResponseQuestion => r.body)
    );
  }

}
