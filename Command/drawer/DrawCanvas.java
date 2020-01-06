package drawer;

import command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    private MacroCommand history;

    public DrawCanvas(MacroCommand history, int width, int height){
        this.history = history;

        setSize(width, height);
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        var g = getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 6, 6);
    }
}
