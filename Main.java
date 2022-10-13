public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        Player p1 = new Player();
        p1.setName("Aftab");
        p1.setSymbol('0');
        Player p2 = new Player();
        p2.setName("Noman");
        p2.setSymbol('x');
        Game game = new Game(new Player[]{p1,p2}, board);
        game.play();
    }
}
