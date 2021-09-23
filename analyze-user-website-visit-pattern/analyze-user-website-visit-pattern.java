class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < username.length; ++i){
            graph.computeIfAbsent(username[i], k -> new ArrayList<>())
                .add(new Pair(website[i], timestamp[i]));
        }
        
        for (List<Pair> value : graph.values()){
            Collections.sort(value, (a, b)->a.time - b.time);
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        String mostVisited = "";
        for (var key : graph.keySet()){
            List<Pair> websites = graph.get(key);
            Set<String> patterns = new HashSet<>();
            
            int n = websites.size();
            for (int i = 0; i < n-2; ++i){
                for (int j = i+1; j < n-1; ++j){
                    for (int k = j+1; k < n; ++k){
                        String pattern = websites.get(i).website + ";" + websites.get(j).website + ";" 
                            + websites.get(k).website;
                        
                        if (!patterns.contains(pattern)){
                            countMap.put(pattern, countMap.getOrDefault(pattern, 0) + 1);
                            patterns.add(pattern);
                        }
                        
                        if (mostVisited.equals("") || countMap.get(mostVisited) < countMap.get(pattern)
                           || (countMap.get(mostVisited) == countMap.get(pattern) && mostVisited.compareTo(pattern) > 0)){
                            mostVisited = pattern;
                        }
                    }
                }
            }
        }
        
        //System.out.println(countMap);
        
        List<String> res = new ArrayList<>();
        for (String site : mostVisited.split(";")){
            res.add(site);
        }
        return res;
    }
}

class Pair{
    String website;
    int time;
    Pair (String website, int time){
        this.website = website;
        this.time = time;
    }
    
    
}

//joe -> home:1, about:2, career:3, 
//james -> home:4, cart:5, maps:6, home:7
//mary -> home:8, about:9, career:10