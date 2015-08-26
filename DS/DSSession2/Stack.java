import java.util.*;

/**
 * DS Session2 Assignment
 * Stack.java
 * @author Rohit
 *
 */
public class Stack {
	
	Object value;					// a Object type variable so that our stack can take all type of vales
	Stack next;						// next is a stack type of variable which holds address of next item
	static Stack start = null;		// start is a stack type of variable which holds address of starting item
	static Stack top = null;		// top is a stack type of variable which holds address of top item
	Stack()				// constructor initializes the variables
	{
		value = 0;
		next = null;
	}
	void push( Object item )		
	{
		Stack newItem = new Stack();		// take a newItem object to insert new item in stack  
		newItem.value = item;
		newItem.next = start;		// newItem holds address of first item of stack
		start = newItem;			// now make start as a new item
		top = newItem;				// and also make top as a new item
	}
	void pop()
	{
		if( top == null )				// check whether stack is null
		{
			System.out.print("\n Stack is Empty ");
		}
		else								
		{
			System.out.print("\n Pooped Item is : "+top.value);		// print value of pooped item
			start = start.next;			// now start go to its next 
			top = top.next;
		}
	}
	Object peek()						
	{
		if( top == null )				// check whether stack is null
		{
			return null;
		}
		else
		{
			return top.value;		// return the top element value
		}
	}
	String infixToPostfix( String infix )
	{
		Stack temp1 = start;			// take a temporary variable temp1 which holds the address of item which is currently hold by start
		Stack temp = new Stack();		// make a new temporary stack which is used in conversion
		char ch;		
		start = null;				// at starting start point to the null
		String postfix = "";		// take a postfix String which contains the result
		int i = 0;
		if( infix.charAt(0) != '(' )
		{
			infix = '(' + infix + ')';		// at starting if brackets are not then add brackets in infix string
		}
		temp.push( infix.charAt(0) ); // push first item in stack
		
			for(i=1; i<infix.length(); i++)
			{
				if( (Character.isDigit( infix.charAt(i) )) || (Character.isLetter( infix.charAt(i) )) )// if character of string is a number or a letter than put it into postfix string 
				{
					postfix = postfix + infix.charAt(i);
				}
				else if( infix.charAt(i) == ' ' ) // Ignore spaces in string
				{
					
				}
				else
				{
					if( start == null ) // if stack is empty than push character into stack
					{
						temp.push( infix.charAt(i) );
					}
					else
					{
						ch = (char)temp.peek();// peek element
						if( (infix.charAt(i) == '+') || (infix.charAt(i) == '-') )
						{
							if( ch == '*' || ch == '/' )  // compare infix string character to peek element of stack  
							{
								postfix = postfix + ch;
								temp.pop();					// if precedence of peek element is equal or greater than infix string element than pop it and add into postfix string
							}
							if( start == null )
							{
								temp.push( infix.charAt(i) );
							}
							else
							{
								ch = (char)temp.peek();
								if( ch == '+' || ch == '-' )
								{
									postfix = postfix + ch;
									temp.pop();
								}
								temp.push( infix.charAt(i) );
							}
						}
						else if( (infix.charAt(i) == '*') || (infix.charAt(i) == '/') )
						{
							if( ch == '*' || ch == '/' )
							{
								postfix = postfix + ch;
								temp.pop();
							}
							temp.push( infix.charAt(i) );
						}
						else if( infix.charAt(i) == '(' ) // if open bracket character is come than put it into stack 
						{
							temp.push( infix.charAt(i) );
						}
						else if( infix.charAt(i) == ')' )	// if bracket close character is come than pop the elements and put them into postfix string until open bracket is not found
						{
							ch = (char)temp.peek();
							while( ch != '(')
							{
								postfix = postfix + ch;
								temp.pop();
								ch = (char)temp.peek();
							}
							temp.pop();
						}
					}
				}
			}
			while( start != null)   // if elements are left in stack than put all elements into postfix string
			{
				ch = (char)temp.peek();
				temp.pop();
				postfix = postfix + ch;
			}
			start = temp1;
			return postfix;
	}
	void display()				// display the contents of stack
	{
		if( top == null )
		{
			System.out.print("\n Stack is empty");
		}
		else
		{
			Stack temp = start;
			System.out.print("\n Stack is : ");
			while( temp != null )
			{
				System.out.print(temp.value+" ");
				temp = temp.next;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		Object item;
		String infix, postfix;
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();
		while(true)				// make a menu to for select particular function 
		{
			System.out.print("\n 1. Push\n 2. POP\n 3. Peek\n 4. Display Stack\n 5. Convert Infix to Postfix\n 6. Exit");
			System.out.print("\n Enter your choice : ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.print("\n Enter Item Value : ");
				item = sc.nextInt();
				st.push(item); break;
			case 2:
				st.pop(); break;
			case 3:
				item = st.peek();
				if( item == null )
				{
					System.out.print("\n Stack is Empty ");
				}
				else
				{
					System.out.print("\n Peek item is : "+item);
				}
				break;
			case 4:
				st.display(); break;
			case 5:
				System.out.print("\n Enter Infix Expression : ");
				infix = sc.next();
				postfix = st.infixToPostfix(infix);
				System.out.print("\n Postfix Expression is : "+postfix); break;
			case 6:
				System.exit(0);
			}
		}
	}

}
