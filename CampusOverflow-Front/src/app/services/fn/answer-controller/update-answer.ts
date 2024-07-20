/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Answer } from '../../models/answer';
import { AnswerRequestUpdateDto } from '../../models/answer-request-update-dto';

export interface UpdateAnswer$Params {
      body: AnswerRequestUpdateDto
}

export function updateAnswer(http: HttpClient, rootUrl: string, params: UpdateAnswer$Params, context?: HttpContext): Observable<StrictHttpResponse<Answer>> {
  const rb = new RequestBuilder(rootUrl, updateAnswer.PATH, 'patch');
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

updateAnswer.PATH = '/answer';
