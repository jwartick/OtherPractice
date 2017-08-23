/* 
* http://javarevisited.blogspot.com/2011/06/top-programming-interview-questions.html
* Check whether or not string is a palindrome
* planning:
* ---------
* for(loop)
* array[i] = string.charAt(i)
* 
* boolean isPalindrome = true;
* for(array.len/2)
* if (!(array[i]=array[len-i])
* isPalindrome = false;
* break;
* 
*/

public class PalindromeCheck{
    public static void main(String[] args) 
    {
        String[] test = {"abba", "hello", "moon", "mom"};
        
        for(String each: test)
        {
            int loop = each.length();
            char[] char_arr = new char[loop];

            for (int i = 0; i < loop; i++)
            {
                char_arr[i] = each.charAt(i);
            }

            boolean isPalindrome = true;
            loop = char_arr.length / 2;
            int endpoint = char_arr.length - 1;
            for (int i = 0; i < loop; i++)
            {
                if (char_arr[i] != char_arr[endpoint - i])
                {
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println(each + " is a palindrome: " + isPalindrome + "!");
        }
    }
}
