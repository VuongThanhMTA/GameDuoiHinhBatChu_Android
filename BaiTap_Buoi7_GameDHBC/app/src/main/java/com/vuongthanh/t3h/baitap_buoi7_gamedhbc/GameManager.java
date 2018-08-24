package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameManager extends AppCompatActivity implements View.OnClickListener {
    private Random random;
    ArrayList<Integer> arrIndex = new ArrayList<>();
    private Player player;
    private Question question;
    private ArrayList<Question> questionArr;
    private int nextQuestion;
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

    private CustomButton btn_DA1, btn_DA2, btn_DA3, btn_DA4, btn_DA5, btn_DA6, btn_DA7, btn_DA8,
            btn_DA9, btn_DA10, btn_DA11, btn_DA12, btn_DA13, btn_DA14, btn_DA15, btn_DA16;
    private CustomButton btn_GY1, btn_GY2, btn_GY3, btn_GY4, btn_GY5, btn_GY6, btn_GY7, btn_GY8,
            btn_GY9, btn_GY10, btn_GY11, btn_GY12, btn_GY13, btn_GY14, btn_GY15, btn_GY16;
    private CustomButton[] arrBtnDA;
    private CustomButton[] arrBtnGY;
    private TextView txvHeart;
    private TextView txvScore;
    private Button btnNext;
    private ImageView imvQuestion;
    private LinearLayout lnLayoutAnswer_1, lnLayoutAnswer_2, lnLayoutHint_1, lnLayoutHint_2;
    private int indexHint = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duoihinhbatchu);
        player = new Player(0, "", 5);
        innitView();
        innitArrayButton();
        randomQuestionArray();
        createQuestion();

    }

    private void innitView() {
        txvHeart = findViewById(R.id.txv_heart);
        txvScore = findViewById(R.id.txv_score);
        btnNext = findViewById(R.id.btn_cautiep);
        btnNext.setOnClickListener(this);
        // btnNext.setVisibility(View.INVISIBLE);
        imvQuestion = findViewById(R.id.imgv_picture);

        lnLayoutAnswer_1 = findViewById(R.id.linearLayout_Answer_1);
        lnLayoutAnswer_2 = findViewById(R.id.linearLayout_Answer_2);
        lnLayoutHint_1 = findViewById(R.id.linearLayout_Hint_1);
        lnLayoutHint_2 = findViewById(R.id.linearLayout_Hint_2);
    }

    private void innitArrayButton() {
        arrBtnGY = new CustomButton[16];
        arrBtnDA = new CustomButton[16];
        btn_DA1 = findViewById(R.id.btn_Ans1);
        btn_DA2 = findViewById(R.id.btn_Ans2);
        btn_DA3 = findViewById(R.id.btn_Ans3);
        btn_DA4 = findViewById(R.id.btn_Ans4);
        btn_DA5 = findViewById(R.id.btn_Ans5);
        btn_DA6 = findViewById(R.id.btn_Ans6);
        btn_DA7 = findViewById(R.id.btn_Ans7);
        btn_DA8 = findViewById(R.id.btn_Ans8);
        btn_DA9 = findViewById(R.id.btn_Ans9);
        btn_DA10 = findViewById(R.id.btn_Ans10);
        btn_DA11 = findViewById(R.id.btn_Ans11);
        btn_DA12 = findViewById(R.id.btn_Ans12);
        btn_DA13 = findViewById(R.id.btn_Ans13);
        btn_DA14 = findViewById(R.id.btn_Ans14);
        btn_DA15 = findViewById(R.id.btn_Ans15);
        btn_DA16 = findViewById(R.id.btn_Ans16);

        btn_GY1 = findViewById(R.id.btn_Hint1);
        btn_GY2 = findViewById(R.id.btn_Hint2);
        btn_GY3 = findViewById(R.id.btn_Hint3);
        btn_GY4 = findViewById(R.id.btn_Hint4);
        btn_GY5 = findViewById(R.id.btn_Hint5);
        btn_GY6 = findViewById(R.id.btn_Hint6);
        btn_GY7 = findViewById(R.id.btn_Hint7);
        btn_GY8 = findViewById(R.id.btn_Hint8);
        btn_GY9 = findViewById(R.id.btn_Hint9);
        btn_GY10 = findViewById(R.id.btn_Hint10);
        btn_GY11 = findViewById(R.id.btn_Hint11);
        btn_GY12 = findViewById(R.id.btn_Hint12);
        btn_GY13 = findViewById(R.id.btn_Hint13);
        btn_GY14 = findViewById(R.id.btn_Hint14);
        btn_GY15 = findViewById(R.id.btn_Hint15);
        btn_GY16 = findViewById(R.id.btn_Hint16);


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cautiep:
                createQuestion();
                break;
            case R.id.btn_Ans1:
                clickBtnAnswer(0);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans2:
                clickBtnAnswer(1);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans3:
                clickBtnAnswer(2);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans4:
                clickBtnAnswer(3);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans5:
                clickBtnAnswer(4);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans6:
                clickBtnAnswer(5);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans7:
                clickBtnAnswer(6);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans8:
                clickBtnAnswer(7);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans9:
                clickBtnAnswer(8);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans10:
                clickBtnAnswer(9);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans11:
                clickBtnAnswer(10);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans12:
                clickBtnAnswer(11);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans13:
                clickBtnAnswer(12);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans14:
                clickBtnAnswer(13);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans15:
                clickBtnAnswer(14);
                setBackgroundAnswer();
                break;
            case R.id.btn_Ans16:
                clickBtnAnswer(15);
                setBackgroundAnswer();
                break;

            case R.id.btn_Hint1:
                clickBtnHint(0);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint2:
                clickBtnHint(1);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint3:
                clickBtnHint(2);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint4:
                clickBtnHint(3);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint5:
                clickBtnHint(4);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint6:
                clickBtnHint(5);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint7:
                clickBtnHint(6);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint8:
                clickBtnHint(7);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint9:
                clickBtnHint(8);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint10:
                clickBtnHint(9);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint11:
                clickBtnHint(10);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint12:
                clickBtnHint(11);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint13:
                clickBtnHint(12);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint14:
                clickBtnHint(13);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint15:
                clickBtnHint(14);
                checkAnswerTrue();
                break;
            case R.id.btn_Hint16:
                clickBtnHint(15);
                checkAnswerTrue();
                break;

        }
    }

    private void randomQuestionArray() {
        nextQuestion = 0;
        questionArr = new ArrayList<>();
        random = new Random();
        int temp = 0;
        ArrayList<Integer> arrIndexRandom = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            temp = random.nextInt(30);
            while (checkIndex(arrIndexRandom, temp)) {
                temp = random.nextInt(30);
            }
            question = new Question(resourceImages[temp], arrDapAn[temp]);
            arrIndexRandom.add(temp);
            questionArr.add(question);
        }


    }

    private void setBackgroundAnswer() {
        for (int i = 0; i < question.getCharNumber(); i++) {
            arrBtnDA[i].setBackgroundResource(R.drawable.ic_tile_hover);
        }
    }

    //lấy ra ô đầu tiên trong các ô trả lời chưa có text
    private int checkTextAnswer() {
        for (int i = 0; i < question.getCharNumber(); i++) {
            if (arrBtnDA[i].getText().toString().isEmpty())
                return i;
        }
        return 0;
    }

    private boolean checkFullAnswer() {
        for (int i = 0; i < question.getCharNumber(); i++) {
            if (arrBtnDA[i].getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void lockBtn() {
        if (checkFullAnswer()) {
            for (int i = 0; i < 16; i++) {
                arrBtnGY[i].setClickable(false);
            }
        }
        for (int i = 0; i < 16; i++) {
            arrBtnGY[i].setClickable(true);
        }
    }

    private void lockAllBtn(boolean true_false) {
        for (int i = 0; i < 16; i++) {
            if (true_false) {
                arrBtnGY[i].setClickable(false);
                arrBtnDA[i].setClickable(false);
            } else {
                arrBtnGY[i].setClickable(true);
                arrBtnDA[i].setClickable(true);
            }
        }
    }

    private void checkAnswerTrue() {
        player.setAnswer("");
        boolean fullAnswer = checkFullAnswer();

        if (fullAnswer) {
            for (int i = 0; i < question.getCharNumber(); i++) {
                player.setAnswer(player.getAnswer() + arrBtnDA[i].getText().toString());
            }
            if (player.getAnswer().equals(question.getResult())) {
                Toast.makeText(this,"Đúng rồi!!",Toast.LENGTH_LONG).show();
                nextQuestion++;
                if (nextQuestion > 29) {
                    nextQuestion = 29;
                }
                for (int i = 0; i < question.getCharNumber(); i++) {
                    arrBtnDA[i].setBackgroundResource(R.drawable.ic_tile_true);
                }
                btnNext.setVisibility(View.VISIBLE);
                player.setScore(player.getScore() + 100);
                txvScore.setText(String.valueOf(player.getScore()));
                lockAllBtn(true);
            } else {
                for (int i = 0; i < question.getCharNumber(); i++) {
                    arrBtnDA[i].setBackgroundResource(R.drawable.ic_tile_false);
                }
                player.setHeart(player.getHeart() - 1);
                txvHeart.setText(String.valueOf(player.getHeart()));
                if(player.getHeart()==0){
                    lockAllBtn(true);
                    Toast.makeText(this,"Game over",Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    private void clickBtnHint(int indexBtn) {
        if (!checkFullAnswer()) {
            indexHint++;
            while (checkDuplicateIndexHint()) {
                indexHint++;
            }
            arrBtnGY[indexBtn].setIndexHint(indexHint);
            arrBtnGY[indexBtn].setVisibility(View.INVISIBLE);
            int i = checkTextAnswer();
            arrBtnDA[i].setText(arrBtnGY[indexBtn].getText());
            arrBtnDA[i].setIndexHint(indexHint);

        }

    }

    private void clickBtnAnswer(int indexBtn) {
        //if (!checkFullAnswer()) {
        if (!arrBtnDA[indexBtn].getText().toString().isEmpty()) {
            arrBtnDA[indexBtn].setText("");
            //showBtnHint();
            for (int i = 0; i < 16; i++) {
                if (arrBtnGY[i].getIndexHint() == arrBtnDA[indexBtn].getIndexHint()) {
                    arrBtnGY[i].setVisibility(View.VISIBLE);
                    break;
                }
            }
            indexHint--;
        }
        //}
    }

    private void showBtnHint() {
        for (int i = 0; i < 16; i++) {
            if (arrBtnGY[i].getIndexHint() == indexHint) {
                arrBtnGY[i].setVisibility(View.VISIBLE);
                break;
            }
        }
    }


    private void setTextAnswer(CustomButton btn, String c) {
        for (int i = 0; i < question.getCharNumber(); i++) {
            if (arrBtnDA[i].getText().toString().isEmpty()) {
                btn.setText(c + "");
                btn.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }


    private void resetText() {
        txvScore.setText(String.valueOf(player.getScore()));
        txvHeart.setText(String.valueOf(player.getHeart()));
        for (int i = 0; i < 16; i++) {
            arrBtnDA[i].setText("");
            arrBtnDA[i].setBackgroundResource(R.drawable.ic_tile_hover);
            arrBtnGY[i].setText("");
            arrBtnGY[i].setBackgroundResource(R.drawable.ic_tile_hover);
            indexHint = 0;
            player.setAnswer("");
        }
    }

    private void createQuestion() {
        lockAllBtn(false);
        btnNext.setVisibility(View.INVISIBLE);
        resetText();
        lnLayoutAnswer_1.removeAllViews();
        lnLayoutAnswer_2.removeAllViews();
        lnLayoutHint_1.removeAllViews();
        lnLayoutHint_2.removeAllViews();

//        random = new Random();
//        question = new Question();
//        int resourceImg = random.nextInt(30);
//        while (checkIndex(arrIndex, resourceImg)) {
//            resourceImg = random.nextInt(30);
//        }
//        question.setResourceImage(resourceImages[resourceImg]);
//        question.setResult_charNumber(arrDapAn[resourceImg]);
//        question.randomPick();
        question = questionArr.get(nextQuestion);
        imvQuestion.setImageResource(question.getResourceImage());

        char[] pick = question.getPick();
        for (int i = 0; i < 16; i++) {
            //    arrBtnGY[i] = new CustomButton(this);

            arrBtnGY[i].setVisibility(View.VISIBLE);
            arrBtnGY[i].setClickable(true);
            arrBtnGY[i].setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            if (i < 8) {
                lnLayoutHint_1.addView(arrBtnGY[i]);
            } else {
                lnLayoutHint_2.addView(arrBtnGY[i]);
            }
            arrBtnGY[i].setOnClickListener(this);
            arrBtnGY[i].setBackgroundResource(R.drawable.ic_tile_hover);
            arrBtnGY[i].setText(pick[i] + "");
        }

        for (int i = 0; i < question.getCharNumber(); i++) {
            //   arrBtnDA[i] = new CustomButton(this);

            arrBtnDA[i].setVisibility(View.VISIBLE);
            arrBtnDA[i].setClickable(true);
            arrBtnDA[i].setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            if (i < 8) {
                lnLayoutAnswer_1.addView(arrBtnDA[i]);
            } else {
                lnLayoutAnswer_2.addView(arrBtnDA[i]);
            }
            arrBtnDA[i].setOnClickListener(this);
            arrBtnDA[i].setBackgroundResource(R.drawable.ic_tile_hover);
        }

    }

    private boolean checkDuplicateIndexHint() {
        for (int i = 0; i < 16; i++) {
            if (arrBtnGY[i].getIndexHint() == indexHint) {
                return true;
            }
        }
        return false;
    }


    private boolean checkIndex(ArrayList<Integer> arrIndex, int k) {
        if (arrIndex.size() == 0) return false;
        else {
            for (int i = 0; i < arrIndex.size(); i++) {
                if (arrIndex.get(i) == k)

                    return true;
            }
        }
        return false;
    }
}
