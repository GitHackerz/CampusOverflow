/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Question } from '../../models/question';
import { QuestionRequest } from '../../models/question-request';

export interface SaveQuestion$Params {
      body: QuestionRequest
}

export function saveQuestion(http: HttpClient, rootUrl: string, params: SaveQuestion$Params, context?: HttpContext): Observable<StrictHttpResponse<Question>> {
  const rb = new RequestBuilder(rootUrl, saveQuestion.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Question>;
    })
  );
}

saveQuestion.PATH = '/question';
