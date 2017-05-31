package com.ood.sequencingnumber;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    Presenter presenter = null;
    int[] layer1, layer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(presenter == null)
            presenter = new Presenter(this);
    }
    public void onPlay(View view) {
        presenter.newGame();
        layer1 = presenter.getLayer(1);
        layer2 = presenter.getLayer(2);
        for (int i = 0;i<layer1.length;i++) {
            String buttonId = "Button" + (i+1);
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            Button b = (Button)findViewById(resId);
            b.setText(""+layer1[i]);
        }
    }

    public void onPress(View view) {
        Button b =  (Button) findViewById(view.getId());
        String value = b.getText()+"";
        String toBeSet = presenter.onPress(value);
        b.setText(toBeSet);
    }
    public void onGameEnd(long endTime, long averageTime) {
        String result = "Your Finishing Time: "+endTime/1000.0 + " seconds\nYour Average Time: " + averageTime/1000.0 + " seconds\n\n";
        if (endTime < averageTime) {
            result+="Congratulations! You are good to go. It's time to do something productive";
        } else if (endTime > averageTime) {
            result+="You are below your own average. You should go to take some rest.";
        } else {
            result+="You are exactly matched with your average. This may be your first time, you should play more games in order to acquire your true average.";
        }

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Finished");
        alertDialog.setMessage(result);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
