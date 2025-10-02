class GamePrompt{
    private String welcomePrompt;
    private String AskNextMovePrompt;
    private String winPrompt;
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

    public void setWelcomePrompt(String welcomePrompt) {
        this.welcomePrompt = welcomePrompt;
    }
    public void setAskNextMovePrompt(String AskNextMovePrompt) {
        this.AskNextMovePrompt = AskNextMovePrompt;
    }
    public void setWinPrompt(String winPrompt) {
        this.winPrompt = winPrompt;
    }

    public String getWelcomePrompt() {
        return welcomePrompt;
    }
    public String getAskNextMovePrompt() {
        return AskNextMovePrompt;
    }
    public String getWinPrompt() {
        return winPrompt;
    }

    public void printWelcomePrompt(){
        System.out.println(getWelcomePrompt());
    }
    public void printAskNextMovePrompt(){
        System.out.println(getAskNextMovePrompt());
    }
    public void printWinPrompt(){
        System.out.println(getWinPrompt());

    }
    public static void printSplitLine(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }
    public GamePrompt() {
    }}