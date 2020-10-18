import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelApp extends JPanel{
  TextField input;
  int res = 0;
  int res1 = 0;
  String op = "";
  Font bigFont = new Font("serif", Font.BOLD, 22);

  Vector<JButton> inputButtons = new Vector<JButton>();
  JButton bRes, bPlus, bMinus, bMulti, bDiv;
  int x = 10, y = 180;

  private void InitializeInterface(){
    setLayout(null);
    input = new TextField();
    input.setBounds(10, 10, 235, 25);

    for (int i = 0; i < 9; i += 3) {

      inputButtons.add(new JButton(String.valueOf(i + 1)));
      inputButtons.get(i).setBounds(10, y, 50, 50);

      inputButtons.add(new JButton(String.valueOf(i + 2)));
      inputButtons.get(i + 1).setBounds(60, y,  50, 50);

      inputButtons.add(new JButton(String.valueOf(i + 3)));
      inputButtons.get(i + 2).setBounds(110, y, 50, 50);

      y -= 70;
    }

    inputButtons.add(new JButton(String.valueOf(0)));
    inputButtons.lastElement().setBounds(10, 270, 75, 50);


    bRes = new JButton("=");
    bRes.setBounds(85, 270, 75, 50);
    bRes.setFont(bigFont);

    bPlus = new JButton("+");
    bPlus.setBounds(170, 40, 75, 50);
    bPlus.setFont(bigFont);

    bMinus = new JButton("-");
    bMinus.setBounds(170, 110, 75, 50);
    bMinus.setFont(bigFont);

    bMulti = new JButton("*");
    bMulti.setBounds(170, 180, 75, 50);
    bMulti.setFont(bigFont);

    bDiv = new JButton("/");
    bDiv.setBounds(170, 270, 75, 50);
    bDiv.setFont(bigFont);

    for (int i = 0; i < inputButtons.size(); i++){
      add(inputButtons.get(i));
    }
    add(bRes);
    add(bPlus);
    add(bMinus);
    add(bMulti);
    add(bDiv);
    add(input);
  }

  private void AddListeners(){
    for (int i = 0; i < inputButtons.size() - 1; i++){
      int j = i; // костыль
      inputButtons.get(i).addActionListener(new ActionListener()
      {
        @Override
        public void actionPerformed(ActionEvent arg1)
        {
          input.setText(input.getText() + String.valueOf(j + 1));
          if (res==0) {
            res = Integer.valueOf(input.getText());
          } else {
            res1 = Integer.valueOf(input.getText());
          }
        }
      });
    }
    inputButtons.lastElement().addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg1)
      {
        input.setText(input.getText() + String.valueOf(0));
        if (res==0) {
          res = Integer.valueOf(input.getText());
        } else {
          res1 = Integer.valueOf(input.getText());
        }
      }
    });

    bPlus.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg1)
      {
        System.out.println(res);
        res = Integer.valueOf(input.getText());
        System.out.println(res);
        input.setText("");
        op = "+";
      }
    });

    bMinus.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg1)
      {
        System.out.println(res);
        res = Integer.valueOf(input.getText());
        System.out.println(res);
        input.setText("");
        op = "-";
      }
    });

    bMulti.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg1)
      {
        System.out.println(res);
        res = Integer.valueOf(input.getText());
        System.out.println(res);
        input.setText("");
        op = "*";
      }
    });

    bDiv.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg1)
      {
        System.out.println(res);
        res = Integer.valueOf(input.getText());
        System.out.println(res);
        input.setText("");
        op = "/";
      }
    });

    bRes.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg0)
      {
        int num = Integer.valueOf(res);
        int num1 = Integer.valueOf(res1);
        String strOp = op;

        MethodCalc mc = new MethodCalc();
        String strRes = String.valueOf(mc.calc(num, strOp, num1 ));
        input.setText(strRes);
      }
    });
  }
  public JPanelApp()
  {
    try {
      InitializeInterface();
      AddListeners();
    }
    catch (ArithmeticException exception)
    {
      //System.out.println("Can not divide by zero ");
    }
  }

}
