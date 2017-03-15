public int binarySearch(int[] a, int start, int end, int target) {
        if(start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if(a[mid] == target)
            return mid;
        else if(a[mid] > target)
            return binarySearch(a, start, mid-1, target);
        else
            return binarySearch(a, mid+1, end, target);
    }
