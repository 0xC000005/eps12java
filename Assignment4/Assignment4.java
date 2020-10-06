/**
 * @author Max 
 * @version 2020-09-15
 */
public class Assignment4 {
    private int numStudents, playersPerTeam, numTeams, leftOvers;
    private Input input = new Input();

    public Assignment4() {
        setNumStudents();
        setPlayersPerTeam();
        setNumTeams(getNumStudents() / getPlayersPerTeam());
        setLeftOvers(getNumStudents() % getPlayersPerTeam());
        display();
    }

    public void setNumStudents() {
        System.out.print("How many students? ");
        numStudents = input.getInt();
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setPlayersPerTeam() {
        System.out.print("How many students per team? ");
        playersPerTeam = input.getInt();
    }

    public int getPlayersPerTeam() {
        return playersPerTeam;
    }

    public void setNumTeams(int numTeams) {
        this.numTeams = numTeams;
    }

    public int getNumTeams() {
        return numTeams;
    }

    public void setLeftOvers(int leftOvers) {
        this.leftOvers = leftOvers;
    }

    public int getLeftOvers() {
        return leftOvers;
    }

    public void display() {
        System.out.println("You have a P.E. class with " + getNumStudents() + " students.");
        System.out.println("For a team game with " + getPlayersPerTeam() + " players per side");
        System.out.println();
        System.out.println("You will have " + getNumTeams() + " teams and " + getLeftOvers() + " players leftover.");
    }

    public static void main(String[] args) {
        Assignment4 testObject = new Assignment4();
    }
}
