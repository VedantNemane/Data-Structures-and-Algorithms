public class DNABook implements SocialNetwork{

    int maxUsers;
    String[][] friendGrid;

    public DNABook(){
        maxUsers = 1;
        friendGrid = new String[101][101];
    }

    @Override
    public void registerUser(String name) {
        if (maxUsers < 100){
            friendGrid[0][maxUsers] = name;
            friendGrid[maxUsers][0] = name;
            maxUsers = maxUsers + 1;
        }
    }

    public int findUser(String name){
        for (int i = 0; i < maxUsers; i++){
            if (friendGrid[0][i] == name){
                return i;
            }
        }
        return -1;
    }

    public int compareStrings(String string1, String string2){
        if (string1.length() == string2.length())
        {
            for (int i = 0; i < string1.length(); i++){
                if (string1.charAt(i) < string2.charAt(i)){
                    return 1;
                } else if (string1.charAt(i) > string2.charAt(i)){
                    return -1;
                }
            }
        } else if (string1.length() < string2.length()){
            for (int i = 0; i < string1.length(); i++){
                if (string1.charAt(i) < string2.charAt(i)){
                    return 1;
                } else if (string1.charAt(i) > string2.charAt(i)){
                    return -1;
                }
            }
        } else {
            for (int i = 0; i < string2.length(); i++){
                if (string2.charAt(i) < string1.charAt(i)){
                    return -1;
                } else if (string2.charAt(i) > string1.charAt(i)){
                    return 1;
                }
            }
        }
        return 0;
    }

    public int binarySearch(String name){
        int min = 0, max = maxUsers, mid = maxUsers / 2;
        int condition = compareStrings(friendGrid[0][mid], name);
        int counter = 0;
        while (condition != 0){
            if (condition == 1){
                min = mid;
            } else if (condition == -1){
                max = mid;
            }
            mid = (max + min) / 2;
            condition = compareStrings(friendGrid[0][mid], name);
            counter++;

            if (counter > 8){
                return -1;
            }
        }
        return mid;
    }

    @Override
    public void becomeFriends(String name1, String name2) {
        int position1, position2;

        position1 = binarySearch(name1);
        position2 = binarySearch(name2);

        friendGrid[position1][position2] = "*";
        friendGrid[position2][position1] = "*";
    }

    @Override
    public boolean areTheyFriends(String name1, String name2) {
        int position1, position2;

        position1 = binarySearch(name1);
        position2 = binarySearch(name2);

        return friendGrid[position1][position2] != null;
    }
}
