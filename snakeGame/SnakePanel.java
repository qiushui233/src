package snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakePanel extends JPanel implements KeyListener,ActionListener {

    //加载图片
    ImageIcon body = new ImageIcon("body.png");
    ImageIcon food = new ImageIcon("food1.png");

    //蛇的数据结构设置
    int[] snakex = new int[1000];   //蛇的横坐标
    int[] snakey = new int[1000];   //蛇的纵坐标
    int len = 3;                    //蛇的长度
    int score = 0;
    String direction = "R";

    //食物的数据结构
    Random r = new Random();
    int foodx = r.nextInt(34) * 25 + 25;
    int foody = r.nextInt(25) * 25 + 25;      //食物的横纵坐标


    //游戏是否开始
    boolean isStart = false;

    //游戏是否结束
    boolean isEnd = false;

    Timer timer = new Timer(50,this);

    public SnakePanel(){
        this.setFocusable(true);
        initSnake(); //放置蛇
        this.addKeyListener(this); //添加键盘监听接口
        timer.start();
    }

    //初始化蛇的坐标
    public void initSnake(){
        isEnd = false;
        isStart = false;
        len = 3;
        score = 0;
        direction = "R";
        snakex[0] = 100;
        snakey[0] = 50;
        snakex[1] = 75;
        snakey[1] = 50;
        snakex[2] = 50;
        snakey[2] = 50;
    }

    public void paint(Graphics g){
        //设置画布的背景颜色
        this.setBackground(Color.YELLOW);
        g.fillRect(25,25,850,625);

        //画蛇
        for (int i = 0;i<len;i++){
            body.paintIcon(this,g,snakex[i],snakey[i]);
        }

        //画食物
        food.paintIcon(this,g,foodx,foody);

        //写一个开始提示语
        if (!isStart){
            g.setColor(Color.white);
            g.setFont(new Font("arial",Font.BOLD,30));
            g.drawString("press space to start/pause",300,300);
        }

        //结束语
        if (isEnd){
            g.setColor(Color.white);
            g.setFont(new Font("arial",Font.BOLD,30));
            g.drawString("GG,press space to start",300,300);
        }

        //分数统计
        g.setColor(Color.black);
        g.setFont(new Font("arial",Font.PLAIN,20));
        g.drawString("score:"+score,20,20);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if (KeyCode == KeyEvent.VK_SPACE){
            if (isEnd){
                initSnake();
            }else {
                isStart = !isStart;
            }

                repaint();
        }else if (KeyCode == KeyEvent.VK_UP && !direction.equals("D")){
            direction = "U";
        }else if (KeyCode == KeyEvent.VK_DOWN && !direction.equals("U")){
            direction = "D";
        }else if (KeyCode == KeyEvent.VK_RIGHT && !direction.equals("L")){
            direction = "R";
        }else if (KeyCode == KeyEvent.VK_LEFT && !direction.equals("R")){
            direction = "L";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    /**
     * 1.重新定义timer
     * 2.蛇的移动
     * 3.重画
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (isStart && !isEnd){
            //移动身体
            for (int i = len;i>0;i--){
                snakex[i] = snakex[i-1];
                snakey[i] = snakey[i-1];
            }

            if (snakex[0] == foodx && snakey[0] == foody){
                len++;
                score++;
                foodx = r.nextInt(34) * 25 + 25;
                foody = r.nextInt(25) * 25 + 25;
            }

            if (direction == "R"){
                //横坐标  +25
                snakex[0] += 25;
                if (snakex[0] > 850){
                    snakex[0] = 25;
                }
            }else if (direction == "L"){
                //横坐标  -25
                snakex[0] -= 25;
                if (snakex[0] < 25){
                    snakex[0] = 850;
                }
            }else if (direction == "U"){
                //纵坐标 -25
                snakey[0] -= 25;
                if (snakey[0] < 25){
                    snakey[0] = 625;
                }
            }else if (direction == "D"){
                //纵坐标 +25
                snakey[0] += 25;
                if (snakey[0] > 625){
                    snakey[0] = 25;
                }
            }

            //判断游戏结束
            for (int i = 1 ;i <len ;i++){
                if (snakex[0] == snakex[i] && snakey[0] == snakey[i]){
                    isEnd = true;
                }
            }
         repaint();
        }
    }
}
