public class StringRepeater {
    public String repeatString(String s, int n){
        String result = "";
        for(int i=0; i<n; i++) {
            result = result + s;
        }
        return result;
    }

    public StringBuffer optimisedRepeatString(String s, int n){
        StringBuffer newResult = new StringBuffer();
        for (int i=0; i<n; i++){
            newResult.append(s);
        }
        return newResult;
    }
}
