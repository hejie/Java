package com.example.queue;

public class FirstLastList {
	private class Data{
		private Object obj;
		private Data next = null;
		
		Data(Object obj){
			this.obj = obj;
		}
	}
	
	private Data first = null;
	private Data last = null;
	
	public void push(Object obj){
		Data data = new Data(obj);
		if(first == null){
			first = data;
		}else{
			last.next = data;
		}
		last = data;
	}
	
	public Object pop() throws Exception{
		if(first == null)
			throw new Exception("empty");
		Data temp = first;
		if(first.next == null)
			last = null;
		first = first.next;
		return temp.obj;
	}
			
	public void display(){
		if(first == null)
			System.out.println("empty");
		System.out.print("first -> last : | ");
		Data cur = first;
		while(cur != null){
			System.out.print(cur.obj.toString() + " | ");
			cur = cur.next;
		}
		System.out.print("\n");
	}


	public static void main(String[] args) throws Exception{
		FirstLastList fllq = new FirstLastList();
		fllq.push(1);
		fllq.push(2);
		fllq.push(3);
		fllq.display();
//		System.out.println(fllq.pop());
//		fllq.display();
//		fllq.push(4);
//		fllq.display();
	}
}
