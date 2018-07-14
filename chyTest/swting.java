package chyTest;
import  java.awt.*;
import  javax.swing.*;

public class swting {
    public  static  void main(String[] args){
        EventQueue.invokeLater(() ->
                {
                    SimpleFrame frame = new SimpleFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setTitle("chy");




                }
        );
    }
}
    class  SimpleFrame extends JFrame{
//        private  static final int DEFAULT_WIDTH = 800;
//        private  static final int DEFAULT_HEIGHT= 600;
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int DEFAULT_WIDTH = screenSize.width;
            int DEFAULT_HEIGHT = screenSize.height;

        public SimpleFrame(){
            setSize(DEFAULT_WIDTH/2,DEFAULT_HEIGHT/2);
        }
    }

