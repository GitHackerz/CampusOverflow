/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseQuestion } from '../../models/page-response-question';

export interface FindAllQuestions$Params {
  page?: number;
  size?: number;
}

export function findAllQuestions(http: HttpClient, rootUrl: string, params?: FindAllQuestions$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseQuestion>> {
  const rb = new RequestBuilder(rootUrl, findAllQuestions.PATH, 'get');
  if (params) {
    rb.query('page', params.page, {});
    rb.query('size', params.size, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PageResponseQuestion>;
    })
  );
}

findAllQuestions.PATH = '/question';
