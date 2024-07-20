/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Tag } from '../../models/tag';
import { TagRequestNew } from '../../models/tag-request-new';

export interface SaveTag$Params {
      body: TagRequestNew
}

export function saveTag(http: HttpClient, rootUrl: string, params: SaveTag$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
  const rb = new RequestBuilder(rootUrl, saveTag.PATH, 'post');
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

saveTag.PATH = '/tag';
