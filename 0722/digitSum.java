public static int digitSum(int n) {
    if (n == 0) {
        return 0;
    }
    return (n % 10) + digitSum(n / 10);
}

System.out.println(digitSum(1234));  // 輸出 10（1+2+3+4）
System.out.println(digitSum(7));     // 輸出 7
System.out.println(digitSum(1001));  // 輸出 2