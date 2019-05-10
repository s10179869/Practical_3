package sg.edu.np.practical3;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CountDownTimer cdt;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.text);
    }

    public void on1min(View v){startTimer(1);}
    public void on2min(View v) {startTimer(2);}
    public void on3min(View v) {startTimer(3);}

    private void startTimer(int duration)
    {
        cdt = new CountDownTimer(duration * 60000, 1000){
            @Override
            public void onTick(long timeToFinish){
                long minutes = timeToFinish/60000;
                long seconds = (timeToFinish%60000)/1000;
                txt.setText(""+ minutes + ":" + seconds);
            }

            @Override
            public void onFinish(){
                txt.setText("00:00");

                Toast tt = Toast.makeText(MainActivity.this, "Times up!", Toast.LENGTH_LONG);
                tt.show();

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Title")
                        .setMessage("Time's up!")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        })
                        .show();
            }
        };
        cdt.start();
    }
}

