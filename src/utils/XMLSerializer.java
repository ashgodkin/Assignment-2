package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public abstract class XMLSerializer implements Serializer {
	private Stack stack = new Stack<Integer>();
	private File file;
	
public XMLSerializer(File file){
	this.file = file;
}

public void push(Object o){
	stack.push(0);
}

public Object pop(){
	return stack.pop();
}

@SuppressWarnings("unchecked")
public void read() throws Exception
{
	ObjectInputStream is = null;
	
	try{
		XStream xstream = new XStream(new DomDriver());
		is = xstream.createObjectInputStream(new FileReader(file));
		stack  = (Stack) is.readObject();
	}
	finally{
		if (is != null)
		{
			is.close();
		}
	}
}

public void write() throws Exception{
	ObjectOutputStream os = null;
	
	try{
		XStream xstream = new XStream(new DomDriver());
		os = xstream.createObjectOutputStream(new FileWriter(file));
		os.writeObject(stack.pop());
		}
	finally
	{
		if (os !=null)
		{
			os.close();
		}
	}
}
}
