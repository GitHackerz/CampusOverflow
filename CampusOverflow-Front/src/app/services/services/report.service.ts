/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { deleteReportById } from '../fn/report/delete-report-by-id';
import { DeleteReportById$Params } from '../fn/report/delete-report-by-id';
import { findAllReportsByUser } from '../fn/report/find-all-reports-by-user';
import { FindAllReportsByUser$Params } from '../fn/report/find-all-reports-by-user';
import { findReportById } from '../fn/report/find-report-by-id';
import { FindReportById$Params } from '../fn/report/find-report-by-id';
import { Report } from '../models/report';
import { saveReport } from '../fn/report/save-report';
import { SaveReport$Params } from '../fn/report/save-report';
import { searchReports } from '../fn/report/search-reports';
import { SearchReports$Params } from '../fn/report/search-reports';
import { updateReport } from '../fn/report/update-report';
import { UpdateReport$Params } from '../fn/report/update-report';


/**
 * Report API
 */
@Injectable({ providedIn: 'root' })
export class ReportService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `updateReport()` */
  static readonly UpdateReportPath = '/report';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateReport()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateReport$Response(params: UpdateReport$Params, context?: HttpContext): Observable<StrictHttpResponse<Report>> {
    return updateReport(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateReport$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateReport(params: UpdateReport$Params, context?: HttpContext): Observable<Report> {
    return this.updateReport$Response(params, context).pipe(
      map((r: StrictHttpResponse<Report>): Report => r.body)
    );
  }

  /** Path part for operation `saveReport()` */
  static readonly SaveReportPath = '/report';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveReport()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveReport$Response(params: SaveReport$Params, context?: HttpContext): Observable<StrictHttpResponse<Report>> {
    return saveReport(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveReport$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveReport(params: SaveReport$Params, context?: HttpContext): Observable<Report> {
    return this.saveReport$Response(params, context).pipe(
      map((r: StrictHttpResponse<Report>): Report => r.body)
    );
  }

  /** Path part for operation `findReportById()` */
  static readonly FindReportByIdPath = '/report/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findReportById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findReportById$Response(params: FindReportById$Params, context?: HttpContext): Observable<StrictHttpResponse<Report>> {
    return findReportById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findReportById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findReportById(params: FindReportById$Params, context?: HttpContext): Observable<Report> {
    return this.findReportById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Report>): Report => r.body)
    );
  }

  /** Path part for operation `deleteReportById()` */
  static readonly DeleteReportByIdPath = '/report/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteReportById()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteReportById$Response(params: DeleteReportById$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteReportById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteReportById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteReportById(params: DeleteReportById$Params, context?: HttpContext): Observable<void> {
    return this.deleteReportById$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `findAllReportsByUser()` */
  static readonly FindAllReportsByUserPath = '/report/user/{userId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllReportsByUser()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllReportsByUser$Response(params: FindAllReportsByUser$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return findAllReportsByUser(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllReportsByUser$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllReportsByUser(params: FindAllReportsByUser$Params, context?: HttpContext): Observable<{
}> {
    return this.findAllReportsByUser$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

  /** Path part for operation `searchReports()` */
  static readonly SearchReportsPath = '/report/search';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `searchReports()` instead.
   *
   * This method doesn't expect any request body.
   */
  searchReports$Response(params: SearchReports$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return searchReports(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `searchReports$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  searchReports(params: SearchReports$Params, context?: HttpContext): Observable<{
}> {
    return this.searchReports$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

}
