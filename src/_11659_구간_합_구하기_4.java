import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659_구간_합_구하기_4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] ranges = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            ranges[i][0] = Integer.parseInt(st.nextToken()) - 1;
            ranges[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] accArr = new int[n];
        accArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            accArr[i] = accArr[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            int sum = accArr[ranges[i][1]];
            if (ranges[i][0] - 1 >= 0) {
                sum -= accArr[ranges[i][0] - 1];
            }

            System.out.println(sum);
        }
    }
}
