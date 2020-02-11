public class Match {
    private Pair first;
    private Pair second;

    public Match(Pair newFirst, Pair newSecond){
        first = newFirst;
        second = newSecond;
    }

    public Pair getFirst() {
        return first;
    }

    public void setFirst(Pair first) {
        this.first = first;
    }

    public Pair getSecond() {
        return second;
    }

    public void setSecond(Pair second) {
        this.second = second;
    }
}
