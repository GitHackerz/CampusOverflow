import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../../../../services/services/question.service";
import {PageResponseQuestion} from "../../../../services/models/page-response-question";

@Component({
  selector: 'app-questions-list',
  standalone: true,
  imports: [],
  templateUrl: './questions-list.component.html',
  styleUrl: './questions-list.component.scss'
})
export class QuestionsListComponent implements OnInit{
  page = 0
  size = 10
  questionsResponse: PageResponseQuestion = {}

  constructor(
    private questionsService: QuestionService,
  ) {
  }

  ngOnInit() {
    this.findAllQuestions()
  }

  private findAllQuestions() {

    this.questionsService.findAllQuestions({
      page: this.page,
      size: this.size,
    }).subscribe({
      next: (questions) => {
        this.questionsResponse = questions
      },
      error: (error) => {
        console.error(error)
      }
    })
  }
}
