class Solution {
    public int compareVersion(String v1, String v2) {
    int n1 = v1.length();int n2 = v2.length();
    int x1 = 0, x2 = 0;
    for (int i = 0, j = 0; i < n1 || j < n2; i++, j++) {
        while (i < n1 && v1.charAt(i) != '.') {
            x1 = 10 * x1 + (v1.charAt(i++) - '0');
        }
        while (j < n2 && v2.charAt(j) != '.') {
            x2 = 10 * x2 + (v2.charAt(j++) - '0');
        }
        if (x1 < x2)
            return -1;
        else if (x1 > x2)
            return 1;
        x1 = 0;
        x2 = 0;
    }
    return 0;
    }
}