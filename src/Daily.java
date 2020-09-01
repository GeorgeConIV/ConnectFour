import java.util.ArrayList;
import java.util.List;

public class Daily
{
    public Daily()
    {}

    public void zigZag(int k, String str)
    {
        int strLen = str.length();
        Character[][] formatted = new Character[strLen][k];
        for(int i=0;i<k;i++)
            for(int j=0;j<strLen;j++)
                formatted[j][i] = ' ';
        int count = 0;
        int kLevel=0;
        boolean ascending = true;

        while(count<strLen)
        {
            if(ascending)
            {
                formatted[count][kLevel] = str.charAt(count);

                if(kLevel==k-1)
                {
                    ascending = false;
                    kLevel--;
                }
                else
                {
                    kLevel++;
                }
            }
            else
            {
                formatted[count][kLevel] = str.charAt(count);

                if (kLevel == 0)
                {
                    ascending = true;
                    kLevel++;
                } else
                {
                    kLevel--;
                }
            }

            count++;
        }

        for(int i=0;i<k;i++)
        {
            for(int j=0;j<strLen;j++)
            {
                System.out.print(formatted[j][i]);
            }
            System.out.println();
        }


    }
}
/**
 * k=3
 * stringtest
 * s   n   s
 * 1   5   9
 *  t i g e t
 *  2 4 6 8 10
 *   r   t
 *   3   7
 * String temp = "";
 *             int tempCount = 0;
 *             while(tempCount<k)
 *             {
 *                 temp = temp.concat()
 *                 tempCount++;
 *             }
 */