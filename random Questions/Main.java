import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main {
    static InputStream inputStream;
    static PrintWriter printWriter;
    static String inputString = "";

    public static void main(String[] args) throws Exception {
        inputStream = inputString.isEmpty() ? System.in : new ByteArrayInputStream(inputString.getBytes());
        printWriter = new PrintWriter(System.out);
        solve();
        printWriter.flush();
    }

    static void solve() {
        for (int testCases = nextInt(); testCases > 0; testCases--) {
            long A = nextLong(), B = nextLong(), C = nextLong();
            int n = nextInt();
            long xSum = 0, ySum = 0;
            for (int d = 1; d <= n; d++) {
                long gcdResult = gcd(d, A + B);
                if ((C + B * A) % gcdResult != 0)
                    continue;
                long dg = d / gcdResult;
                long dab = (A + B) / gcdResult;
                long start = -(B * A + C) / gcdResult % dg * inverseModulo(dab, dg) % dg;
                if (start < 0)
                    start += dg;
                for (long a = start; a <= n; a += dg) {
                    long b = B + d;
                    assert ((A + B) * a + C + B * A) % d == 0;
                    long c = ((A + B) * a + C + B * A) / d + A;
                    if (a + b <= n && a + c <= n && (a | b | c) == a + b + c) {
                        xSum += a + b;
                        ySum += a + c;
                    }
                }
            }
            printWriter.println(xSum + " " + ySum);
        }
    }

    static long inverseModulo(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }

    static long gcd(long a, long b) {
        while (b > 0) {
            long c = a;
            a = b;
            b = c % b;
        }
        return a;
    }

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = inputStream.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static byte[] inbuf = new byte[1024];
    private static int lenbuf = 0, ptrbuf = 0;

    static long nextLong() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
