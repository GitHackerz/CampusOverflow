/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Tag } from '../../models/tag';
import { TagRequestUpdate } from '../../models/tag-request-update';

export interface UpdateTag$Params {
      body: TagRequestUpdate
}

export function updateTag(http: HttpClient, rootUrl: string, params: UpdateTag$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
  const rb = new RequestBuilder(rootUrl, updateTag.PATH, 'put');
  if (params) {
    rb.body(params.body, 'application/json');
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

updateTag.PATH = '/tag';
