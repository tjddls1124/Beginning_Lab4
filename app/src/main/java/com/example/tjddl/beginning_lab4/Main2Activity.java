package com.example.tjddl.beginning_lab4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    int Index = 0;
    String menu[] = {"짜장", "볶음밥", "떡볶이", "피자", "치킨"};
    boolean check[] = {true,false,false,true,true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textView_adult);
        tv2 = (TextView) findViewById(R.id.textView_lauch);
        tv3 = (TextView) findViewById(R.id.textView_menu);


    }

    public void onClick(View v) {
        if (v.getId() == R.id.button_adult) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this)
                    .setTitle("미성년자 여부")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage("만 19세 미만인가요?")
                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tv1.setText("당신은 미성년자 입니다");
                        }
                    })
                    .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tv1.setText("당신은 미성년자가 아닙니다.");
                        }
                    });
            dlg.show();
        }

        if (v.getId() == R.id.button_lunch) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this)
                    .setTitle("오늘의 점심메뉴는?")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("선택", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String str = "";
                            str += menu[Index];
                            tv2.setText("오늘의 메뉴는 " + str + "입니다.");
                        }
                    })
                    .setSingleChoiceItems(menu, Index, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Index = which;
                        }
                    });
        dlg.show();
        }
        if(v.getId() == R.id.button_menu) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this)
                    .setTitle("미성년자 여부")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("선택", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String str = "";


                        for(int i = 0 ; i<menu.length ; i++){
                            if( check[i] ) str += " "+  menu[i];
                        }

                            tv3.setText("좋아하는 메뉴는 " + str + "입니다.");
                        }
                    })
                    .setMultiChoiceItems(menu, check, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            check[which] = isChecked;
                        }
                    });
            dlg.show();


        }

    }
}
