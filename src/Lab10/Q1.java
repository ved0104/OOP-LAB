//Q.1) Write an applet to display the date and time .the time is to be shown like a digital
//clock.
//        Requirements:
//         Create a JLabel to display the current time.
//         Use java.util.Timer or javax.swing.Timer to update the time every second.
// Format the time using SimpleDateFormat.
// The clock should start as soon as the application launches and update in real-time.
package Lab10;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class DigitalClock {

    public DigitalClock() {
        JFrame jframe = new JFrame("Digital Clock");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(200, 200);
        jframe.setLocationRelativeTo(null);

        JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        jframe.add(timeLabel);

        Timer timer = new Timer(1000, e -> {
            String currTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            timeLabel.setText(currTime);
        });
        timer.start();
        jframe.setVisible(true);
    }
}

public class Q1 {
    public static void main(String[] args) {
        DigitalClock dc = new DigitalClock();

    }
}
