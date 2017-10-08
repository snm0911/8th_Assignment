package Calculate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JFrame implements ActionListener {
	private JTextField txt;
	private JPanel panel;
	Dimension res;
	String but[] = {"1","2","3","+","4","5","6","-",
			"7","8","9","*","0","C","=","/"}; 
	String key;
	String num1 = "";
	int result=0;
	public KeyPad() {
		res= Toolkit.getDefaultToolkit().getScreenSize(); // ȭ���߰��ǰ��� x1,y1�� �����մϴ�.
	      int x1 = (res.width-400)/2;
	      int y1 = (res.height-400)/2;
	      this.setTitle("����"); // �������� �����ϰ� �̸��� �����մϴ�.
	      this.setLocation(x1,y1);     // �������� ��ġ�� ȭ�� �߰������մϴ�.
		txt = new JTextField(20);
		add(txt, BorderLayout.NORTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		add(panel, BorderLayout.CENTER);
		for (int i = 0; i < 16; i++) {
			
			JButton btn = new JButton(but[i]);
			btn.addActionListener(this);
			btn.setPreferredSize(new Dimension(100, 100));
			panel.add(btn);
		}
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s=="1"||s=="2"||s=="3"||s=="4"||s=="5"||s=="6"||s=="7"||s=="8"||s=="9"||s=="0")
		{
			txt.setText(txt.getText() + s);
			num1 = num1 + s;
		}
		else
		{
			if(s == "C")
			{
				txt.setText("");
				num1 = "";
				result = 0;
				key = "";
			}
			else if(s == "=")
			{
				switch(key){ 
				case "+": 
					result += Integer.parseInt(num1); txt.setText(""+result);
					break; 
				case "-": 
					result -= Integer.parseInt(num1); txt.setText(""+result);
					break; 
				case "*": 
					result *= Integer.parseInt(num1); txt.setText(""+result);
					break; 
				case "/": 
					result /= Integer.parseInt(num1); txt.setText(""+result);
					break; 
				default : 
					break; 
					} 
			}
			else
			{
				key = s;
				if(result == 0)
					result = Integer.parseInt(num1);
				txt.setText("");
				num1= "";
			}
			
		}
	}
	public static void main(String[] args) {
		new KeyPad();
	}
	}	

