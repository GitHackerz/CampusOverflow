/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Report } from '../../models/report';

export interface FindReportById$Params {
  id: number;
}

export function findReportById(http: HttpClient, rootUrl: string, params: FindReportById$Params, context?: HttpContext): Observable<StrictHttpResponse<Report>> {
  const rb = new RequestBuilder(rootUrl, findReportById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Report>;
    })
  );
}

findReportById.PATH = '/report/{id}';
