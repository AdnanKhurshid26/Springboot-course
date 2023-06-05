package com.adnan.springboot.firstrestapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java .util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    private static List<Survey> surveys = new ArrayList<>();

    static{
        Question question1 = new Question("Question1",
        "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
Question question2 = new Question("Question2",
        "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
Question question3 = new Question("Question3",
        "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

List<Question> questions = new ArrayList<>(Arrays.asList(question1,
        question2, question3));

Survey survey = new Survey("Survey1", "My Favorite Survey",
        "Description of the Survey", questions);

surveys.add(survey);

    }

    public List<Survey> retrieveAllSurveys() {
        return surveys;
    }

    public Survey retrieveSurvey(String surveyId) {
        Predicate<? super Survey> predicate = survey -> survey.getId().equals(surveyId);

        return surveys.stream().filter(predicate).findFirst().get();
    }

    public List<Question> retrievSurveyQuestions(String surveyId) {
        Survey survey = retrieveSurvey(surveyId);

        if(survey == null){
            return null;
        }

        return survey.getQuestions();
    }

    public Question retrieveSpecificSurveyQuestion(String surveyId, String questionId) {
        Survey survey = retrieveSurvey(surveyId);

        if(survey == null){
            return null;
        }

        Predicate<? super Question> predicate = question -> question.getId().equals(questionId);

        return survey.getQuestions().stream().filter(predicate).findFirst().get();
    }

    public String addNewSurveyQuestion(String surveyId, Question newQuestion) {
        Survey survey = retrieveSurvey(surveyId);

        SecureRandom random = new SecureRandom();

        String randomId = new BigInteger(32, random).toString();

        newQuestion.setId(randomId);

        survey.getQuestions().add(newQuestion);

        return randomId;
    }

    public void deleteSurveyQuestion(String surveyId, String questionId) {
        Survey survey = retrieveSurvey(surveyId);

        Predicate<? super Question> predicate = question -> question.getId().equals(questionId);

        survey.getQuestions().removeIf(predicate);
    }

    public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
        Survey survey = retrieveSurvey(surveyId);

        Predicate<? super Question> predicate = q -> q.getId().equals(questionId);

        survey.getQuestions().removeIf(predicate);

        survey.getQuestions().add(question);
    }
}
