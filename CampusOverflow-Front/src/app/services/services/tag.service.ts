/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { deleteTagById } from '../fn/tag/delete-tag-by-id';
import { DeleteTagById$Params } from '../fn/tag/delete-tag-by-id';
import { findAllTags } from '../fn/tag/find-all-tags';
import { FindAllTags$Params } from '../fn/tag/find-all-tags';
import { findTagById } from '../fn/tag/find-tag-by-id';
import { FindTagById$Params } from '../fn/tag/find-tag-by-id';
import { findTagByName } from '../fn/tag/find-tag-by-name';
import { FindTagByName$Params } from '../fn/tag/find-tag-by-name';
import { saveTag } from '../fn/tag/save-tag';
import { SaveTag$Params } from '../fn/tag/save-tag';
import { searchTags } from '../fn/tag/search-tags';
import { SearchTags$Params } from '../fn/tag/search-tags';
import { Tag } from '../models/tag';
import { updateTag } from '../fn/tag/update-tag';
import { UpdateTag$Params } from '../fn/tag/update-tag';


/**
 * Tag API
 */
@Injectable({ providedIn: 'root' })
export class TagService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `findAllTags()` */
  static readonly FindAllTagsPath = '/tag';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllTags()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllTags$Response(params?: FindAllTags$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Tag>>> {
    return findAllTags(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllTags$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllTags(params?: FindAllTags$Params, context?: HttpContext): Observable<Array<Tag>> {
    return this.findAllTags$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Tag>>): Array<Tag> => r.body)
    );
  }

  /** Path part for operation `updateTag()` */
  static readonly UpdateTagPath = '/tag';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateTag()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateTag$Response(params: UpdateTag$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
    return updateTag(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateTag$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateTag(params: UpdateTag$Params, context?: HttpContext): Observable<Tag> {
    return this.updateTag$Response(params, context).pipe(
      map((r: StrictHttpResponse<Tag>): Tag => r.body)
    );
  }

  /** Path part for operation `saveTag()` */
  static readonly SaveTagPath = '/tag';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveTag()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveTag$Response(params: SaveTag$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
    return saveTag(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveTag$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveTag(params: SaveTag$Params, context?: HttpContext): Observable<Tag> {
    return this.saveTag$Response(params, context).pipe(
      map((r: StrictHttpResponse<Tag>): Tag => r.body)
    );
  }

  /** Path part for operation `findTagById()` */
  static readonly FindTagByIdPath = '/tag/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findTagById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTagById$Response(params: FindTagById$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
    return findTagById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findTagById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTagById(params: FindTagById$Params, context?: HttpContext): Observable<Tag> {
    return this.findTagById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Tag>): Tag => r.body)
    );
  }

  /** Path part for operation `deleteTagById()` */
  static readonly DeleteTagByIdPath = '/tag/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteTagById()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTagById$Response(params: DeleteTagById$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteTagById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteTagById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTagById(params: DeleteTagById$Params, context?: HttpContext): Observable<void> {
    return this.deleteTagById$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `searchTags()` */
  static readonly SearchTagsPath = '/tag/search';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `searchTags()` instead.
   *
   * This method doesn't expect any request body.
   */
  searchTags$Response(params: SearchTags$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Tag>>> {
    return searchTags(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `searchTags$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  searchTags(params: SearchTags$Params, context?: HttpContext): Observable<Array<Tag>> {
    return this.searchTags$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Tag>>): Array<Tag> => r.body)
    );
  }

  /** Path part for operation `findTagByName()` */
  static readonly FindTagByNamePath = '/tag/name/{name}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findTagByName()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTagByName$Response(params: FindTagByName$Params, context?: HttpContext): Observable<StrictHttpResponse<Tag>> {
    return findTagByName(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findTagByName$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTagByName(params: FindTagByName$Params, context?: HttpContext): Observable<Tag> {
    return this.findTagByName$Response(params, context).pipe(
      map((r: StrictHttpResponse<Tag>): Tag => r.body)
    );
  }

}
