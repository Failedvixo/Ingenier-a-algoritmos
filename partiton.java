class Solution {
    public boolean sums(subset, k){
        int[] sumList= new int[k];

        for(int i=0; i<k; i++){
            if(subset.get(i)==null){
                return false;
            }
            int size= subset.get(i).size();
            for(int j=0; j<subset; j++){
                sumList[i]=sumList[i]+subset.get(i).get(j);
            }
        }

        Set<Integer> s = new HashSet<>(Arrays.asList(sumList));
        return (s.size() == 1);
    }


    public boolean backtracking(int[] nums, int k, List<List<Integer> subsets){
        if(sums(subset, k)){
            return true;
        }
        
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        List<List<Integer>> subsets = new ArrayList<>();
        return backtracking(nums, k, subsets);
    }
}