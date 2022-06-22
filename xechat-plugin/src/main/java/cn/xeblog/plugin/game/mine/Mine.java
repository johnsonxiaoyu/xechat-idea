package cn.xeblog.plugin.game.mine;

import cn.xeblog.commons.entity.game.gobang.GobangDTO;
import cn.xeblog.commons.enums.Game;
import cn.xeblog.plugin.annotation.DoGame;
import cn.xeblog.plugin.game.AbstractGame;
import cn.xeblog.plugin.game.gobang.Gobang;
import com.intellij.openapi.ui.ComboBox;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@DoGame(Game.MINE)
public class Mine extends AbstractGame<GobangDTO> implements ActionListener {

    // 开始界面
    private JPanel startPanel;

    // 扫雷面板
    private MinePanel minePanel;


    @Override
    protected void init() {
        //窗口
        mainPanel.removeAll();
        mainPanel.setLayout(null);
        mainPanel.setEnabled(true);
        mainPanel.setVisible(true);
        mainPanel.setMinimumSize(new Dimension(500, 500));
        startPanel = new JPanel();
        startPanel.setBounds(-1000, -1000, 500, 500);

        mainPanel.add(startPanel);

        JLabel label1 = new JLabel("扫雷");
        label1.setFont(new Font("", 1, 13));
        startPanel.add(label1);

        //面板
        minePanel = new MinePanel();
        mainPanel.add(minePanel);
        //显示
        ComboBox chessAIBox = new ComboBox();
        chessAIBox.addItem("初级");
        chessAIBox.addItem("中级");
        chessAIBox.addItem("高级");
        startPanel.add(chessAIBox);
    }



    /**
     * 功能：事件监听<br>
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if("new".equals(command))
        {
            minePanel.newGame();
        }
        else if("easy".equals(command))
        {
            minePanel.setLevel(minePanel.EASY);
        }
        else if("normal".equals(command))
        {

            minePanel.setLevel(minePanel.NORMAL);
        }
        else if("hard".equals(command))
        {
            minePanel.setLevel(minePanel.HARD);
        }
        else if("exit".equals(command))
        {
            System.exit(0);
        }
    }

    @Override
    protected void start() {

    }

    @Override
    public void handle(GobangDTO body) {

    }
}
