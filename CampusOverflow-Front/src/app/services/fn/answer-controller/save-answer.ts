/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Answer } from '../../models/answer';
import { AnswerRequestNewDto } from '../../models/answer-request-new-dto';

export interface SaveAnswer$Params {
      body: AnswerRequestNewDto
}

export function saveAnswer(http: HttpClient, rootUrl: string, params: SaveAnswer$Params, context?: HttpContext): Observable<StrictHttpResponse<Answer>> {
  const rb = new RequestBuilder(rootUrl, saveAnswer.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
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

saveAnswer.PATH = '/answer';
