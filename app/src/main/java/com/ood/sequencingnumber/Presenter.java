package com.ood.sequencingnumber;

/**
 * Created by ood on 31-May-17.
 */

public class Presenter {
    MainActivity view = null;
    Game game;
    Stat stat;
    public Presenter(MainActivity view) {
        this.view = view;
        stat = new Stat();
    }
    public void newGame() {
        game = new Game();
    }
    public int[] getLayer(int number) {
        if (number == 1) {
            return game.getLayer1();
        } else if (number == 2) {
            return game.getLayer2();
        }
        return null;
    }
    public String onPress(String valueStr) {
        if (valueStr == "") {return "";}
        int value = Integer.parseInt(valueStr);
        if (value <= 20 && game.isNextNumber(value)) {
            return game.getNextNumber()+"";
        } else if (value <=39 && game.isNextNumber(value)) {
            return "";
        } else if (value == 40 && game.isNextNumber(value)){
            stat.addResult(game.getEndTime());
            endGame();
            return "";
        }
        return valueStr;
    }

    public void endGame() {
         view.onGameEnd(game.getEndTime() ,stat.getAverage());
    }
}
