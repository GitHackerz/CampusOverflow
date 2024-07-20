/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';


export interface FindAllAnswersByQuestionId$Params {
  questionId: number;
}

export function findAllAnswersByQuestionId(http: HttpClient, rootUrl: string, params: FindAllAnswersByQuestionId$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
  const rb = new RequestBuilder(rootUrl, findAllAnswersByQuestionId.PATH, 'get');
  if (params) {
    rb.path('questionId', params.questionId, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<{
      }>;
    })
  );
}

findAllAnswersByQuestionId.PATH = '/answer/question/{questionId}';
