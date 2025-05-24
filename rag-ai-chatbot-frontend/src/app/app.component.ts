import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MarkdownModule} from 'ngx-markdown';

// @ts-ignore
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MarkdownModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'rag-ai-chatbot-frontend';
}
