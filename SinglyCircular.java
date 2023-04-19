//////////////////////////////////////////////////////////////////////////////
//
// Function Name :
// Description   :  Singly CIRCULAR Linked List
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

    public Node(int No)
    {
        this.Data = No;
        this.Next = null;
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
            Newn.Next = this.Head;
            this.Head = Newn;
        }
        Last.Next = Newn;
        this.Count++;
    }
    public void InsertLast(int No)
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
            this.Last = Newn;
        }
        Last.Next = this.Head;
        this.Count++;   
    }

    public void InsertAtPos(int No,int iPos)
    {
        Node Newn = new Node(No);

        if((iPos < 1) || (iPos > Count +1))
        {
            System.out.println("Invalid Position :");
        }
        else if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if(iPos == Count +1)
        {
            InsertLast(No);
        }
        else
        {
            Node temp = this.Head;
            for(int iCnt = 1; iCnt < iPos - 1; iCnt++)
            {
                temp = temp.Next;
            }
            Newn.Next = temp.Next;
            temp.Next = Newn;
        }
        this.Count++; 
    }
    
    public void DeleteFirst()
    {
        if(this.Head == null)
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
            Last.Next = Head;
        }
        this.Count--;
    }

    public void DeleteLast()
    {
        if(this.Head == null)
        {
            return;
        }
        else if(this.Count == 1)
        {
            this.Head = null;
        }
        else
        {
            Node temp =this.Head;
            for(int iCnt = 1; iCnt <Count -1; iCnt++)
            {
                temp = temp.Next;
            }
            Last.Next = Head;
        }
        this.Count--;
    }

    public void DeleteAtPos(int iPos)
    {
        if((iPos < 1) || (iPos > Count +1))
        {
            System.out.println("Invalid Position :");
        }
        else if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == Count +1)
        {
            DeleteLast();
        }
        else
        {
            Node temp1 = this.Head;
            for(int iCnt = 1; iCnt < iPos - 1; iCnt++)
            {
                temp1 = temp1.Next;
            }
            Node temp2 = temp1.Next;
            temp1.Next = temp2.Next;
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

class SinglyCircular_DeleteAtPos
{
    public static void main(String Arg[])
    {
        SinglyCL obj1 = new SinglyCL();

        obj1.InsertFirst(51);
        obj1.InsertFirst(21);
        obj1.InsertFirst(11);
        obj1.Display();

        obj1.InsertLast(121);
        obj1.InsertLast(151);
        obj1.Display();

        obj1.InsertAtPos(111,4);
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