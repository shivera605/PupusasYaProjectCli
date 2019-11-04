package pupusas.app.pupusasyaprojectcli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m = findViewById(R.id.tvMessage);

        Intent i = this.getIntent();
        String name = i.getStringExtra("n");
        String lastName = i.getStringExtra("a");
        m.setText("Bienvenid@ " + name + " " + lastName);
    }
}
