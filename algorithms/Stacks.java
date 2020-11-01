package algorithms;

import javax.swing.JOptionPane;
public class Stacks
{
	public static int top = -1;
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null,"This program creates a stack and performs basic functions used in a stack.",
			"Information", JOptionPane.INFORMATION_MESSAGE);
		int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the size of the stack: "));
		int[] stk = new int[size];
		String[] options = {"Push", "Pop", "Print", "Stack Top", "EXIT"};
		boolean repeat = true;
		do
		{
			int choice = JOptionPane.showOptionDialog(null, "What do you want to do?", "Basic Operations",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			switch (choice)
			{
				case 0:
					if (full(stk))
						JOptionPane.showMessageDialog(null, "The stack is full!",
							"OVERFLOW ERROR", JOptionPane.ERROR_MESSAGE);
					else
					{
						int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Input integer to be pushed: ",
						"Push", JOptionPane.PLAIN_MESSAGE));
						push(stk, num);
						JOptionPane.showMessageDialog(null, num+" has been pushed into the stack.", "Push",
						JOptionPane.INFORMATION_MESSAGE);
					} break;
				case 1:
					if (empty(stk))
							JOptionPane.showMessageDialog(null, "The stack is empty!",
								"UNDERFLOW ERROR", JOptionPane.ERROR_MESSAGE);
					else
					{
						JOptionPane.showMessageDialog(null, stk[top]+" has been popped out from the stack.",
							"Pop", JOptionPane.INFORMATION_MESSAGE);
						pop(stk);
					} break;
				case 2: printStack(stk); break;
				case 3:
					if (empty(stk))
						JOptionPane.showMessageDialog(null, "The stack is empty!",
							"UNDERFLOW ERROR", JOptionPane.ERROR_MESSAGE);
					else
					{
						JOptionPane.showMessageDialog(null, "Stack top is "+s_top(stk),
						"Stack Top", JOptionPane.INFORMATION_MESSAGE);
					} break;
				default: repeat = false; break;
			}
		} while (repeat);
	}
	static void push(int[] stack, int num)
	{
			stack[++top] = num;
	}
	static void pop(int[] stack)
	{
			top--;
	}
	static boolean empty(int[] stack)
	{
		if (top < 0)
			return true;
		else
			return false;
	}
	static boolean full(int[] stack)
	{
		if (top == stack.length - 1)
			return true;
		else
			return false;
	}
	static int s_top(int[] stack)
	{
		int obj = stack[top];
		return obj;
	}
	static void printStack(int[] stack)
	{
		StringBuilder print = new StringBuilder();
		for (int i = top; i >= 0; i--)
			print.append(stack[i]).append("\n");
		JOptionPane.showMessageDialog(null, "The stack is: \n"+print, "Print Stack",
			JOptionPane.INFORMATION_MESSAGE);
	}
}
