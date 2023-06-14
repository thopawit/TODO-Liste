public class ENTRY implements DATA {
    String name;
    boolean status;
    int duration;
    int priority;

    ENTRY(String nameN, int durationN, boolean statusN, int priorityN) {
        name = nameN;
        duration = durationN;
        status = statusN;
        priority = priorityN;
    }
    public int GetPriority() {
        return priority;
    }

    public void SetPriority(String priorityN) {
        if(priorityN == "hoch") {
            priority = 2;
        }
        else if (priorityN == "niedrig") {
            priority = 0;
        }
        else {
            priority = 1;
            System.out.println("Die Prioriät wurde auf normal gesetzt. Du kannst hoch oder niedrig eingeben um diese zu ändern.");
        }
    }

    public String GetName() {
        return name;
    }

    public void SetName(String nameN) {
        name = nameN;
    }

    public int GetDuration() {
        return duration;
    }

    public void SetDuration(int durationN) {
        duration = durationN;
    }

    public boolean GetStatus() {
        return status;
    }

    public void SetStatus(boolean statusN) {
        status = statusN;
    }
}

