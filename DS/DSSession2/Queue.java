import java.util.*;

/**
 * DS Session2 Assignment
 * Queue.java
 * @author Rohit
 *
 */
public class Queue {

	Object q[];			// make a object type of array to hold all type of values
	int front;		// front variable keep starting index of queue
	int rear;		// real variable keep last index of queue
	Queue()
	{
		q = new Object[10];
		front = -1;
		rear = 0;
	}
	void enqueue( Object item )
	{
		if( rear == q.length )			// if rear is reached at queue length than resize the queue
		{
			Object[] buffer = new Object[q.length];
			int i;
			for(i=0; i<q.length; i++)
			{
				buffer[i] = q[i];
			}
			q = new Object[q.length+10];
			for(i=0; i<buffer.length; i++)
			{
				q[i] = buffer[i];
			}
		}
		q[rear++] = item;				// put item at rear index and increase rear by one
		if( front == -1 )
		{
			front = 0;				// if front = -1 than make it is 0
		}
	}
	Object dequeue()
	{
		if( front == -1 ) // check whether queue is empty
		{
			return null;
		}
		else
		{
			Object remove = q[front];		// make a remove object to hold the dequeue item
			int i;
			rear--;				// reduce rear by one
			if( rear == 0 )		// if after remove item queue is empty than set front = -1
			{
				front--;
			}
			else				// otherwise shift element one by one
			{
				for(i=0; i<rear; i++)
				{
					q[i] = q[i+1];
				}
			}
			return remove;				// return the remove item
		}
	}
	void makeEmpty()
	{
		front = -1;
		rear = 0;
		q = new Object[10];			// reassign queue
	}
	Object getFront()
	{
		if( front == -1 )
		{
			Object t = null;		// check whether queue is empty
			return t;
		}
		else
		{
			return q[front];		// return the item at front index
		}
	}
	void display()			// display the queue items
	{
		if( front == -1 )
		{
			System.out.print("\n Queue is Empty ");
		}
		else
		{
			int i;
			System.out.print("\n Queue is: ");
			for(i=0; i<rear; i++ )
			{
				System.out.print(q[i]+" ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		Object item;
		Scanner sc = new Scanner(System.in);
		Queue queue = new Queue();
		while(true)				// make a menu for select particular operations
		{
			System.out.print("\n 1. Enqueue\n 2. Dequeue\n 3. Make Empty\n 4. Get Front Item\n 5. Display Queue\n 6. Exit");
			System.out.print("\n Enter your choice : ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.print("\n Enter Item value : ");
				item = sc.nextInt();
				queue.enqueue(item); break;
			case 2:
				item = queue.dequeue();
				if( item == null )
				{
					System.out.print("\n Queue is Empty ");
				}
				else
				{
					System.out.print("\n Dequeue Item is : "+item);
				}
				break;
			case 3:
				queue.makeEmpty(); break;
			case 4:
				item = queue.getFront();
				if( item == null )
				{
					System.out.print("\n Queue is Empty ");
				}
				else
				{
					System.out.print("\n Front Item is : "+item);
				}
				break;
			case 5:
				queue.display(); break;
			case 6:
				System.exit(0);
			}
		}
	}

}
