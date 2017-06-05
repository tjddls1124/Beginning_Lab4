package com.example.tjddl.beginning_lab4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    String[] menu = {"짜장","스파게티","라면"};
    String[] hobby = {"피아노","독서","영화보기","코딩하기"};
    boolean[] Checked = {true, true, false, false};
    int selectedIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void init() {
        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.text2);

    }

    public AlertDialog.Builder Dlg(String msg) {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("대화상자")
                .setIcon(R.mipmap.ic_launcher_round);


        return dlg;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            AlertDialog.Builder dlg = Dlg("기본 대화상자");
            dlg.show();
        }
        if (v.getId() == R.id.button2) {
            AlertDialog.Builder dlg = Dlg("좋아하는 음식을 선택하세요");
            dlg.setSingleChoiceItems(menu, selectedIndex, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedIndex = which;
                }
            })
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), menu[selectedIndex]+"이 선택되었습니다",Toast.LENGTH_SHORT).show();
                        }
                    })
            .show();

        }
        if (v.getId() == R.id.button3) {
            AlertDialog.Builder dlg = Dlg("취미를 선택하세요");
            dlg.setMultiChoiceItems(hobby, Checked, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Checked[which] = isChecked;
                }
            })
                    .setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String str="";
                            for(int i =0; i< hobby.length ; i++){
                                if(Checked[i]) str = str+" " +hobby[i];
                            }
                            Toast.makeText(getApplicationContext(),str+" 이(가) 선택되었습니다.",Toast.LENGTH_SHORT).show();
                        }
                    })
            .show();
        }
    }
}
