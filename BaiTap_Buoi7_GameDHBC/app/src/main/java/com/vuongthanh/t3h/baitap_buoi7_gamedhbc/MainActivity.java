package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvTestDA;
    private TextView getTxvTestDA1;
    private Stack<Integer> indexBtnGY = new Stack<>();

    private Random random;
    private int heart = 5;
    private int score = 0;
    private TextView txvHeart;
    private TextView txvScore;
    private Button btnNext;
    private ImageView imgQuestion;
    private Button btn_DA1, btn_DA2, btn_DA3, btn_DA4, btn_DA5, btn_DA6, btn_DA7, btn_DA8,
            btn_DA9, btn_DA10, btn_DA11, btn_DA12, btn_DA13, btn_DA14, btn_DA15, btn_DA16;
    private Button btn_GY1, btn_GY2, btn_GY3, btn_GY4, btn_GY5, btn_GY6, btn_GY7, btn_GY8,
            btn_GY9, btn_GY10, btn_GY11, btn_GY12, btn_GY13, btn_GY14, btn_GY15, btn_GY16;
    private Button[] arrBtnDA = new Button[16];
    private Button[] arrBtnGY = new Button[16];
    private int[] resourceImages = {R.drawable.aomua, R.drawable.baocao, R.drawable.canthiep, R.drawable.cattuong,
            R.drawable.chieutre, R.drawable.danhlua, R.drawable.danong, R.drawable.giandiep, R.drawable.giangmai,
            R.drawable.hoidong, R.drawable.hongtam, R.drawable.khoailang, R.drawable.kiemchuyen, R.drawable.lancan,
            R.drawable.masat, R.drawable.nambancau, R.drawable.oto, R.drawable.quyhang, R.drawable.songsong,
            R.drawable.thattinh, R.drawable.thothe, R.drawable.tichphan, R.drawable.tohoai, R.drawable.totien,
            R.drawable.tranhthu, R.drawable.vuaphaluoi, R.drawable.vuonbachthu, R.drawable.xakep, R.drawable.xaphong,
            R.drawable.xedapdien};
    private String[] arrDapAn = {"aomua", "baocao", "canthiep", "cattuong", "chieutre", "danhlua", "danong", "giandiep", "giangmai",
            "hoidong", "hongtam", "khoailang", "kiemchuyen", "lancan", "masat", "nambancau", "oto", "quyhang", "songsong",
            "thattinh", "thothe", "tichphan", "tohoai", "totien", "tranhthu", "vuaphaluoi", "vuonbachthu", "xakep", "xaphong", "xedapdien"};
    private String cauTraLoi = "";
    private String dapAn = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitView();
        arrayButton();
        setInvisible(true);
        for (int i = 0; i < arrBtnDA.length; i++) {
            arrBtnDA[i].setOnClickListener(this);
            arrBtnGY[i].setOnClickListener(this);
        }
        tiepTuc();
    }

    private void arrayButton() {
        arrBtnDA[0] = btn_DA1;
        arrBtnDA[1] = btn_DA2;
        arrBtnDA[2] = btn_DA3;
        arrBtnDA[3] = btn_DA4;
        arrBtnDA[4] = btn_DA5;
        arrBtnDA[5] = btn_DA6;
        arrBtnDA[6] = btn_DA7;
        arrBtnDA[7] = btn_DA8;
        arrBtnDA[8] = btn_DA9;
        arrBtnDA[9] = btn_DA10;
        arrBtnDA[10] = btn_DA11;
        arrBtnDA[11] = btn_DA12;
        arrBtnDA[12] = btn_DA13;
        arrBtnDA[13] = btn_DA14;
        arrBtnDA[14] = btn_DA15;
        arrBtnDA[15] = btn_DA16;

        arrBtnGY[0] = btn_GY1;
        arrBtnGY[1] = btn_GY2;
        arrBtnGY[2] = btn_GY3;
        arrBtnGY[3] = btn_GY4;
        arrBtnGY[4] = btn_GY5;
        arrBtnGY[5] = btn_GY6;
        arrBtnGY[6] = btn_GY7;
        arrBtnGY[7] = btn_GY8;
        arrBtnGY[8] = btn_GY9;
        arrBtnGY[9] = btn_GY10;
        arrBtnGY[10] = btn_GY11;
        arrBtnGY[11] = btn_GY12;
        arrBtnGY[12] = btn_GY13;
        arrBtnGY[13] = btn_GY14;
        arrBtnGY[14] = btn_GY15;
        arrBtnGY[15] = btn_GY16;

    }

    private void innitView() {
//        txvTestDA = findViewById(R.id.txvTestDA);
//        getTxvTestDA1 = findViewById(R.id.txvTestDA1);

        txvHeart = findViewById(R.id.txv_heart);
        txvScore = findViewById(R.id.txv_score);
        btnNext = findViewById(R.id.btn_cautiep);
        imgQuestion = findViewById(R.id.imgv_picture);
        //  btnNext.setVisibility(View.INVISIBLE);
        btnNext.setOnClickListener(this);

        txvHeart.setText(heart + "");
        txvScore.setText(score + "");

        btn_DA1 = findViewById(R.id.btn_da1);
        btn_DA2 = findViewById(R.id.btn_da2);
        btn_DA3 = findViewById(R.id.btn_da3);
        btn_DA4 = findViewById(R.id.btn_da4);
        btn_DA5 = findViewById(R.id.btn_da5);
        btn_DA6 = findViewById(R.id.btn_da6);
        btn_DA7 = findViewById(R.id.btn_da7);
        btn_DA8 = findViewById(R.id.btn_da8);
        btn_DA9 = findViewById(R.id.btn_da9);
        btn_DA10 = findViewById(R.id.btn_da10);
        btn_DA11 = findViewById(R.id.btn_da11);
        btn_DA12 = findViewById(R.id.btn_da12);
        btn_DA13 = findViewById(R.id.btn_da13);
        btn_DA14 = findViewById(R.id.btn_da14);
        btn_DA15 = findViewById(R.id.btn_da15);
        btn_DA16 = findViewById(R.id.btn_da16);

        btn_GY1 = findViewById(R.id.btn_gy1);
        btn_GY2 = findViewById(R.id.btn_gy2);
        btn_GY3 = findViewById(R.id.btn_gy3);
        btn_GY4 = findViewById(R.id.btn_gy4);
        btn_GY5 = findViewById(R.id.btn_gy5);
        btn_GY6 = findViewById(R.id.btn_gy6);
        btn_GY7 = findViewById(R.id.btn_gy7);
        btn_GY8 = findViewById(R.id.btn_gy8);
        btn_GY9 = findViewById(R.id.btn_gy9);
        btn_GY10 = findViewById(R.id.btn_gy10);
        btn_GY11 = findViewById(R.id.btn_gy11);
        btn_GY12 = findViewById(R.id.btn_gy12);
        btn_GY13 = findViewById(R.id.btn_gy13);
        btn_GY14 = findViewById(R.id.btn_gy14);
        btn_GY15 = findViewById(R.id.btn_gy15);
        btn_GY16 = findViewById(R.id.btn_gy16);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cautiep:
                tiepTuc();
                break;
            case R.id.btn_da1:
            case R.id.btn_da2:
            case R.id.btn_da3:
            case R.id.btn_da4:
            case R.id.btn_da5:
            case R.id.btn_da6:
            case R.id.btn_da7:
            case R.id.btn_da8:
            case R.id.btn_da9:
            case R.id.btn_da10:
            case R.id.btn_da11:
            case R.id.btn_da12:
            case R.id.btn_da13:
            case R.id.btn_da14:
            case R.id.btn_da15:
            case R.id.btn_da16: {
                Button btn = (Button) v;
                String temp = btn.getText().toString();
                if (!temp.isEmpty()) {
                    btn.setText("");
                    khoaClickBtn(false);
                }
                break;
            }
            case R.id.btn_gy1:
            case R.id.btn_gy2:
            case R.id.btn_gy3:
            case R.id.btn_gy4:
            case R.id.btn_gy5:
            case R.id.btn_gy6:
            case R.id.btn_gy7:
            case R.id.btn_gy8:
            case R.id.btn_gy9:
            case R.id.btn_gy10:
            case R.id.btn_gy11:
            case R.id.btn_gy12:
            case R.id.btn_gy13:
            case R.id.btn_gy14:
            case R.id.btn_gy15:
            case R.id.btn_gy16: {
                Button btn = (Button) v;
                for (int i = 0; i < arrBtnDA.length; i++) {
                    String temp = arrBtnDA[i].getText().toString();
                    if (temp.isEmpty()) {
                        arrBtnDA[i].setText(btn.getText());
                        cauTraLoi += btn.getText();
                        btn.setVisibility(View.INVISIBLE);
                        if (cauTraLoi.length() == dapAn.length()) {
                            khoaClickBtn(true);
                            //getTxvTestDA1.setText("" + cauTraLoi);
                            checkTrueFalse();
                        }
                        break;
                    }
                }
            }
        }
    }

    private void checkTrueFalse() {
        if (cauTraLoi.equals(dapAn)) {

            Toast.makeText(this, "dung", Toast.LENGTH_LONG).show();
            resetBGBtnDA(1);
            score += 100;
            txvScore.setText(score + "");
            btnNext.setVisibility(View.VISIBLE);

        } else {
            heart--;
            txvHeart.setText(heart + "");
            Toast.makeText(this, "sai", Toast.LENGTH_LONG).show();
            resetBGBtnDA(-1);
            gameOver();

        }
    }

    private void kiemTra() {
        if (arrBtnDA[dapAn.length() - 1].getText().toString().isEmpty()) {

        }
    }


    View.OnClickListener onClickListener_BtnDA = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private void setInvisible(boolean invisible) {

        if (invisible == true) {
            for (int i = 0; i < arrBtnDA.length; i++) {
                arrBtnDA[i].setVisibility(View.INVISIBLE);
            }
        } else {
            for (int i = 0; i < arrBtnDA.length; i++) {
                arrBtnDA[i].setVisibility(View.INVISIBLE);
                arrBtnGY[i].setVisibility(View.VISIBLE);
            }
        }
    }

    private void clearText() {
        for (int i = 0; i < 16; i++) {
            arrBtnDA[i].setText("");
            arrBtnGY[i].setText("");
        }
    }


    private void resetBGBtnDA(int key) {
        int resource = 0;
        if (key == 0)
            resource = R.drawable.ic_tile_hover;
        else if (key == 1)
            resource = R.drawable.ic_tile_true;
        else resource = R.drawable.ic_tile_false;
        for (int i = 0; i < dapAn.length(); i++) {
            arrBtnDA[i].setBackgroundResource(resource);
        }
    }

    private void tiepTuc() {
        khoaClickBtn(false);
        resetBGBtnDA(0);
        cauTraLoi = "";
        clearText();
        setInvisible(false);
        btnNext.setVisibility(View.INVISIBLE);
        random = new Random();
        int index = 0;
        index = random.nextInt(resourceImages.length);
        imgQuestion.setBackgroundResource(resourceImages[index]);

        String dapAn = arrDapAn[index];
        this.dapAn = dapAn;
        //txvTestDA.setText("" + dapAn);
        int soChu = dapAn.length();

        // hiển thị số ô đáp án
        for (int i = 0; i < soChu; i++) {
            arrBtnDA[i].setVisibility(View.VISIBLE);
        }

        //thêm các ký tự bất kỳ vào đáp án để đủ 16 ô
        for (int i = 0; i < (16 - soChu); i++) {
            int a = 97 + random.nextInt(26);
            char k = (char) a;
            dapAn += k;
        }

        // sét text cho các ô với các chữ có trong đáp án
        char[] arrChar = dapAn.toCharArray();

        ArrayList<Integer> arrRandomI = new ArrayList<>();
        for (int i = 0; i < arrBtnGY.length; i++) {
            int temp = 0;
            temp = random.nextInt(arrChar.length);
            while (checkInt(arrRandomI, temp)) {
                temp = random.nextInt(arrChar.length);
            }
            arrRandomI.add(temp);
            arrBtnGY[i].setText(String.valueOf(arrChar[temp]));
        }

    }

    private void khoaClickBtn(boolean key) {
        if (key) {
            for (int i = 0; i < arrBtnGY.length; i++) {
                arrBtnGY[i].setClickable(false);
            }
        } else {
            for (int i = 0; i < arrBtnGY.length; i++) {
                arrBtnGY[i].setClickable(true);
            }
        }
    }

    private void gameOver() {
        if (heart == 0) {
            Toast.makeText(this, "Game over", Toast.LENGTH_LONG).show();
            btnNext.setClickable(false);
            for (int i = 0; i < arrBtnDA.length; i++) {
                arrBtnDA[i].setClickable(false);
                arrBtnGY[i].setClickable(false);
            }
        }
    }


    private boolean checkInt(ArrayList<Integer> arrInt, int k) {
        if (arrInt.size() == 0) return false;
        else {
            for (int i = 0; i < arrInt.size(); i++) {
                if (arrInt.get(i) == k)
                    return true;
            }
        }
        return false;
    }
}
