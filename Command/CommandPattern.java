// command模式, 创建一个GUI窗口

import command.MacroCommand;
import drawer.DrawCanvas;
import drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CommandPattern {

    public static void main(String[] args) {
        new GUI("a command-pattern demo!");
    }
}

class GUI extends JFrame implements ActionListener, MouseMotionListener {

    private MacroCommand history = new MacroCommand();
    private DrawCanvas drawCanvas = new DrawCanvas(history, 400, 400);

    private JButton clear = new JButton("清除");
    private JButton undo = new JButton("撤销");

    public GUI(String title){
        super(title);

        Panel p1 = new Panel();
        p1.add(clear);
        p1.add(undo);

        Panel p2 = new Panel();
        p2.add(drawCanvas);

        this.add(p1);
        this.add(p2);

        //listener
        clear.addActionListener(this);
        undo.addActionListener(this);
        drawCanvas.addMouseMotionListener(this);


        this.setLayout(new FlowLayout());
        this.setBounds(200,200,800,600); //设置窗口的属性 窗口位置以及窗口的大小
        this.setVisible(true);//设置窗口可见
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse Moved: " + e.getPoint().x + ", " + e.getPoint().y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse Dragged!");
        var drawcom = new DrawCommand(drawCanvas, e.getPoint());
        history.append(drawcom);
        drawcom.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            System.out.println("clear");
            history.clear();
            drawCanvas.repaint();

        }else if(e.getSource() == undo){
            System.out.println("undo");
            history.undo();
            drawCanvas.repaint();
        }else{
            System.out.println("nothing!");
        }
    }
}