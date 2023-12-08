
public class ExemploC {

    public static void main(String[] args) {
        Automata newAutomata = new Automata();
        String symbol = "11101100100";

        if (symbol.isEmpty()) {
            System.out.println("Este autômato não aceita transições vazias!");
            System.exit(0);
        }

        Transition transition;
        State destiny;

        newAutomata.setState(0);
        newAutomata.setState(1);
        newAutomata.setState(2);
        newAutomata.setState(3);
        newAutomata.setState(4);
        newAutomata.setState(5);
        newAutomata.setState(6);
        newAutomata.setState(7);

        newAutomata.setStartState(0);
        newAutomata.setFinalstate(2);
        newAutomata.setFinalstate(4);
        newAutomata.setFinalstate(6);
        newAutomata.setFinalstate(7);

        int finalStates[] = {2, 4, 6, 7};

        newAutomata.setTransition(0, 0, "0");
        newAutomata.setTransition(0, 1, "1");
        newAutomata.setTransition(1, 3, "0");
        newAutomata.setTransition(1, 5, "1");
        newAutomata.setTransition(2, 0, "0");
        newAutomata.setTransition(2, 1, "1");
        newAutomata.setTransition(3, 2, "0");
        newAutomata.setTransition(3, 4, "1");
        newAutomata.setTransition(4, 3, "0");
        newAutomata.setTransition(4, 5, "1");
        newAutomata.setTransition(5, 6, "0");
        newAutomata.setTransition(5, 7, "1");
        newAutomata.setTransition(6, 2, "0");
        newAutomata.setTransition(6, 4, "1");
        newAutomata.setTransition(7, 6, "0");
        newAutomata.setTransition(7, 7, "1");

        headerMessage(symbol, newAutomata, finalStates);
        int i = 0;
        int origin = 0;

        while (i < symbol.length()) {
            if (!(symbol.charAt(i) == ' ')) {
                transition = newAutomata.getTransition(origin, "" + symbol.charAt(i));
                destiny = transition.getDestiny();
                origin = destiny.getId();
                System.out.println("Leu o símbolo \"" + symbol.charAt(i) +
                        "\" foi para o \"" + destiny.getName() +
                        "\"  " + destiny.getLabel());
                i++;
            } else {
                System.out.println("Este autômato não aceita transições vazias!!!");
                System.exit(0);
            }
        }

        finalStateOfAutomata(symbol, newAutomata, origin);
    }

    public static void headerMessage(String symbol, Automata myAutomata, int finalStates[]) {
        System.out.println("\nDFA reconhecedor da expressão regular (0+1)*1(0+1)(0+1) ");
        System.out.println("Verifica a entrada \"" + symbol + "\"\n");

        System.out.println("Definição dos Estados:");
        System.out.println("\t" + "Estado Inicial " + " - " + myAutomata.getStartState().getName() 
        		+ myAutomata.getStartState().getLabel());

        for (int j = 0; j < myAutomata.getFinalStateSize(); j++) {
            State finalState = myAutomata.getFinalState(finalStates[j]);
            System.out.println("\t" + "Estado Final " + " - " + finalState.getName() + finalState.getLabel());
        }
    }


    public static void finalStateOfAutomata(String symbol, Automata myAutomata, int origin) {
        if (myAutomata.isFinalState(origin)) {
            System.out.println("\nA entrada \"" + symbol + "\" foi aceita !!!\n");
        } else {
            System.out.println("\nA entrada \"" + symbol + "\" foi rejeitada !!!\n");
        }
    }
}
