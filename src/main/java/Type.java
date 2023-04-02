public enum Type {
    INCOME ("przychód", "P"),
    EXPENSE ("wydatek", "W");

    final String pl;
    final String letter;

    Type(String pl, String letter) {
        this.pl = pl;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return pl + " (" + letter + ")";
    }
}
