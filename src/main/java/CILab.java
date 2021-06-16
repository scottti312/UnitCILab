import sun.text.normalizer.UCharacter;

public class CILab implements CILabInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public boolean detectCapitalUse() {
        // correct1 = "USA"
        // correct2 = "leetcode"
        // correct3 = "Google"
        boolean correct1 = true, correct2 = true, correct3 = false;

        for (int i = 0; i < myString.length(); i++) {
            if (!Character.isUpperCase(myString.charAt(i)) && Character.isLetter(myString.charAt(i)))
                correct1 = false;
            if (Character.isUpperCase(myString.charAt(i)) && Character.isLetter(myString.charAt(i)))
                correct2 = false;
            if (i == 0 && Character.isUpperCase(myString.charAt(i)) && Character.isLetter(myString.charAt(i)))
                correct3 = true;
            if (i != 0 && Character.isUpperCase(myString.charAt(i)) && Character.isLetter(myString.charAt(i)))
                correct3 = false;
        }
        System.out.printf("Correct1 = %s\nCorrect2 = %s\nCorrect3 = %s", correct1, correct2, correct3);
        return (correct1 || correct2 || correct3);
    }

}

