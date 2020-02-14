public class Solve {
    SacADos sac;
    Set set;
    int[][] table;

    public Solve(SacADos sac, Set set) {
        this.sac = sac;
        this.set = set;
        table = new int[set.size() + 1][sac.capacity + 1];
        fill(table);
        System.out.println(table[set.size()][sac.capacity]);

    }

    public void fill(int[][] table) {
        for (int i = 1; i < table.length; i++) {
            for (int p = 0; p < table[i].length; p++) {
                if (set.content.get(i - 1).getPoid() > p) table[i][p] = table[i - 1][p];
                else
                    table[i][p] = Math.max(table[i - 1][p], table[i - 1][p - set.content.get(i - 1).getPoid()] + set.content.get(i - 1).getVal());
            }
        }
    }
}
