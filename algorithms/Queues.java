package algorithms;
import javax.swing.*;
public class Queues
{
	public static int rear = -1, front = 0;
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "This program performs the basic operation of a queue.", "Information", JOptionPane.INFORMATION_MESSAGE);
		boolean sizeInvalid = true, repeat = true;
		do
		{
			int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Input queue size [5 - 15]: ", "Queue", JOptionPane.PLAIN_MESSAGE));
			if (size >= 5 && size <= 15)
			{
				sizeInvalid = false;
				int[] queue = new int[size];
				String[] options = {"Enqueue", "Dequeue", "Print Queue", "EXIT"};
				do
				{
					int choice = JOptionPane.showOptionDialog(null, "Pick an operation to be performed: ", "Basic Operations", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
					switch (choice)
					{
						case 0: enqueue(queue); break;
						case 1: dequeue(queue); break;
						case 2: if (empty(queue))
									JOptionPane.showMessageDialog(null, "ERROR: The queue is empy!", "Overflow Error", JOptionPane.ERROR_MESSAGE);
								else
									printQueue(queue);
								break;
						case 3:
						default: repeat = false; break;
					}
				} while (repeat);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ERROR: Queue size must be minimum of 5 and maximum of 15!", "Invalid Input Error", JOptionPane.ERROR_MESSAGE);
				sizeInvalid = true;
			}
		} while (sizeInvalid);
	}
	static void enqueue(int[] arr)
	{
		if (full(arr))
			JOptionPane.showMessageDialog(null, "ERROR: The queue is full!", "Underflow Error", JOptionPane.ERROR_MESSAGE);
		else
		{
			int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Input an integer to be enqueued: ", "Enqueue", JOptionPane.PLAIN_MESSAGE));
			if (front == -1 && rear == -1)
			{
				rear++;
				front++;
				arr[rear] = num;
			}
			else if (front == 0)
				arr[++rear] = num;
			else if (front > 0 && rear == arr.length - 1)
			{
				for (int i = front; i < arr.length; i++)
					arr[i-1] = arr[i];
				front--;
				arr[rear] = num;
			}
			JOptionPane.showMessageDialog(null, num+" has been enqueued.", "Enqueue", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	static void dequeue(int[] arr)
	{
		if (empty(arr))
			JOptionPane.showMessageDialog(null, "ERROR: The queue is empy!", "Overflow Error", JOptionPane.ERROR_MESSAGE);
		else
		{
			JOptionPane.showMessageDialog(null, arr[front]+" has been dequeued.", "Dequeue", JOptionPane.INFORMATION_MESSAGE);
			if (front == rear)
			{
				rear++;
				front++;
			}
			else if (front >= 0 && rear > front)
				front++;
			else if (front == arr.length - 1)
			{
				front = 0;
				rear = -1;
			}
		}
	}
	static boolean empty(int[] arr)
	{
		if (front > rear)
			return true;
		else
			return false;
	}
	static boolean full(int[] arr)
	{
		if (front == 0 && rear == arr.length - 1)
			return true;
		else
			return false;
	}
	static void printQueue(int[] arr)
	{
		StringBuilder display = new StringBuilder();
		display.append("The queue is:\n");
		for (int i = front; i <= rear; i++)
			display.append(arr[i]+"  ");
		JOptionPane.showMessageDialog(null, display, "Print Queue", JOptionPane.INFORMATION_MESSAGE);
	}
}