package model;

public class GoalSubiti {

    public int goalSubiti;
    public Calciatori calciatore;
    public Militanza militanza;

    public GoalSubiti(int goalSubiti, Calciatori calciatore, Militanza militanza) {
        this.goalSubiti = goalSubiti;
        this.calciatore = calciatore;
        this.militanza = militanza;
    }

    public int getGoalSubiti() {
        return goalSubiti;
    }

    public void setGoalSubiti(int goalSubiti) {
        this.goalSubiti = goalSubiti;
    }

    public Calciatori getCalciatore() {
        return calciatore;
    }

    public void setCalciatore(Calciatori calciatore) {
        this.calciatore = calciatore;
    }

    public Militanza getMilitanza() {
        return militanza;
    }

    public void setMilitanza(Militanza militanza) {
        this.militanza = militanza;
    }

}
