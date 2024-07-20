/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Question } from '../../models/question';

export interface FindQuestionById$Params {
  id: number;
}

export function findQuestionById(http: HttpClient, rootUrl: string, params: FindQuestionById$Params, context?: HttpContext): Observable<StrictHttpResponse<Question>> {
  const rb = new RequestBuilder(rootUrl, findQuestionById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
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

findQuestionById.PATH = '/question/{id}';
