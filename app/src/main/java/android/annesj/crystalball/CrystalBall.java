package android.annesj.crystalball;
//the activities that we are going to use for running the program
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.widget.TextView;
import android.widget.Toast;


public class CrystalBall extends Activity {
    private TextView answerText;
//creates the
    private SensorManager SensorManager;
    private Sensor accelerometer;
    private float Acceleration;
    private float CurrentAcceleration;
    private float PreviousAcceleration;

    private final SensorEventListener sensorListener= new SensorEventListener(){
        @Override
        public void onSensorChanged(SensorEvent event){
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        PreviousAcceleration = CurrentAcceleration;
        CurrentAcceleration = FloatMath.sqrt(x * x + y * y + z * z);
        float delta = CurrentAcceleration-PreviousAcceleration;
        Acceleration = Acceleration*0.9f + delta;
        if(Acceleration = 18){
            Toast toast = Toast.makeText(getApplication(), "Device has shaken", Toast.LENGTH_SHORT)
            toast.show();
        }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy){

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crystal_ball);

        SensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        acceleration = 0.0f;
        CurrentAcceleration = SensorManager.GRAVITY_EARTH;
        PreviousAcceleration = SensorManager.GRAVITY_EARTH;

        answerText = (TextView) findViewById(R.id.answerText);
        answerText.setText(predictions.get().getprediction());
    }

    @Override
    protected void onResume() {
        super.onResume();
        SensorManager.registerListener(sensorListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SensorManager.unregisterListener(sensorListener);
    }
}
