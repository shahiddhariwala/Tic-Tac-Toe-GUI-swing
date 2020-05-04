/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
Date     : 04-May-2020
*/

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToe extends JFrame implements ActionListener
{
	public static int BOARD_SIZE = 3;

	public static enum GameStatus
	{
		Incomplete, Xwins, Zwins, Tie
	}

	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
	boolean crossTurn = true;

	public TicTacToe()
	{
		super.setTitle("Tic-Tac-Toe by Shahid Dhariwala");
		super.setSize(800, 800);

		GridLayout gridLayout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(gridLayout);
		Font font = new Font("Comic Sans", 1, 150);

		for (int row = 0; row < buttons.length; row++)
		{
			for (int col = 0; col < buttons.length; col++)
			{
				JButton button = new JButton(""); // Empty text on button
				buttons[row][col] = button;
				button.setFont(font);
				button.addActionListener(this);
				super.add(button);
			}
		}
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton ClickedButton = (JButton) e.getSource();
		this.makeMove(ClickedButton);
	}

	private void makeMove(JButton clickedButton)
	{
		String buttonText = clickedButton.getText();
		if (buttonText.length() > 0)
		{
			// Something is already present
		} else
		{
			if (this.crossTurn == true)
			{
				clickedButton.setText("X");
			} else
			{
				clickedButton.setText("O");
			}
			crossTurn = !crossTurn;
		}

	}

	public static void main(String[] args)
	{
		TicTacToe startGame = new TicTacToe();
	}
}

/* https://github.com/shahiddhariwala */