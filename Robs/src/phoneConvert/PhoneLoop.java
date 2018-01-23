package phoneConvert;

import java.util.Scanner;

public class PhoneLoop
{

   public static void main(String[] args)
   {
      String workChar = null;
      String phoneAlpha = "STATEFARM";
      String phoneNumeric = "";
      String[] digits = new String[] { "1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9", "0" };

      System.out.print("Enter you alpha number: ");
      Scanner input = new Scanner(System.in);
      
      phoneAlpha = input.next();
      phoneAlpha = phoneAlpha.toUpperCase();
      
      if (phoneAlpha.length() > 7);
      {
         phoneAlpha = phoneAlpha.substring(0, 7);
      }


      
      for (int i = 0; i < phoneAlpha.length(); i++)
      {
         workChar = phoneAlpha.substring(i, i + 1);

         for (int j = 0; j < digits.length; j++)
         {

            if (digits[j].contains(workChar))
            {
               phoneNumeric = phoneNumeric + digits[j].substring(digits[j].length() - 1);
            }

         }
         if (i == 2)
         {
            phoneNumeric = phoneNumeric + "-";
         }
         input.close();
      }
      System.out.println("Your converted phone number is: " + phoneNumeric);

   }

}
