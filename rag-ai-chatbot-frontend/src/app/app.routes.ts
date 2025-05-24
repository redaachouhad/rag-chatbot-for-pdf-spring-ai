import { Routes } from '@angular/router';
import {ChatbotComponent} from './components/chatbot/chatbot.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'chat',
    pathMatch: 'full',
  },
  {
    path: 'chat',
    component: ChatbotComponent
  },

];
