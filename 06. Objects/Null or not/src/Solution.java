import java.util.Objects;

public class Solution {
    public Object printIsNull(Object o) {
        // write your code here
        return Objects.isNull(o)? "It's null" : "It's an object";
    }
}