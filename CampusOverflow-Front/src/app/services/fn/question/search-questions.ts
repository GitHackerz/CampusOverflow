/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseQuestion } from '../../models/page-response-question';

export interface SearchQuestions$Params {
  page?: number;
  size?: number;
  query: string;
}

export function searchQuestions(http: HttpClient, rootUrl: string, params: SearchQuestions$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseQuestion>> {
  const rb = new RequestBuilder(rootUrl, searchQuestions.PATH, 'get');
  if (params) {
    rb.query('page', params.page, {});
    rb.query('size', params.size, {});
    rb.query('query', params.query, {});
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

searchQuestions.PATH = '/question/search';
