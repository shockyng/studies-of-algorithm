import java.util.Random;

public class Exercise001QuickFind {

    public static void main(String[] args) {
        QuickFindUF quickFindUf = new QuickFindUF(8);
        quickFindUf.printMatrix();
        quickFindUf.union(0, 7);
        quickFindUf.printMatrix();
        quickFindUf.union(1, 5);
        quickFindUf.printMatrix();
        quickFindUf.union(7, 6);
        quickFindUf.printMatrix();
    }

    static class QuickFindUF {

        private final int[] ids;

        public QuickFindUF(int numberOfElements) {
            ids = new int[numberOfElements];
            Random random = new Random();

            for (int i = 0; i < numberOfElements; i++) {
                ids[i] = Math.abs(random.nextInt());
            }
        }

        public Boolean isConnected(int x, int y) {
            return ids[x] == ids[y];
        }

        public void union(int pointToBeConnected, int target) {
            if (!isConnected(pointToBeConnected, target)) {
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == ids[pointToBeConnected]) {
                        ids[i] = ids[target];
                    }
                }
            }
        }

        public void printMatrix() {
            System.out.println("\n Position     Value");
            for (int i = 0; i < ids.length; i++) {
                System.out.printf("--- %s ----> %s \n", i, ids[i]);
            }
        }
    }
}
