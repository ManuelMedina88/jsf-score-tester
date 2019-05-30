/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Alfredo
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import model.ScoreCalculator;

@ManagedBean(name="processScore")
@SessionScoped
public class ProcessScore implements Serializable{
    
    @ManagedProperty( value="#{receiveScore}")
    private ReceiveScore receiveScore;
    
    private int score;
    private final ScoreCalculator calculator;
    private String level;

    public ProcessScore() {
        calculator = new ScoreCalculator();
    }

    public ReceiveScore getReceiveScore() {
        return receiveScore;
    }

    public void setReceiveScore(ReceiveScore receiveScore) {
        this.receiveScore = receiveScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    
    
    public void calculateScore(){
    
        try{
            
            this.score = receiveScore.getScore();
        
            level = calculator.calculateScore(score);
        
            FacesContext.getCurrentInstance().getExternalContext().redirect("result.xhtml");
    
            
            
        }catch(IOException ex){
        
            Logger.getLogger(ProcessScore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
}
