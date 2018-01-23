package phoneConvert;

import java.util.Scanner;

public class alphaPhone
{

    public static void main(String[] args)
    {
        String workChar = "";
        String phoneAlpha = "STATEFARM";
        String phoneNum = "";
        String[] digit = new String[]
        { "1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9",
                "0" };
        System.out.println("Enter you alpha number: ");
        Scanner input = new Scanner(System.in);
        phoneAlpha = input.next();
        phoneAlpha = phoneAlpha.toUpperCase();

        if (phoneAlpha.length() > 11)
        {
            phoneAlpha = phoneAlpha.substring(0, 11);
        }
        if (phoneAlpha.length() > 7 && phoneAlpha.length() < 10)
        {
            phoneAlpha = phoneAlpha.substring(0, 7);
        }

        for (int i = 0; i < phoneAlpha.length(); i++)
        {
            workChar = phoneAlpha.substring(i, i + 1);


            for (int j = 0; j < digit.length; j++)
            {
                ;
                if (digit[j].contains(workChar))
                {
                    phoneNum = phoneNum
                            + digit[j].substring(digit[j].length() - 1);
                    // found = 1;
                }

            }

            if (i == 2)
            {
                phoneNum = phoneNum + "-";
            }

        }
        System.out.println("Your converted phone number is: " + phoneNum);
        input.close();

    }

}
