// Time: O(N^4) (since N is small), 
//Space: O(N^3)


class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;

        // Step 1: Gather all visits and sort by timestamp
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new Visit(timestamp[i], username[i], website[i]));
        }
        // Simple comparator
        Collections.sort(visits, new Comparator<Visit>() {
            public int compare(Visit a, Visit b) {
                return a.time - b.time;
            }
        });

        // Step 2: Build mapping from user -> ordered list of websites
        Map<String, List<String>> userToWeb = new HashMap<>();
        for (Visit v : visits) {
            if (!userToWeb.containsKey(v.name)) {
                userToWeb.put(v.name, new ArrayList<String>());
            }
            userToWeb.get(v.name).add(v.site);
        }

        // Step 3: Count how many users saw each 3-website pattern
        Map<String, Set<String>> patternToUsers = new HashMap<>();
        for (String user : userToWeb.keySet()) {
            List<String> webs = userToWeb.get(user);
            int m = webs.size();
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = i+1; j < m; j++) {
                    for (int k = j+1; k < m; k++) {
                        String pat = webs.get(i) + " " + webs.get(j) + " " + webs.get(k);
                        if (!seen.contains(pat)) {
                            if (!patternToUsers.containsKey(pat)) {
                                patternToUsers.put(pat, new HashSet<String>());
                            }
                            patternToUsers.get(pat).add(user);
                            seen.add(pat);
                        }
                    }
                }
            }
        }

        // Step 4: Find the most visited pattern
        int bestScore = 0;
        String bestPattern = "";
        for (String pat : patternToUsers.keySet()) {
            int score = patternToUsers.get(pat).size();
            if (score > bestScore || (score == bestScore && pat.compareTo(bestPattern) < 0)) {
                bestScore = score;
                bestPattern = pat;
            }
        }
        // Step 5: Split pattern into result list
        String[] resultArr = bestPattern.split(" ");
        List<String> result = new ArrayList<>();
        for (String s : resultArr) result.add(s);
        return result;
    }

    // Visit class for easier storage
    static class Visit {
        int time;
        String name;
        String site;
        Visit(int t, String n, String s) { time = t; name = n; site = s; }
    }
}
