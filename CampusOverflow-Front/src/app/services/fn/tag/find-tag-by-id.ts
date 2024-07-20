/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Tag } from '../../models/tag';

export interface FindTagById$Params {
  id: number;
}

export function findTagById(http: HttpClient, rootUrl: string, params: FindTagById$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
  const rb = new RequestBuilder(rootUrl, findTagById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Tag>;
    })
  );
}

findTagById.PATH = '/tag/{id}';
