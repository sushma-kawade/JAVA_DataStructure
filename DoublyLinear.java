//////////////////////////////////////////////////////////////////////////////
//
// Function Name :  
// Description   :  Doubly Linear Linked List
// Input         :  Integer
// Output        :  Integer
// Author        :  Sushma Kawade
// Date          :  5 feb 2023
//
////////////////////////////////////////////////////////////////////////////


import java.util.*;

class Node
{
    public int Data;
    public Node Next;
    public Node Prev;

    public Node(int No)
    {
        this.Data = No;
        this.Next = null;
        this.Prev = null;
    }
}

class SinglyCL
{
    private Node Head;
    private Node Last;
    private int Count;

    public SinglyCL()
    {
        Head = null;
        Count = 0;
    }

    protected void finalize()
    {
        // Memory free
    }

    public void InsertFirst(int No)
    {
        Node Newn = new Node(No);

        if(this.Head == null)
        {
            this.Head = Newn;
        }
        else
        {
            Newn.Next = this.Head;
        }
        Head.Prev = Newn;
        Head = Newn;
        this.Count++;
    }
    public void InsertLast(int No)
    {
        Node Newn = new Node(No);

        if(this.Head == null)
        {
            this.Head = Newn;
        }
        else
        {
            Node temp = this.Head;
            while(temp.Next != null)
            {
                temp = temp.Next;
            }
            temp.Next = Newn;
            Newn.Prev = temp.Next;
        }
        this.Count++;
    }

    public void InsertAtPos(int No,int iPos)
    {
        Node Newn = new Node(No);
        if((iPos < 1) || (iPos > Count+1))
        {
            System.out.println("Invalid position");
            return;
        }

        if(iPos ==1)
        {
            InsertFirst(No);
        }
        else if(iPos == Count+1)
        {
            InsertLast(No);
        }
        else
        {
            Node temp = this.Head;
            for(int iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            Newn.Next = temp.Next;
            temp.Next.Prev = Newn;    // X
            temp.Next = Newn;
            Newn.Prev = temp;
        }
        this.Count++;
    }
    public void DeleteFirst()
    {
        if(this.Count == 0)
        {
            return;
        }
        else if(this.Count == 1)
        {
            this.Head = null;
        }
        else
        {
            Head = Head.Next;
            Head.Prev = null;
        }
        this.Count--;
    }

    public void DeleteLast()
    {
        if(this.Count == 0)
        {
            return;
        }
        else if(this.Count == 1)
        {
            this.Head = null;
        }
        else
        {
            Node temp = this.Head;

            while(temp.Next != null)
            {
                temp = temp.Next;
            }
            temp.Next = null;
        }
        this.Count--;
    }
    public void DeleteAtPos(int iPos)
    {
        if((iPos < 1) || (iPos > Count+1))
        {
            System.out.println("Invalid position");
            return;
        }

        if(iPos ==1)
        {
            DeleteFirst();
        }
        else if(iPos == Count+1)
        {
            DeleteLast();
        }
        else
        {
            Node temp2 = null;
            Node temp1 = this.Head;
            for(int iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp1 = temp1.Next;
            }
            temp2 = temp1.Next;
            temp1.Next = temp2.Next;
            temp2.Next.Prev = temp1;
        }
        this.Count--;

    }

    public void Display()
    {
        Node temp = this.Head;

        for(int iCnt = 1; iCnt <= Count; iCnt++)
        {
            System.out.print("| "+temp.Data+" |->");
            temp = temp.Next;
        }
        System.out.println("null");
    }

    public int CountNodes()
    {
        return this.Count;
    }
}

class DoublyLinear
{
    public static void main(String Arg[])
    {
        SinglyCL obj1 = new SinglyCL();

        obj1.InsertFirst(51);
        obj1.InsertFirst(21);
        obj1.InsertFirst(11);
        obj1.Display();

        obj1.InsertLast(111);
        obj1.InsertLast(121);
        obj1.Display();

        obj1.InsertAtPos(101,4);
        obj1.Display();

        obj1.DeleteFirst();
        obj1.Display();

        obj1.DeleteLast();
        obj1.Display();

        obj1.DeleteAtPos(2);
        obj1.Display();

        int ret = obj1.CountNodes();

        System.out.println("Number of nodes are : "+ret);
    }
} 