package com.company;

import java.util.HashMap;

public class Quiz {
    HashMap<Integer,String> questions = new HashMap();
    HashMap<Integer,String> answers = new HashMap();

    public Quiz() {
        //Questions
        this.questions.put(100,"Question for 100: What is 1+1");
        this.questions.put(200,"Question for 200: What is 2+2");
        this.questions.put(300,"Question for 300: What is 3+3");
        this.questions.put(400,"Question for 400: What is 4+4");
        this.questions.put(500,"Question for 500: What is 5+5");
        this.questions.put(600,"Question for 600: What is 6*6");

        //Answers
        this.answers.put(100,"2");
        this.answers.put(200,"4");
        this.answers.put(300,"6");
        this.answers.put(400,"8");
        this.answers.put(500,"10");
        this.answers.put(600,"36");
    }

    public String getQuestions(int key) {
        String question = questions.get(key);
        questions.remove(key);
        return question;
    }

    public String getAnswers(int key) {
        return answers.get(key);
    }
    public boolean listEmpty(){
        return questions.isEmpty();
    }
}


