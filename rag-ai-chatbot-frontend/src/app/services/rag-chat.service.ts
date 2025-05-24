import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {QueryDto, ResponseDto} from '../interfaces/dto';

@Injectable({
  providedIn: 'root'
})
export class RagChatService {

  base_url = 'http://localhost:8080/api/chat';

  constructor(private http: HttpClient) { }

  sendChat(queryDto: QueryDto): Observable<ResponseDto>{
    return this.http.post<ResponseDto>(this.base_url, queryDto);
  }
}
