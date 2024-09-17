package htl.grieskirchen.POS;

public class EratosthenesPrimeSieve implements PrimeSieve{

    private final int bound;

    private final boolean[] marked;

    public EratosthenesPrimeSieve(int bound) {
        this.bound = bound;
        marked = new boolean[bound + 1];
    }

    @Override
    public boolean isPrime(int p) {
        if (!marked[2]) {
            for (int i = 2; i <= bound; i++) {
                marked[i] = true;
            }
            for (int j = 2; j <= bound; j ++){
                for (int i = j; i * j <= bound; i++) {
                    marked[j * i] = false;
                }
            }
        }
        return marked[p];
    }

    @Override
    public void printPrimes() {
        for (int i = 2; i <= bound; i++) {
            if (i == 2) {
                System.out.print(i);
            }

            if (isPrime(i) && i > 2) {
                System.out.print(", " + i);
            }
        }
    }
}
