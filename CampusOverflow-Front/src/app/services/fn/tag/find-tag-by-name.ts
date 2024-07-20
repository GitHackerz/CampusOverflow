/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Tag } from '../../models/tag';

export interface FindTagByName$Params {
  name: string;
}

export function findTagByName(http: HttpClient, rootUrl: string, params: FindTagByName$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
  const rb = new RequestBuilder(rootUrl, findTagByName.PATH, 'get');
  if (params) {
    rb.path('name', params.name, {});
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

findTagByName.PATH = '/tag/name/{name}';
