public class Solution {
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (matrix.length == 0) {
        return list;
    }
    int ilow = 0, ihigh = matrix.length - 1;
    int jlow = 0, jhigh = matrix[0].length - 1;
    while (ilow <= ihigh && jlow <= jhigh) {
        // across
        for (int j = jlow; j <= jhigh && ilow <= ihigh; j++) {
            list.add(matrix[ilow][j]);
        }
        ilow++;

        // down
        for (int i = ilow; i <= ihigh && jlow <= jhigh; i++) {
            list.add(matrix[i][jhigh]);
        }
        jhigh--;

        // bottom
        for (int j = jhigh; j >= jlow && ilow <= ihigh; j--) {
            list.add(matrix[ihigh][j]);
        }
        ihigh--;

        // up
        for (int i = ihigh; i >= ilow && jlow <= jhigh; i--) {
            list.add(matrix[i][jlow]);
        }
        jlow++;
    }
    return list;
}
}