package com.example.abgsuy.duoihinhbatchu;

/**
 * Created by Abgsuy on 04/05/2017.
 */

public class ObjectGames {
    private int idImage;
    private String trueAnswer;
    private String chooseAnswer;

    public ObjectGames(int idImage, String trueAnswer, String chooseAnswer) {
        this.idImage = idImage;
        this.trueAnswer = trueAnswer;
        this.chooseAnswer = chooseAnswer;
    }

    public int getIdImage() {
        return idImage;
    }


    public String getTrueAnswer() {
        return trueAnswer;
    }


    public String getChooseAnswer() {
        return chooseAnswer;
    }

}
