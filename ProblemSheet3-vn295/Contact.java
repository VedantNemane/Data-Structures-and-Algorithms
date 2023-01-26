public class Contact implements Comparable<Contact> {
    public String firstName;
    public String lastName;

    public Contact(String f, String l) {
        firstName = f; lastName = l;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public int compareTo(Contact c) {
        // TODO Q1

        int lastnamecomp, firstnamecomp;
        lastnamecomp = this.lastName.compareTo(c.lastName);
        firstnamecomp = this.firstName.compareTo(c.firstName);

        if (lastnamecomp == 0){
            return firstnamecomp;
        } else {
            return lastnamecomp;
        }

    }
}
