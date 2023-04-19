//////////////////////////////////////////////////////////////////////////////
//
// Function Name :    
// Description   :  Doubly Circular Linked List
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

        if((this.Head == null) && (this.Last == null))
        {
            this.Head = Newn;
            this.Last = Newn;
        }
        else
        {
            Last.Next = Newn;
            Newn.Prev = Last;
            Newn.Next = Head;
            Last = Newn;
        }
        this.Count++;
    }

    public void InsertLast(int No)
    {
        Node Newn = new Node(No);

        if((this.Head == null) && (this.Last == null))
        {
            Head = Newn;
            Last = Newn;
        }
        else
        {
            Last.Next = Newn;
            Newn.Next = Head;
            Newn.Prev = Last;
            Last = Newn;
        }
        this.Count++;
    }

    public void InsertAtPos(int No,int iPos)
    {
        Node Newn = new Node(No);
        if((iPos < 1) || (iPos > Count +1))
        {
            return;
        }
        else if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if(iPos == Count + 1)
        {
            InsertLast(No);
        }
        else
        {
            int iCnt = 0;
            Node temp = Head;

            for(iCnt = 1; iCnt <iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            Newn.Next = temp.Next;
            temp.Next.Prev = Newn;

            temp.Next = Newn;
            Newn.Prev = temp;
        }
        this.Count++;
    }
    public void DeleteFirst()
    {
        if((Head == null) && (Last== null))
        {
            return;
        }

        else if(Head == Last)
        {
            Head = null;
            Last = null;
        }
        else
        {
            Head = Head.Next;
            Head.Prev = Last;
            Last.Next = Head;
            Count--;
        }
    }
    public void DeleteLast()
    {
        if((Head == null) && (Last == null))
        {
            return;
        }
        else if(Head == Last)
        {
            Head = null;
            Last = null;
        }
        else
        {
            Last = Last.Prev;
            Head.Prev = Last;
            Last.Next = Head;
            Count--;
        }
    }
    public void DeleteAtPos(int iPos)
    {
        if((iPos < 1) || (iPos > Count +1))
        {
            return;
        }
        else if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == Count + 1)
        {
            DeleteLast();
        }
        else
        {
            int iCnt = 0;
            Node temp2 = null;
            Node temp1 = Head;

            for(iCnt = 1; iCnt < iPos-1; iCnt++)
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
        do
        {
            System.out.print("| "+temp.Data+"| <=>");
            temp = temp.Next;
        }while(temp != Last.Next);
        System.out.println("\n");
    }

    public int CountNodes()
    {
        return this.Count;
    }
}

class DoublyCircular
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

        obj1.DeleteAtPos(3);
        obj1.Display();

        int ret = obj1.CountNodes();

        System.out.println("Number of nodes are : "+ret);
    }
} 