/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Vote } from '../../models/vote';
import { VoteRequestNewDto } from '../../models/vote-request-new-dto';

export interface SaveVote$Params {
      body: VoteRequestNewDto
}

export function saveVote(http: HttpClient, rootUrl: string, params: SaveVote$Params, context?: HttpContext): Observable<StrictHttpResponse<Vote>> {
  const rb = new RequestBuilder(rootUrl, saveVote.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Vote>;
    })
  );
}

saveVote.PATH = '/vote';
