package Util;

import javax.swing.*;
import java.io.IOException;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {

        System.out.println("定时功能已执行");
        String cmd ="cmd /c start D:\\RSM_TH\\WQM.exe";
        try {
            Runtime.getRuntime().exec(cmd);
//            JOptionPane.showMessageDialog(null,"程序执行成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

