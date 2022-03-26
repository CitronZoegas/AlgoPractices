package Algo;

import java.util.*;



import javax.swing.tree.TreeNode;
import java.util.*;

public class Algorithms {

    public Algorithms() {

    }
    /**
     * This acts as a separator to understand where a certain question ends.
     * ***********************************************************
     */
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;

            }

        }

        return j;
    }

    /**
     * ***********************************************************
     */
    public int StockCalculate(int[] prices) {
        /*int buy = 0;
        int sell = 0;
        int profit = 0;

        for (int i = 1; i <= prices.length; i++) {
            System.out.println(buy);
            if(prices[i] < prices[i-1]){
                buy += prices[i];
                buy -= prices[i];
            }


        }

        return profit;*/

        if(prices == null || prices.length == 0 ){
            return 0;
        }

        int profit = 0;

        for(int i=1; i < prices.length; i++){

            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }


    /**
     *
     * @param prices
     * LEETCODE TASK maxprofit: When to buy and when to sell
     * @return
     */
    /**
     * ***********************************************************
     */
    public int maxProfit2(int[] prices) {

        if(prices == null || prices.length == 0 ){
            return 0;
        }
        int profit = 0;
        int min = prices[0];

        for(int i=1; i < prices.length; i++){

            if(prices[i] < min) min = prices[i];
            profit = Math.max(profit, prices[i]-min);
            System.out.println(profit);
        }
        //System.out.println(profit[prices.length-1]);
        return profit;
    }

    /**
     *
     * LEETCODE TASK Rotate array
     *
     * @param nums
     * @param k
     * @return
     */

    /**
     * ***********************************************************
     */
    public int[] rotate(int[] nums, int k) {
        //nums is the array we want to rotate k amount of times.
        //k = amount of rotations.

        /*int[] temp = {nums.length};

        int lastIndex = nums.length-1;

        if(nums == null || nums.length ==0){
            return null;
        }*/

        /*
        for(int i=0; i < k; i++) {
            lastIndex = nums[nums.length-1];
            for(int j = nums.length-1;j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = lastIndex;
        }*/




        /*for(int i = 0; i <= nums.length-1; i++) {
            temp[(i+k) % nums.length] = nums[i];
        }


        return temp;
    }*/
        k = k % nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);


        return nums;
    }
    /**
     * ***********************************************************
     */
    public void reverse(int[]nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * ***********************************************************
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
    /*public boolean containsDuplicate(int[ nums]) {
        for(int i = 1; i < nums.length; i++;) {
            if(nums[i] == nums[i - 1]){
                return true;
            }
            return false;
        }
    }*/
    //bit changing solution to Single number
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums){
            res^=num;
        }
        return res;
    }
    /**
     * ***********************************************************
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
    /**
     * ***********************************************************
     */
    public int[] plusOne(int[] digits) {

        int[] onePlusArr = {digits.length};

        int L = digits.length;

        for(int i = L-1; i >=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] reSizeArray = new int[L+1];
        reSizeArray[0] = 1;
        return reSizeArray;
    }
    /**
     * ***********************************************************
     */
    public void moveZeroes(int[] nums) {

        if(nums == null || nums.length < 1) return;

        int tracker = 0;
        int length = nums.length;

        for(int i = 0; i < length; i++){
            if(nums[i] != 0) {
                nums[tracker] = nums[i];
                tracker++;
            }
        }
        for(int i = tracker; i < length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
    /**
     * ***********************************************************
     */
    public int[] twoSum(int[] nums, int target) {
        int [] a = new int[]{-1,-1};

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    break;
                }
            }
        }
        return a;
    }
    /**
     * ***********************************************************
     */
    public boolean isValidSudoku(char[][] board) {

        char period = '.';
        HashSet<String> grid = new HashSet<>();

        for(int row = 0; row<9;row++){
            for(int col = 0; col<9;col++){
                char bokstav = board[row][col];
                if(board[row][col] != period){
                    if( !grid.add(bokstav +"row"+ row) ||
                            !grid.add(bokstav +"col"+ col) ||
                            !grid.add(bokstav +"box of 3z3"+row/3 +"lol"+ col/3)
                    ) return false;
                }
            }
        }
        return true;
    }
    /**
     * ***********************************************************
     */
    public void rotate90degrees(int[][] matrix) {
        int length = matrix.length;
        for(int row =0; row<length; row++){
            for(int col = row; col < length; col++){
                int tempGrid = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tempGrid;
            }
        }
        for(int i =0; i<length; i++){
            for(int j =0; j<(length/2); j++){
                int tempGrid = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-1-j]= tempGrid;
                System.out.println(tempGrid);
            }
        }
    }
    /**
     * ***********************************************************
     */
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder(String.valueOf(s));
        sb.reverse();
        System.out.println(sb);

    }

    /**
     * ***********************************************************
     */
    public int firstUniqChar(String s) {

        int L = s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i<L; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
            }else{
                map.put(c,-1);
            }
        }
        int min = Integer.MAX_VALUE;

        for(char c : map.keySet()) {
            if(map.get(c)> -1 && map.get(c) < min){
                min = map.get(c);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    /**
     * ***********************************************************
     */
    public boolean isAnagram1(String s, String t) {

        List<Character> list = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            list2.add(t.charAt(j));

        }
        if(list2.containsAll(list)){
            System.out.println(list2.toString());
            return true;
        }

        return false;
    }

    /**
     * ***********************************************************
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];

        for(int i = 0; i<s.length(); i++){
            count[s.charAt(i)- 'a']++;
            count[t.charAt(i)- 'a']--;
        }

        for( int x : count){
            if(x != 0){
                return false;
            }
        }
        return true;
    }
    /**
     * ***********************************************************
     */
    public boolean isPalindrome(String s) {

        int left=0;
        int right=s.length()-1;

        if(s.isEmpty()){
            return true;
        }

        while(left<right ){
            while(left < right && !Character.isLetterOrDigit(left)) left++;
            while(left < right && !Character.isLetterOrDigit(right)) right++;
            if(Character.isLowerCase(s.charAt(left)) != Character.isLowerCase(s.charAt(right)) ){
                return false;
            }else {
                left++;
                right++;
            }
        }
        return true;
    }
    //&& !s.matches(("[A-Za-z0-9]").toLowerCase())

    /*public static boolean isLetterOrDigit(char c) {
        return  (c >= 'a' && c <= 'z')||
                (c >= 'A' && c <= 'Z')||
                (c >= '0' && c <= '9');
    }*/

    /**
     * ***********************************************************
     */
    public int myAtoi(String s) {

        if(s.isEmpty()){
            return 0;
        }
        int i = 0;
        int len = s.length();
        //remove spaces

        //remove spaces2
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        //check if string was only filled with whitespace

        if(i == len) {
            return 0;
        }

        int plusMinus = 1;
        char c = s.charAt(i);

        if(c == '-' || c == '+'){
            if(c == '-'){
                plusMinus = -1;
            }
            i++;
        }
        // making sure the char we grab from the string is a digit.
        //

        int r = 0;

        while(i < len && Character.isDigit(s.charAt(i))){
            int integer = s.charAt(i)-'0';
            if(r > Integer.MAX_VALUE/10 || (r==Integer.MAX_VALUE /10 && integer > Integer.MAX_VALUE % 10)){

                return plusMinus == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            r = r * 10 + integer;
            i++;
        }

        return plusMinus*r;
    }
    /**
     * ***********************************************************
     */
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0) return 0;

        int len = haystack.length();
        int leng = needle.length();

        for(int i =0; i <= (len-leng); i++){
            int j;
            for(j=0; j < leng; j++){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if(j == leng){
                return i;
            }
        }
        return -1;
    }
    /**
     * ***********************************************************
     */
    public String countAndSay(int n) {
        //n = 3322251;
        if(n==1){
            return "1";
        }

        StringBuilder endString = new StringBuilder();
        String value = countAndSay(n-1);
        for(int i = 1; i < value.length(); i++){
            int count = 1;
            while(i < value.length()-1 && value.charAt(i) == value.charAt(i+1)){
                i++;
                count++;
            }
            endString.append(count);
            endString.append(value.charAt(i));
        }
        return endString.toString();
    }

    /**
     * ***********************************************************
     */
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";

        if(strs.length == 1) return strs[0];
        int len = strs.length;
        sortArrays(strs);


        int shortest  = Math.min(strs[0].length(), strs[len-1].length());
        int i = 0;
        while(i < shortest && strs[0].charAt(i) == strs[len-1].charAt(i)){
            i++;
        }
        //String sub = strs[0].substring(0,i);
        return Arrays.toString(strs);
    }

    /**
     * ***********************************************************
     */
    public String sortArrays(String[] strs) {
        int len = strs.length;
        for(int i = 0;i < len; i++) {
            for(int j=i+1; j < len;j++){
                if(strs[i].compareTo(strs[j]) > 0){
                    String temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }
        return Arrays.toString(strs);
    }

    /**
     * ***********************************************************
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * ***********************************************************
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(0);
        ListNode fixer = head;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                fixer.next = list1;
            }else{
                fixer.next = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            fixer.next = list1;
        }else if(list2 != null) {
            list2.next = list2;
        }
        return head.next;

    }
    /**
     * ***********************************************************
     */
    public int romanToIntWrongOne(String s) {
        Map<Character, Integer> keyToValue = new HashMap<>();

        keyToValue.put('I', 1);
        keyToValue.put('V', 5);
        keyToValue.put('X', 10);
        keyToValue.put('L', 50);
        keyToValue.put('C', 100);
        keyToValue.put('D', 500);
        keyToValue.put('M', 1000);

        int arabicNumerals = 0;

        for(int i = 0; i<s.length(); i++){
            arabicNumerals = arabicNumerals + keyToValue.get(s.charAt(i));
        }
        return arabicNumerals;
    }
    /**
     * ***********************************************************
     */
    public boolean isCorrect() {
        Queue<Integer> queue = new LinkedList<Integer>();

        int lol = 101;
        Stack<Integer> stack = new Stack<>();
        stack.push(lol);
        stack.push(lol);
        System.out.println(stack);
        stack.pop();
        System.out.println("Amount: " + stack);
        return true;
    }
    /**
     * ***********************************************************
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * ***********************************************************
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0){
            return null;
        }


        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[]nums, int left, int right){
        if(left>right){
            return null;
        }
        int midInt = left + (right - left)/2;

        TreeNode currNode = new TreeNode(nums[midInt]);
        currNode.left = helper(nums,left,midInt-1);
        currNode.right = helper(nums,midInt+1,right);
        return currNode;
    }
    public TreeNode nextAlgorithm() {
        String a = "jallapeno";


        for(int i = 0; i<a.length(); i++){
            
        }
        return null;
    }

    /**
     * ***********************************************************
     */

    public boolean betterSudoku(char[][] board){
        char period = '.';
        HashSet<String> grid = new HashSet<>();

        for(int row = 0; row<9;row++){
            for(int col = 0; col<9;col++){
                char bokstav = board[row][col];
                if(board[row][col] != period){
                    if( !grid.add(bokstav +"row"+ row) ||
                            !grid.add(bokstav +"col"+ col) ||
                            !grid.add(bokstav +"box of 3z3"+row/3 +"lol"+ col/3)
                    )
                        return false;
                }
            }
        }
        return true;
    }
    /**
     * ***********************************************************
     */
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }

        int[]dynamicPr = new int[n + 1];
        dynamicPr[1] = 1;
        dynamicPr[2] = 2;
        //dynamicPr[3] = 3;

        for(int i = 3; i <= n; i++){
            dynamicPr[i] = dynamicPr[i-1]+dynamicPr[i-2];
        }
        return dynamicPr[n];
    }

    /**
     * ***********************************************************
     */
    public int maxProfit(int[] prices) {

        int previousBiggest = 0;
        int previousMinimum = Integer.MAX_VALUE;
        int len = prices.length;

        for(int i = 0; i < len; i++){
            if(prices[i] < previousMinimum){

                previousMinimum = prices[i];
            }else{
                previousBiggest = Math.max(previousBiggest,prices[i] - previousMinimum);
            }
        }
        return previousBiggest;
    }
    /**
     * ***********************************************************
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;

        int currentMax = nums[0];
        int allTimeMax = nums[0];


        for(int i = 1; i <len;i++){
            allTimeMax = Math.max(nums[i]+allTimeMax,nums[i]);
            currentMax = Math.max(currentMax,allTimeMax);
        }
        return currentMax;
    }
    /**
     * ***********************************************************
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;

        return n == Math.pow(3, Math.round(Math.log(n)/Math.log(3)));

    }
    /**
     * ***********************************************************
     */
    public int romanToInt(String s) {

        Map<Character, Integer> keyToValue = new HashMap<>();
        keyToValue.put('I', 1);
        keyToValue.put('V', 5);
        keyToValue.put('X', 10);
        keyToValue.put('L', 50);
        keyToValue.put('C', 100);
        keyToValue.put('D', 500);
        keyToValue.put('M', 1000);

        int arabicNumerals = 0;
        int temp = 0;


        for(int i = 0; i<s.length(); i++){
            //grabbing every value from the map
            arabicNumerals = arabicNumerals + keyToValue.get(s.charAt(i));
            int extra = keyToValue.get(s.charAt(i));
            temp += extra;
            //grabbing the
            if(i > 0 && keyToValue.get(s.charAt(i-1)) <keyToValue.get(s.charAt(i))){
                temp = temp -2* keyToValue.get(s.charAt(i-1));

            }

        }

        return temp;
    }
    /**
     * ***********************************************************
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstPointer = m-1;
        int secondPointer = n-1;
        int index = m+n-1;

        while(secondPointer >=0){
            if(firstPointer >= 0 && nums1[firstPointer] > nums2[secondPointer]){
                nums1[index] = nums1[firstPointer];
                index--;
                firstPointer--;
            }
            else
            {
                nums1[index] = nums2[secondPointer];
                index--;
                secondPointer--;
            }
        }
    }
    /**
     * ***********************************************************
     */
    public boolean isBadVersion(int test){
        //method is different in leetcode.

        if(test != 0){
            return false;
        }
        return true;

    }
    /**
     * ***********************************************************
     */
    public int firstBadVersion(int n) {

        int start = 0;
        int end = n;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    /**
     * ***********************************************************
     */
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>(n+1);

        int start = 1;
        int end   = n;

        for(int i = 1; i<=n; i++){

            if(i%15 == 0){
                list.add("FizzBuzz");
            }
            else if(i%3 == 0){
                list.add("Fizz");
            }
            else if(i%5 == 0){
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    /**
     * ***********************************************************
     */
    private int val;

    private Stack<Integer> stack;

    public int MinStack() { // the constructor of a MinStack class but since its annoying to add classes all the
                            // time so i just add constructor with a return type of int to remove errors.
        stack = new Stack<Integer>();
        return 0;
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.stream().min(Integer::compare).get();
    }
    /**
     * ***********************************************************
     */
    public int hammingWeight(int n) {
        String bit = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < bit.length(); i++){
            if(bit.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
    public int reverseBits(int n) {
        String bit = Integer.toBinaryString(n);
        StringBuilder strBuild = new StringBuilder(bit);

        for(int i = 0; i < bit.length(); i++){

            if(bit.charAt(i) == '1'){
                strBuild.append('0');
            }else{
                strBuild.append('1');
            }
        }
        return Integer.parseInt(String.valueOf(strBuild));
    }

    public int missingNumber(int[] nums) {
        int checkNumber = 0;
        int saveMissing = 0;
        mergeSort(nums, 0 ,nums.length-1);
        System.out.println(mergeSort(nums,0,nums.length-1));

        for(int i = 0; i<nums.length-3+1; i++){
            if (nums[i] == nums[i + 2] - 2) {
                return saveMissing = nums[i];
            }
            checkNumber++;
        }
        return saveMissing;
    }

    //merge sort
    public void merge(int[] arr, int left, int middle, int right){

        int low  = middle- left+1;
        int high = right - middle;

        int L[]  = new int [low];
        int R[]  = new int [high];

        int i = 0;
        int j = 0;

        for(i = 0; i < low; i++){
            L[i] = arr[left + i];
        }

        for(j = 0; j < high; j++){
            R[j] = arr[middle + 1 + j];
        }

        int k = left;
        i = 0;
        j = 0;

        while(i < low && j < high){
            if(L[i] <= R[j]){

                arr[k] = L[i];
                i++;

            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < low){

            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < high){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public int[] mergeSort (int[] arr, int left, int right){

        int middle;

        if(left < right){
            middle = (left+right) / 2;

            mergeSort(arr, left , middle);
            mergeSort(arr, middle+1 , right);

            merge(arr, left, middle, right);
        }
        return (arr);
    }

    //finito?

}

