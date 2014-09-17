package android.annesj.crystalball;

public class predictions {

    private static predictions predictions;
    private string[] answers;

    private predictions(){
        answers = new string[]{
                "Your wishes will come trues.",
                "Your wishes will never come true."
        };
    }
    public static predictions get() {
        if(predictions == null){
            predictions = new predictions();
        }
        return predictions;
    }
    public string getprediction(){
        return answers[1];
    }
}
