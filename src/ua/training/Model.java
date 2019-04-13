package ua.training;

import java.util.ArrayList;

public class Model {
    public static final int RAND_MAX = Integer.MAX_VALUE;
    private boolean inGame;
    private int secretNumber;
    private int min, max;
    private ArrayList<String> inputs;
    private ArrayList<String> results;

    public Model() {
        inGame = true;
        inputs = new ArrayList<String>();
        results = new ArrayList<String>();
}

    public int rand(int min, int max) {
        secretNumber = min + (int) (Math.random() * max + 0.5);
        this.min = min+1;
        this.max = max-1;
        return secretNumber;
    }

    public int rand() {
        secretNumber = 0 + (int) (Math.random() * RAND_MAX);
        this.min = 0;
        this.max = RAND_MAX;
        return secretNumber;
    }

    public boolean checkInGame() {
        return inGame;
    }

    public String checkRange(int value) {
        String answer;
        this.logHistory(View.HISTORY_INT, Integer.toString(value));

        if (value < secretNumber) answer = correctRangeMore(value);
        else if (value > secretNumber) answer = correctRangeLess(value);
        else {
            answer = View.VICTORY;
            inGame = false;
        }

        return answer;
    }

    public String inRange() {
        String output = "between " + min + " and " + max;
        return output;
    }

    private String correctRangeMore(int value) {
        String answer = View.MORE;
        if (value >= min) min = value + 1;
        else if (value < min) answer += View.OUT;
        return answer;
    }

    private String correctRangeLess(int value) {
        String answer = View.LESS;
        if (value <= max) max = value - 1;
        else if (value > max) answer += View.OUT;
        return answer;
    }

    public void logHistory(String result, String input) {
        inputs.add(input);
        results.add(result);
    }

    public ArrayList<String> getInputs() {
        return inputs;
    }

    public ArrayList<String> getResults() {
        return results;
    }
}
