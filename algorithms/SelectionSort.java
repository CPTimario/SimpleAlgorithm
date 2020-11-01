package algorithms;
import java.util.Scanner;
public class SelectionSort
{
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		boolean valid = true;
		System.out.println("\n\n\n\tThis program lets you enter a series of integers and sort them"
			+"\n\tin ascending or descending order using Selection Sort.\n");
		int[] num = enterArray();
		System.out.print("\n\n\tSort in [a]scending or [d]escending order? : ");
		char choice = input.next().charAt(0);
		switch (choice)
		{
			case 'A':
			case 'a': System.out.print("\n\n"); sortArrayAsc(num); break;
			case 'D':
			case 'd': System.out.print("\n\n"); sortArrayDsc(num); break;
			default: valid = false; break;
		}
		if (valid)
		{
			System.out.print("\n\n\tSorted array: ");
			printArray(num);
			System.out.println("\n\n\n");
		}
		else
			System.out.println("\n\tInvalid Input!\n\n\n");
	}
	public static int[] enterArray()
	{
		System.out.print("\n\tEnter the number of integers to be sorted: ");
		int size = input.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
		{
				System.out.print("\n\t\tEnter integer: ");
				arr[i] = input.nextInt();
		}
		return arr;
	}
	public static void printArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	public static void sortArrayAsc(int[] arr)
	{
		System.out.print("\n\n\tUnsorted Array: ");
		printArray(arr);
		System.out.println("\n\n");
		for (int i = 0; i < arr.length - 1; i++)
		{
			boolean swap = false;
			int idx = 0, tmp, low = arr[i];
			for (int j = i+1; j < arr.length; j++)
			{
				if (low > arr[j])
				{
					low = arr[j];
					idx = j;
					swap = true;
				}
			}
			System.out.print("\n\tAfter Pass "+(i+1)+": ");
			if (swap)
			{
				tmp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = tmp;
				System.out.print("\t");
				printArray(arr);
				System.out.print(" - Selecting "+arr[i]+" and swapping\n");

			}
			else
			{
				System.out.print("\t");
				printArray(arr);
				System.out.print(" - Selecting "+arr[i]+"\n");
			}
		}
	}
	public static void sortArrayDsc(int[] arr)
	{
		System.out.print("\n\n\tUnsorted Array: ");
		printArray(arr);
		System.out.println("\n\n");
		for (int i = 0; i < arr.length - 1; i++)
		{
			boolean swap = false;
			int idx = 0, tmp, low = arr[i];
			for (int j = i+1; j < arr.length; j++)
			{
				if (low < arr[j])
				{
					low = arr[j];
					idx = j;
					swap = true;
				}
			}
			System.out.print("\n\tAfter Pass "+(i+1)+": ");
			if (swap)
			{
				tmp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = tmp;
				System.out.print("\t");
				printArray(arr);
				System.out.print(" - Selecting "+arr[i]+" and swapping\n");

			}
			else
			{
				System.out.print("\t");
				printArray(arr);
				System.out.print(" - Selecting "+arr[i]+"\n");
			}
		}
	}
}
