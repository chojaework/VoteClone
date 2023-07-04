package com.example.voteclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    int vCount[] = new int[3];
    ImageView[] imgV = new ImageView[3];
    int[] imgID = {R.id.img1, R.id.img2, R.id.img3};
    String Name[] = {"재원","현수","정원"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android:setTitle("회장선거 투표");

        final int[] VotePeople = {0};
        TextView num = findViewById(R.id.textView2);

        btn = (Button)findViewById(R.id.btn_endvote);

        for(int i = 0; i < imgID.length; i++) {
            final int index;
            index = i;
            imgV[index] = (ImageView) findViewById(imgID[index]);
            imgV[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VotePeople[0]++;
                    vCount[index]++;
                    Toast.makeText(getApplicationContext(), Name[index] + "에게 투표하셨습니다.",Toast.LENGTH_SHORT).show();
                    num.setText( VotePeople[0] + "명");
                }
            });
        }
        btn = (Button) findViewById(R.id.btn_endvote);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultVote.class);
                intent.putExtra("vCount",vCount);
                intent.putExtra("Name",Name);
                startActivity(intent);
            }
        });
    }
}