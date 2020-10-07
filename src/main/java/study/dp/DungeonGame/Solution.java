package study.dp.DungeonGame;


class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int rowCount = dungeon.length;
        int colCount = dungeon[0].length;

        int[][] health = new int[rowCount][colCount];
        for (int i = rowCount - 1; i >= 0; i--) {

            for (int j = colCount - 1; j >= 0; j--) {

                if (i == rowCount - 1 && j == colCount - 1) {
                    health[i][j]
                            = Math.max(1 - dungeon[rowCount - 1][colCount - 1], 1);
                } else if (i == rowCount - 1) {
                    health[i][j] =
                            Math.max(1, health[i][j + 1] - dungeon[i][j]);
                } else if (j == colCount - 1) {
                    health[i][j] = Math.max(1, health[i + 1][j] - dungeon[i][j]);
                } else {
                    health[i][j] = Math.min(
                            Math.max(1, health[i][j + 1] - dungeon[i][j]),
                            Math.max(1, health[i + 1][j] - dungeon[i][j])
                    );
                }
            }
        }

        return health[0][0];
    }

}