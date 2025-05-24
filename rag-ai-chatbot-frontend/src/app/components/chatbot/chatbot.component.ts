import { Component } from '@angular/core';
import {RagChatService} from '../../services/rag-chat.service';
import {MarkdownComponent, MarkdownModule} from 'ngx-markdown';
import {FormsModule} from '@angular/forms';
import {QueryDto, ResponseDto} from '../../interfaces/dto';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

@Component({
  selector: 'app-chatbot',
  imports: [
    MarkdownComponent,
    MarkdownModule,
    FormsModule,
    MatProgressSpinnerModule,
  ],
  templateUrl: './chatbot.component.html',
  styleUrl: './chatbot.component.scss'
})
export class ChatbotComponent {

  queryDto: QueryDto = {
    query: ""
  };
  responseDto: ResponseDto = {
    response: ""
  };

  typingSpeed: number = 20;
  i: number = 0;

  searchTheResponse: boolean = false;

  responseTypewriter = "";

  constructor(private chatService: RagChatService) { }


  chat() {
    this.responseDto.response = "";
    this.searchTheResponse = true;
    this.chatService.sendChat(this.queryDto).subscribe({
      next: (data: ResponseDto)=>
      {
        this.typing(data.response);
        this.searchTheResponse = false;
      },
      error: (error)=> console.log(error),
    })
  }

  typing(text: string){
    if (this.i < text.length) {
      this.responseDto.response += text.charAt(this.i);
      this.i++;
      setTimeout(()=>this.typing(text), this.typingSpeed);
    }else{
      this.i = 0;
    }
  }


}
