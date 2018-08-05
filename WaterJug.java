import java.util.*;
class State {
    int x, y;
    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class WaterJug {
    public static Stack < State > stack = new Stack < State > ();
    public static ArrayList < State > visited = new ArrayList < State > ();
    public static void main(String args[]) {
        State startState = new State(0, 0);

        stack.push(startState);

        while (!stack.empty()) {

            State s = stack.pop();

            System.out.print("--> (" + s.x + "," + s.y + ")");

            if (s.x == 2) break;

            generateStates(s);

        }
    }
    public static void generateStates(State s) {
        if (s.x < 4) {
            pushState(new State(4, s.y));
        }
        if (s.y < 3) {
            pushState(new State(s.x, 3));
        }
        if (s.x > 0) {
            pushState(new State(0, s.y));
        }
        if (s.y > 0) {
            pushState(new State(s.x, 0));
        }
        if (0 < (s.x + s.y) && (s.x + s.y) >= 4 && s.y > 0) {
            pushState(new State(4, s.y - (4 - s.x)));
        }
        if (0 < (s.x + s.y) && (s.x + s.y) >= 3 && s.x > 0) {
            pushState(new State(s.x - (3 - s.y), 3));
        }
        if (0 < (s.x + s.y) && (s.x + s.y) <= 4 && s.y >= 0) {
            pushState(new State(s.x + s.y, 0));
        }
        if (0 < (s.x + s.y) && (s.x + s.y) <= 3 && s.x >= 0) {
            pushState(new State(0, s.x + s.y));
        }
    }
    public static void pushState(State s) {
        if (!checkIfVisited(s)) {
            stack.push(s);
            visited.add(s);
        }
    }
    public static boolean checkIfVisited(State s) {
        for (State st: visited) {
            if (st.x == s.x && st.y == s.y) return true;
        }
        return false;
    }
}