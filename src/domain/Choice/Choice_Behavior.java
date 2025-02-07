package domain.Choice;

public enum Choice_Behavior {
    CHARGE(0), ON(1), OFF(2), GO(3), BACK(4), AUTOMOVE(5), AUTOPARKING(6), SHOWUSER(7), RETURN(8);

    private int choice;

    Choice_Behavior(int choice) {
        this.choice = choice;
    }

    public int getChoice() { return choice; }

    public static Choice_Behavior fromChoice (int choice_user) {
        for (Choice_Behavior choiceBehavior : Choice_Behavior.values()) {
            if (choiceBehavior.getChoice() == choice_user) {
                return choiceBehavior;
            }
        }
        return null; // 예외 처리를 위해 null 반환
    }

}
