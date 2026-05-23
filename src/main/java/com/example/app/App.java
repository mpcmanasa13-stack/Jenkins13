package com.example.app;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {

    public static void main(String[] args) {

        try {

            JSONParser parser = new JSONParser();

            JSONObject quiz =
            (JSONObject) parser.parse(new FileReader("quiz.json"));

            String question = (String) quiz.get("question");
            String optionA = (String) quiz.get("optionA");
            String optionB = (String) quiz.get("optionB");
            String answer = (String) quiz.get("answer");

            Scanner sc = new Scanner(System.in);

            System.out.println("===== Maven Quiz App =====");

            System.out.println(question);

            System.out.println("A. " + optionA);
            System.out.println("B. " + optionB);

            System.out.print("Enter Answer (A/B): ");

            String userAnswer = sc.nextLine();

            if(userAnswer.equalsIgnoreCase(answer)){

                System.out.println("Correct Answer!");
                System.out.println("Score: 1/1");

            }
            else{

                System.out.println("Wrong Answer!");
                System.out.println("Score: 0/1");

            }

            System.out.println("Quiz Completed Successfully.");

        }
        catch(Exception e){

            e.printStackTrace();

        }
    }
}
