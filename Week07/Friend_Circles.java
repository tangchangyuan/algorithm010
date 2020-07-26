class Friend_Circles {
    public int findCircleNum(int[][] M) {
        int n = M.length * M.length;
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
        // int[][] visit = new int[M.length][M.length];
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    uf.unint(i, j);
                }
            }
        }
        return uf.friend;
    }


    class UF {
        int[] parent;
        int friend;
        public UF(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.friend = n;
        }

        public void unint(int a, int b) {
            int aP = find(a);
            int bP = find(b);
            if (aP != bP) {
                parent[bP] = aP;
                friend -= 1;
            }
        }

        private int find(int c) {
            int tmp = c;
            while (parent[tmp] != tmp) {
                tmp = parent[tmp];

            }
            return parent[tmp];
        }
    }
}