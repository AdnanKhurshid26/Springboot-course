package com.adnan.springboot.firstrestapi.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {
    private SurveyService surveyService;

    public SurveyResource(SurveyService surveyService) {
        super();
        this.surveyService = surveyService;
    }

    @GetMapping("/surveys")
    public List<Survey> retrieveAllSurveys() {
        return surveyService.retrieveAllSurveys();
    }

    @GetMapping("/surveys/{surveyId}")
    public Survey retrieveSurvey(@PathVariable String surveyId) {
        Survey survey =  surveyService.retrieveSurvey(surveyId);

        if(survey == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found");
        }

        return survey;
    }
    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveSurveyQuestions(@PathVariable String surveyId) {
        List<Question>  questions =  surveyService.retrievSurveyQuestions(surveyId);

        if(questions == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Questions not found");
        }

        return questions;
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveSpecificSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
        Question question =  surveyService.retrieveSpecificSurveyQuestion(surveyId, questionId);

        if(question == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found");
        }

        return question;
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId,@RequestBody Question newQuestion) {
       String qId =  surveyService.addNewSurveyQuestion(surveyId, newQuestion);

       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{qId}").buildAndExpand(qId).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
         surveyService.deleteSurveyQuestion(surveyId, questionId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId, @RequestBody Question updatedQuestion) {
        surveyService.updateSurveyQuestion(surveyId, questionId, updatedQuestion);

        return ResponseEntity.noContent().build();
    }
}
