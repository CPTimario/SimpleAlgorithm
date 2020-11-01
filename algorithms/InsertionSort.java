package algorithms;
import java.util.Scanner;
public class InsertionSort
{
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		boolean valid = true;
		System.out.println("\n\n\n\tThis program lets you enter a series of integers and sort them"
			+"\n\tin ascending or descending order using Bubble Sort.\n");
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
			printArray(num, num.length);
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
	public static void printArray(int[] arr, int element)
	{
		for (int i = 0; i < element; i++)
			System.out.print(arr[i]+" ");
	}
	public static void sortArrayAsc(int[] arr)
	{
		System.out.print("\n\n\tUnsorted Array: ");
		printArray(arr, arr.length);
		System.out.println("\n\n\n");
		int i, j, insert;
		System.out.print("\n\tRound 1: ");
		printArray(arr, 1);
		System.out.println();
	    for (j = 1; j < arr.length; j++)
	    {
			insert = arr[j];
			for(i = j-1; (i >= 0) && (arr[i] > insert); i--)
				arr[i+1] = arr[i];
			arr[i+1] = insert;
			System.out.print("\n\tRound "+(j+1)+": ");
			printArray(arr, (j+1));
			System.out.print(" - Inserting "+insert+"\n");
		}
	}
	public static void sortArrayDsc(int[] arr)
	{
		System.out.print("\n\n\tUnsorted Array: ");
		printArray(arr, arr.length);
		System.out.println("\n\n\n");
		int i, j, insert;
		System.out.print("\n\tRound 1: ");
		printArray(arr, 1);
		System.out.println();
	    for (j = 1; j < arr.length; j++)
	    {
			insert = arr[j];
			for(i = j-1; (i >= 0) && (arr[i] < insert); i--)
				arr[i+1] = arr[i];
			arr[i+1] = insert;
			System.out.print("\n\tRound "+(j+1)+": ");
			printArray(arr, (j+1));
			System.out.print(" - Inserting "+insert+"\n");
		}
	}
}

