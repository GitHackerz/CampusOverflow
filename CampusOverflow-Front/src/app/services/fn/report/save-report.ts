/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Report } from '../../models/report';
import { ReportRequestNewDto } from '../../models/report-request-new-dto';

export interface SaveReport$Params {
      body: ReportRequestNewDto
}

export function saveReport(http: HttpClient, rootUrl: string, params: SaveReport$Params, context?: HttpContext): Observable<StrictHttpResponse<Report>> {
  const rb = new RequestBuilder(rootUrl, saveReport.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
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

saveReport.PATH = '/report';
