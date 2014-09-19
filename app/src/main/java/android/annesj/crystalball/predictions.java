package android.annesj.crystalball;

public class predictions {
//this creates a private class for predictions and answers to use later down in the code
    private static predictions predictions;
    private String[] answers;
//this is where we will use the classes that we created above
    private predictions(){
//        this string contains the responses the will show up on the screen for each shake
        answers = new String[]{
                "Your wishes will come trues.",
                "Your wishes will never come true."
        };
    }
//this is where we will use the classes that we created above
    public static predictions get() {
        if(predictions == null){
            predictions = new predictions();
        }
        return predictions;
    }
    public String getprediction(){
        return answers[1];
    }
}
