package ca.roumani.calaculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calc extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        final EditText op1 = (EditText) findViewById(R.id.operand1);
        final EditText op2 = (EditText) findViewById(R.id.operand2);
        Button button = (Button) findViewById(R.id.operation);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                double a, b;

                try
                {
                    a = Double.parseDouble(op1.getText().toString());
                    b = Double.parseDouble(op2.getText().toString());
                }
                catch (Exception e)
                {
                    a = 0;
                    b = 0;
                }
                String answer = (b == 0) ? "Div By Zero" : a / b + "";
                //showMe("" + answer);
                TextView result = (TextView) findViewById(R.id.result);
                result.setText(answer);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showMe(String msg)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
