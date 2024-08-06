package com.abhig.myapplication;

import static java.lang.Character.isDigit;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView fans;
    TextView tv7, tv8;
    CardView cardAc, cardC, cardDiv,cardMul, cardSub, cardAdd, cardSeven, cardEight, cardNine, cardFour, cardFive, cardSix, cardOne, cardTwo, cardThree, cardDZero, cardZero, cardPoint, cardEqual;
    private boolean lastNumeric;
    private boolean lastDot;
    private boolean isError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editNums);
        fans = findViewById(R.id.finalAns);

        cardAc = findViewById(R.id.ac);
        cardC = findViewById(R.id.c);
        cardDiv = findViewById(R.id.divide);

        cardSeven = findViewById(R.id.seven);
        cardEight = findViewById(R.id.eight);
        cardNine = findViewById(R.id.nine);

        tv7 = findViewById(R.id.seventxt);
        tv8= findViewById(R.id.eighttxt);

        cardMul = findViewById(R.id.multiply);

        cardFour = findViewById(R.id.four);
        cardFive = findViewById(R.id.five);
        cardSix = findViewById(R.id.six);

        cardSub = findViewById(R.id.subtract);

        cardOne = findViewById(R.id.one);
        cardTwo = findViewById(R.id.two);
        cardThree = findViewById(R.id.three);

        cardAdd = findViewById(R.id.plus);

        cardDZero = findViewById(R.id.dZero);
        cardZero = findViewById(R.id.zero);

        cardEqual = findViewById(R.id.equalTo);

        cardPoint = findViewById(R.id.point);

        lastNumeric = false;
        lastDot = false;
        isError = false;

        cardNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("9");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("8");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("7");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        cardSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("6");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        cardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("5");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("4");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("3");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("2");
                lastNumeric = true;
                        if (isError) return;

                        String expression = editText.getText().toString();

                        try {
                            DecimalFormat df = new DecimalFormat("#.##########");
                            String result = df.format(eval(expression));
                            fans.setText(result);
                            lastDot = result.contains(".");
                        } catch (Exception e) {
                            fans.setText("Error");
                            isError = true;
                        }
                    }

                    private double eval(String expression) {
                        try {
                            return new Object() {
                                int pos = -1, ch;

                                void nextChar() {
                                    ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                                }

                                boolean eat(int charToEat) {
                                    while (ch == ' ') nextChar();
                                    if (ch == charToEat) {
                                        nextChar();
                                        return true;
                                    }
                                    return false;
                                }

                                double parse() {
                                    nextChar();
                                    double x = parseExpression();
                                    if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                                    return x;
                                }

                                double parseExpression() {
                                    double x = parseTerm();
                                    for (;;) {
                                        if(eat('+')) x += parseTerm();
                                        else if (eat('-')) x -= parseTerm();
                                        else return x;
                                    }
                                }

                                double parseTerm() {
                                    double x = parseFactor();
                                    for (;;) {
                                        if(eat('*')) x *= parseFactor();
                                        else if (eat('/')) x /= parseFactor();
                                        else if (eat('%')) x %=parseFactor();
                                        else return x;
                                    }
                                }

                                double parseFactor() {
                                    if (eat('+')) return parseFactor();
                                    if (eat('-')) return -parseFactor();

                                    double x;
                                    int startPos = this.pos;

                                    if (eat('(')) {
                                        x = parseExpression();
                                        eat(')');
                                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                        StringBuilder sb = new StringBuilder();
                                        while ((ch >= '0' && ch <= '9') || ch == '.') {
                                            sb.append((char) ch);
                                            nextChar();
                                        }
                                        x = Double.parseDouble(sb.toString());
                                    } else {
                                        throw new RuntimeException("Unexpected: " + (char)ch);
                                    }

                                    return x;
                                }
                            }.parse();
                        } catch (Exception e) {
                            return Double.NaN;
                        }
            }
        });
        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("1");
                lastNumeric = true;

                        if (isError) return;

                        String expression = editText.getText().toString();

                        try {
                            DecimalFormat df = new DecimalFormat("#.##########");
                            String result = df.format(eval(expression));
                            fans.setText(result);
                            editText.setTextColor(Color.WHITE);
                            lastDot = result.contains(".");
                        } catch (Exception e) {
                            fans.setText("Error");
                            isError = true;
                        }
                    }

                    private double eval(String expression) {
                        try {
                            return new Object() {
                                int pos = -1, ch;

                                void nextChar() {
                                    ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                                }

                                boolean eat(int charToEat) {
                                    while (ch == ' ') nextChar();
                                    if (ch == charToEat) {
                                        nextChar();
                                        return true;
                                    }
                                    return false;
                                }

                                double parse() {
                                    nextChar();
                                    double x = parseExpression();
                                    if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                                    return x;
                                }

                                double parseExpression() {
                                    double x = parseTerm();
                                    for (;;) {
                                        if(eat('+')) x += parseTerm();
                                        else if (eat('-')) x -= parseTerm();
                                        else return x;
                                    }
                                }

                                double parseTerm() {
                                    double x = parseFactor();
                                    for (;;) {
                                        if(eat('*')) x *= parseFactor();
                                        else if (eat('/')) x /= parseFactor();
                                        else if (eat('%')) x %=parseFactor();
                                        else return x;
                                    }
                                }

                                double parseFactor() {
                                    if (eat('+')) return parseFactor();
                                    if (eat('-')) return -parseFactor();

                                    double x;
                                    int startPos = this.pos;

                                    if (eat('(')) {
                                        x = parseExpression();
                                        eat(')');
                                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                        StringBuilder sb = new StringBuilder();
                                        while ((ch >= '0' && ch <= '9') || ch == '.') {
                                            sb.append((char) ch);
                                            nextChar();
                                        }
                                        x = Double.parseDouble(sb.toString());
                                    } else {
                                        throw new RuntimeException("Unexpected: " + (char)ch);
                                    }

                                    return x;
                                }
                            }.parse();
                        } catch (Exception e) {
                            return Double.NaN;
                        }
            }
        });

        cardZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("0");
                lastNumeric = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });

        cardDZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                editText.append("00");
                lastNumeric = true;
                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });
        cardPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;

                String currentText = editText.getText().toString();
                if (!currentText.isEmpty() && !currentText.contains(".")) {
                    editText.append(".");
                }else {
                    editText.append("0.");
                }
                    lastNumeric = false;
                    lastDot = true;
                if (isError) return;

                String expression = editText.getText().toString();

                try {
                    DecimalFormat df = new DecimalFormat("#.##########");
                    String result = df.format(eval(expression));
                    fans.setText(result);
                    editText.setTextColor(Color.WHITE);
                    lastDot = result.contains(".");
                } catch (Exception e) {
                    fans.setText("Error");
                    isError = true;
                }
            }

            private double eval(String expression) {
                try {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ') nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if(eat('+')) x += parseTerm();
                                else if (eat('-')) x -= parseTerm();
                                else return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if(eat('*')) x *= parseFactor();
                                else if (eat('/')) x /= parseFactor();
                                else if (eat('%')) x %=parseFactor();
                                else return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+')) return parseFactor();
                            if (eat('-')) return -parseFactor();

                            double x;
                            int startPos = this.pos;

                            if (eat('(')) {
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                                StringBuilder sb = new StringBuilder();
                                while ((ch >= '0' && ch <= '9') || ch == '.') {
                                    sb.append((char) ch);
                                    nextChar();
                                }
                                x = Double.parseDouble(sb.toString());
                            } else {
                                throw new RuntimeException("Unexpected: " + (char)ch);
                            }

                            return x;
                        }
                    }.parse();
                } catch (Exception e) {
                    return Double.NaN;
                }
            }
        });

        cardAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fans.setText("");
                editText.setText("");
                lastNumeric = false;
                lastDot = false;
                isError = false;
            }
        });

        cardC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;

                String currentText = editText.getText().toString();
                if (!currentText.isEmpty()) {
                    editText.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });


        cardAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;

                String currentText = editText.getText().toString();

                if (!currentText.isEmpty() && isDigit(currentText.charAt(currentText.length() - 1))) {
                    editText.append("+");
                }
            }
        });
        cardSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;

                String currentText = editText.getText().toString();

                if (!currentText.isEmpty() && isDigit(currentText.charAt(currentText.length() - 1))) {
                    editText.append("-");
                }
            }
        });
        cardMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;

                String currentText = editText.getText().toString();

                if (!currentText.isEmpty() && isDigit(currentText.charAt(currentText.length() - 1))) {
                    editText.append("*");
                }
            }
        });
        cardDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;

                String currentText = editText.getText().toString();

                if (!currentText.isEmpty() && isDigit(currentText.charAt(currentText.length() - 1))) {
                    editText.append("/");
                }
            }
        });

        cardEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isError) return;
                String FinalAns = fans.getText().toString();
                editText.setText(FinalAns);
                fans.setText("");
                editText.setTextColor(Color.GREEN);
            }
        });

        }

    }