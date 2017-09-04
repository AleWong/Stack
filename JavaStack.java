import java.lang.reflect.Array;
import java.util.Scanner;

import javax.xml.transform.Templates;

/*
 * java:数组实现的栈，能存储任意类型的数据
 */
public class JavaStack<T> {
	//定义栈的容量
	private static final int DEFAULT_SIZE = 12;
	private T[] mArray;
	private int count;

	//构造函数
	public JavaStack(Class<T> type) {
		this(type, DEFAULT_SIZE);
	}
	
	//构造函数
	public JavaStack(Class<T> type, int size) {
		// 不能直接使用mArray = new T[DEFAULT_SIZE];
		mArray = (T[])Array.newInstance(type, size);
		count = 0;
	}
	
	// 将val添加到栈中
	public void push(T val) {
		mArray[count++] = val;
	}
	
	 // 返回“栈顶元素值”
	public T peek() {
		return mArray[count-1];
	}
	
	// 返回“栈顶元素值”，并删除“栈顶元素”
	public T pop() {
		T result = mArray[count - 1];
		count--;
		return result;
	}
	
	// 返回“栈”的大小
	public int size() {
		return count; 
	}
	
	// 返回“栈”是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// 打印“栈”
	public void PrintStack() {
		if(isEmpty()) {
			System.out.println("stack is empty");
		}
		System.out.println("the stack size is: " + size());
		
		//指针取名i
		int i = count - 1;
		while(i >= 0) {
			System.out.println(mArray[i]);
			i--;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("please push 3 numbers into stack:");
		String tem;
		JavaStack<String> a = new JavaStack<String>(String.class);
//		Scanner in = new Scanner(System.in);
//		String i = in.nextLine();
		
		//依次推入3个数字
		a.push("10");
		a.push("30");
		a.push("50");
		a.PrintStack();
		
		//将“栈顶元素”赋值给tmp，并删除“栈顶元素”
		tem = a.pop();
		System.out.println("被删除的栈顶元素: "+ tem);
		
		// 只将“栈顶”赋值给tmp，不删除该元素.
		tem = a.peek();
		System.out.println("栈顶元素" + tem);
		
		
		a.push("70");
		tem = a.peek();
		System.out.println("new stack top is:" + tem);
		System.out.println();
		//打印栈
		a.PrintStack();

	}

}
