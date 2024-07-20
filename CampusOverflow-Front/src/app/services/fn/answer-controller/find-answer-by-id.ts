/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Answer } from '../../models/answer';

export interface FindAnswerById$Params {
  id: number;
}

export function findAnswerById(http: HttpClient, rootUrl: string, params: FindAnswerById$Params, context?: HttpContext): Observable<StrictHttpResponse<Answer>> {
  const rb = new RequestBuilder(rootUrl, findAnswerById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Answer>;
    })
  );
}

findAnswerById.PATH = '/answer/{id}';
