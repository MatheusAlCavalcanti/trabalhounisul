
import java.util.HashMap;
import java.util.HashSet;

public class Automata {
    private HashMap<Integer, State> states;
    private HashSet<Integer> finalStates;
    private HashSet<Transition> transitions;
    private State startState;
    private static int startStateLimit = 0;

    public Automata() {
        this.states = new HashMap<>();
        this.finalStates = new HashSet<>();
        this.transitions = new HashSet<>();
    }

    public void setState(int id) {
        State state = new State(id);
        states.put(id, state);
    }

    public void setFinalstate(int id) {
        finalStates.add(id);
    }

    public void setStartState(int id) {
        this.startState = states.get(id);
    }

    public void setTransition(int origin, int destiny, String symbol) {
        State originState = states.get(origin);
        State destinyState = states.get(destiny);
        Transition transition = new Transition(originState, destinyState, symbol);
        transitions.add(transition);
    }

    public Transition getTransition(int origin, String symbol) {
        for (Transition transition : transitions) {
            if (transition.getOrigin().getId() == origin && transition.getSymbol().equals(symbol)) {
                return transition;
            }
        }
        return null;
    }

    public State getStartState() {
        return startState;
    }

    public State getFinalState(int id) {
        return states.get(id);
    }

    public int getFinalStateSize() {
        return finalStates.size();
    }

    public State getState(int id) {
        return states.get(id);
    }

    public boolean isStartState(int id) {
        return startState.getId() == id;
    }

    public boolean isFinalState(int id) {
        return finalStates.contains(id);
    }

   
}