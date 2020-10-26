package main;

import java.util.ArrayList;

/**

* @author LXA

* 堆溢出

*/

public class Heap

{

    public static void main(String[] args)

    {

        ArrayList list=new ArrayList();

        while(true)

        {

            list.add(new Heap());

        }

    }

}