package FadeEffect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;

public class FadeEffect {

    public static void fadeIn(final JDialog dialog, int delay, final float incrementSize) {
        final Timer timer = new Timer(delay, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += incrementSize;
                dialog.setOpacity(Math.min(opacity, 1));
                if (opacity >= 1) {
                    timer.stop();
                }
            }
        });

        dialog.setOpacity(0); 
        timer.start();
    }

    public static void fadeOut(final JDialog dialog, int delay, final float incrementSize) {
        final Timer timer = new Timer(delay, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= incrementSize;
                dialog.setOpacity(Math.max(opacity, 0)); 
                if (opacity <= 0) {
                    timer.stop();
                    dialog.dispose();
                }
            }
        });

        dialog.setOpacity(1); 
        timer.start();
    }

    public static void fadeInFrame(final JFrame frame, int delay, final float incrementSize) {
        final Timer timer = new Timer(delay, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += incrementSize;
                frame.setOpacity(Math.min(opacity, 1));
                if (opacity >= 1) {
                    timer.stop();                  
                }
            }
        });

        frame.setOpacity(0); 
        timer.start();
    }

    public static void fadeInFrameSplash(final JFrame frame, int delay, final float incrementSize) {
        final Timer timer = new Timer(delay, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += incrementSize;
                frame.setOpacity(Math.min(opacity, 1)); 
                if (opacity >= 1) {
                    timer.stop();
                }
            }
        });

        frame.setOpacity(0); 
        timer.start();
    }

    public static void fadeOutFrameSplash(final JFrame frame, int delay, final float incrementSize) {
        final Timer timer = new Timer(delay, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= incrementSize;
                frame.setOpacity(Math.max(opacity, 0)); 
                if (opacity <= 0) {
                    timer.stop();
                    frame.dispose();
                    new Frames.login().setVisible(true);
                }
            }
        });

        frame.setOpacity(1); 
        timer.start();
    }
   /*
    public static void fadeOutFrameSplash1(final JFrame frame, int delay, final float incrementSize) {
        final Timer timer = new Timer(delay, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= incrementSize;
                frame.setOpacity(Math.max(opacity, 0));
                if (opacity <= 0) {
                    timer.stop();
                    frame.dispose();
                    new Login.JFrameLogin().setVisible(true);
                }
            }
        });

        frame.setOpacity(1); 
        timer.start();
    }*/

}
