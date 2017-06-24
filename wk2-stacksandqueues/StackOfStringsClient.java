import edu.princeton.cs.algs4.StdIn;

public static void main(String[] args)
{
    StackOfStrings stack = new StackOfStrings();
    while (!StdIn.isEmpty())
    {
        String s = StdIn.readString()
        if (s.equals("-"))  StdOut.print(stack.pop()); // if hyphen entered, pop from stack
        else                stack.push(s);
    }
}