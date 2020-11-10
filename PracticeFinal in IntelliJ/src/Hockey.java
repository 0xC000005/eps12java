import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-11-09
 * @project PracticeFinal in IntelliJ
 * @description
 */
public class Hockey {
    private final ArrayList<Player> team = new ArrayList<>();
    private String teamName;
    private final Input input = new Input();

    public Hockey() {
        initTeam();
        System.out.print("""
                Welcome to Covid NHL

                What is the name of your Team?\s""");
        setTeamName(input.getString());
        System.out.println("""

                Enter the Goals, Assists, and Salary for each player
                """);
        setPlayersDetail();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(String firstName, String lastName) {
        team.add(new Player(firstName, lastName));
    }

    public void remove(int index)
    {
        team.remove(index);
    }

    public void initTeam()
    {
        addPlayer("Mike", "Pompeo");
        addPlayer("John", "Pence");
        addPlayer("Donald", "Trump");
        addPlayer("Stephen", "Bannon");
        addPlayer("Ted", "Cruz");
    }

    public void setPlayersDetail() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getFullName() + ":\n");
            addPlayerDetail(i);
            System.out.println();
        }
    }

    public void addPlayerDetail(int index) {
        System.out.print("Goals: ");
        team.get(index).setGoal(input.getIntWithNoneZeroErrorCheck());
        System.out.print("Assists: ");
        team.get(index).setAssist(input.getIntWithNoneZeroErrorCheck());
        System.out.print("Salary: ");
        team.get(index).setSalary(input.getDoubleWithNoneZeorErrorCheck());
    }

    public void displayTeam() {
        System.out.println("Surrey " + getTeamName() + " roster\n" +
                "\n" +
                "Name:\t\tGoals\tAssists\tPoints\tSalary\n");
        for (Player currentPlayer : team)
            System.out.println(currentPlayer.getFullName() + "\t" + currentPlayer.getGoal() + "\t" + currentPlayer.getAssist() + "\t" + currentPlayer.getPoint() + "\t$" + String.format("%.2f", currentPlayer.getSalary()));
    }

    public void runTeam()
    {
        displayTeam();
    }

    public static void main(String[] args) {
        Hockey testObject = new Hockey();
        testObject.runTeam();
    }
}
