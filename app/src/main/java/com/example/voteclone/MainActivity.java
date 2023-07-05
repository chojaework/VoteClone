package com.example.voteclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    int vCount[] = new int[3];
    ImageView[] imgV = new ImageView[3];
    int[] imgID = {R.id.img1, R.id.img2, R.id.img3};
    String Candidate[] = {"재원","현수","정원"};
    String Voter[] = {};
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android:setTitle("회장선거 투표");

        final int[] VotePeople = {0};
        TextView num = findViewById(R.id.textView2);

        et_name = findViewById(R.id.et_name);
        btn = (Button)findViewById(R.id.btn_endvote);

        for(int i = 0; i < imgID.length; i++) {
            final int index;
            index = i;
            imgV[index] = (ImageView) findViewById(imgID[index]);
            imgV[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = et_name.getText().toString().trim();
                    if (name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("투표하시겠습니까?")
                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String[] updatedVoter = new String[Voter.length + 1];
                                        System.arraycopy(Voter, 0, updatedVoter, 0, Voter.length);
                                        updatedVoter[Voter.length] = name;
                                        Voter = updatedVoter;

                                        et_name.setText("");
                                        VotePeople[0]++;
                                        vCount[index]++;
                                        Toast.makeText(getApplicationContext(), Candidate[index] + "에게 투표하셨습니다.", Toast.LENGTH_SHORT).show();
                                        num.setText(VotePeople[0] + "명");
                                    }
                                })
                                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // 아무 변화 없음
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            });
        }
        btn = (Button) findViewById(R.id.btn_endvote);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ResultVote.class);
                intent.putExtra("vCount",vCount);
                intent.putExtra("Candidate", Candidate);
                intent.putExtra("Voter", Voter);
                startActivity(intent);
            }
        });
    }
}