/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alfredo
 */
public class ScoreCalculator {

    public ScoreCalculator() {
    }
    
    public String calculateScore(int score){
        
        String level = "Beginner";
        
        if(score <= 250)
            level = "Beginner";
        else if(score <= 600)
            level = "Intermediate";
        else if(score <= 900)
            level = "Advanced";
        else if(score >= 901 )
            level = "Expert";
        
        return level;
    }
    
}
