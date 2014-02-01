/*Implement strStr() Total Accepted: 5314 Total Submissions: 26315 My Submissions 





Implement strStr(). 

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack. 
*/

public class ImplementstrStr {
	public String strStr(String haystack, String needle) {
        int len = needle.length();
        if(haystack == "" && needle == "")
            return needle;
        if(haystack == "")
            return null;
        if(len > haystack.length())
            return null;
        if(len == haystack.length()){
            if(haystack.equals(needle))
                return needle;
            else
                return null;
        }
        for(int i=0;i<haystack.length()-len;i++){
            if((haystack.substring(i,i+len)).equals(needle)){
                return haystack.substring(i);
            }
        }
        return null;
    }

}
